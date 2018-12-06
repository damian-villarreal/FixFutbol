package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.TablaDao;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Tabla;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

@Service("servicioTabla")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ServicioTablaImpl implements ServicioTabla {

	@Inject
	private TablaDao tablaDao;


	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public void guardarTabla(Tabla tabla) {
		tablaDao.save(tabla);
	}

	@Override
	public List<Tabla> listarTabla(Long idTorneo) {
		return tablaDao.orderDesc(idTorneo);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public void crearTabla(Torneo torneo, Equipo equipo) {
		Tabla tabla = new Tabla();
		tabla.setEquipo(equipo);
		tabla.setTorneo(torneo);
		tabla.setDiferenciagoles(0);
		tabla.setEmpatados(0);
		tabla.setGanados(0);
		tabla.setGolescontra(0);
		tabla.setGolesfavor(0);
		tabla.setJugados(0);
		tabla.setPerdidos(0);
		tabla.setPuntos(0);
		tablaDao.save(tabla);
	}

	@Override
	public List<Tabla> buscarPorTorneo(Long idTorneo) {
		List<Tabla> tabla = tablaDao.findByTournament(idTorneo);
		return tabla;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public void actualizarTabla(Partido partido) {

		Long idTorneo = partido.getFecha().getTorneo().getId();
		Long idLocal = partido.getEquipoLocal().getId();
		Long idVisitante = partido.getEquipoVisitante().getId();

		Tabla tablaLocal = buscarEquipoTorneo(idLocal, idTorneo);
		Tabla tablaVisitante = buscarEquipoTorneo(idVisitante, idTorneo);

		tablaLocal.setJugados(tablaLocal.getJugados() + 1);
		tablaLocal.setGolescontra(tablaLocal.getGolescontra() + partido.getGolesVisitantes());
		tablaLocal.setGolesfavor(tablaLocal.getGolesfavor() + partido.getGolesLocales());
		tablaLocal.setDiferenciagoles(tablaLocal.getGolesfavor() - tablaLocal.getGolescontra());

		tablaVisitante.setJugados(tablaVisitante.getJugados() + 1);
		tablaVisitante.setGolescontra(tablaVisitante.getGolescontra() + partido.getGolesLocales());
		tablaVisitante.setGolesfavor(tablaVisitante.getGolesfavor() + partido.getGolesVisitantes());
		tablaVisitante.setDiferenciagoles(tablaVisitante.getGolesfavor() - tablaVisitante.getGolescontra());

		if (partido.getGolesLocales() > partido.getGolesVisitantes()) {
			tablaLocal.setPuntos(tablaLocal.getPuntos() + 3);
			tablaLocal.setGanados(tablaLocal.getGanados() + 1);
			tablaVisitante.setPerdidos(tablaVisitante.getPerdidos() + 1);
		}

		else if (partido.getGolesLocales() < partido.getGolesVisitantes()) {
			tablaVisitante.setPuntos(tablaVisitante.getPuntos() + 3);
			tablaVisitante.setGanados(tablaVisitante.getGanados() + 1);
			tablaLocal.setPerdidos(tablaLocal.getPerdidos() + 1);
		}

		else {
			tablaLocal.setPuntos(tablaLocal.getPuntos() + 1);
			tablaLocal.setEmpatados(tablaLocal.getEmpatados() + 1);
			tablaVisitante.setPuntos(tablaVisitante.getPuntos() + 1);
			tablaVisitante.setEmpatados(tablaVisitante.getEmpatados() + 1);
		}

		tablaDao.update(tablaLocal);
		tablaDao.update(tablaVisitante);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public Tabla buscarEquipoTorneo(Long idEquipo, Long idTorneo) {
		Tabla tabla = tablaDao.findTeamAndTournament(idEquipo, idTorneo);
		return tabla;
	}

	@Override
	public boolean ValidarCampeonAnticipado(List<Tabla> tablas) {
		Tabla equipoPrimeroEnLaTabla = tablas.get(0);
		Tabla equipoSegundoEnLaTabla = tablas.get(1);
		Integer CantidadDePartidosAJugar = tablas.size() - 1;
		Integer CantidadDePartidosQueLeQuedanAlSegundo = CantidadDePartidosAJugar - equipoSegundoEnLaTabla.getJugados();

		if (equipoPrimeroEnLaTabla
				.getPuntos() > (equipoSegundoEnLaTabla.getPuntos() + (CantidadDePartidosQueLeQuedanAlSegundo * 3))) {
			return true;
		}
		return false;
	}

	
	

}
