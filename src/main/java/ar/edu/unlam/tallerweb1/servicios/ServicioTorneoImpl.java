package ar.edu.unlam.tallerweb1.servicios;

import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.EquipoDao;
import ar.edu.unlam.tallerweb1.dao.PartidoDao;
import ar.edu.unlam.tallerweb1.dao.TorneoDao;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Fecha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

@Service("servicioTorneo")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)

public class ServicioTorneoImpl implements ServicioTorneo {

	@Inject
	private TorneoDao torneoDao;

	@Inject
	private ServicioTabla servicioTabla;

	@Inject
	private PartidoDao partidoDao;

	@Inject
	private EquipoDao equipoDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void guardarTorneo(Torneo torneo) {
		torneoDao.save(torneo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void actualizarTorneo(Torneo torneo) {
		torneoDao.update(torneo);
	}

	@Override
	public Torneo consultarTorneo(Torneo torneo) {
		return torneoDao.findByTournament(torneo);
	}

	@Override
	public List<Torneo> listarTodosLosTorneos() {
		return torneoDao.findAll();
	}

	public Torneo crearLiguilla() {
	
		if (equipoDao.findAll().size() % 2 == 0) {

			List<Equipo> equipos = equipoDao.findAll();

			Collections.shuffle(equipos);
			Integer cantidadDeEquipos = equipoDao.findAll().size();
			Integer cantidadDeFechas = cantidadDeEquipos - 1;
			Integer cantidadDePartidosPorFecha = cantidadDeEquipos / 2;
			Integer auxLocal = null;
			Integer auxVisitante = null;

			Torneo torneo = new Torneo();
			torneo.setCantPartidosJugados(0);
			torneo.setCantPartidos(cantidadDePartidosPorFecha * cantidadDeFechas);
			torneoDao.save(torneo);

			for (int t = 0; t < cantidadDeEquipos; t++) {
				servicioTabla.crearTabla(torneo, equipos.get(t));
			}

			for (int f = 0; f < cantidadDeFechas; f++) {
				Fecha fecha = new Fecha();
				fecha.setNumero(f + 1);
				fecha.setTorneo(torneo);
				torneo.setTipoTorneo("Liguilla");
				torneo.setNombre("Torneo " + String.valueOf(torneoDao.findAll().size()));

				auxVisitante = cantidadDeEquipos - f;
				auxLocal = 0;

				for (Integer p = 0; p < cantidadDePartidosPorFecha; p++) {
					Partido partido = new Partido();
					partido.setFecha(fecha);

					if (p == 0) {
						partido.setEquipoLocal(equipos.get(0));
						partido.setEquipoVisitante(equipos.get(cantidadDeEquipos - f - 1));
						auxVisitante = equipos.indexOf(partido.getEquipoVisitante());
						auxLocal = auxVisitante;
					}

					else {
						if (p == 1) {
							if (auxVisitante == cantidadDeEquipos - 1) {
								partido.setEquipoLocal(equipos.get(1));
							} else {
								partido.setEquipoLocal(equipos.get((auxVisitante + 1)));
							}
							auxLocal = equipos.indexOf(partido.getEquipoLocal());

							if (auxVisitante == 1) {
								partido.setEquipoVisitante(equipos.get(cantidadDeEquipos - 1));
							} else {
								partido.setEquipoVisitante(equipos.get(auxVisitante - 1));
							}
							auxVisitante = equipos.indexOf(partido.getEquipoVisitante());
						}

						else {
							if (auxLocal == (cantidadDeEquipos - 1)) {
								partido.setEquipoLocal(equipos.get(1));
							} else {
								partido.setEquipoLocal(equipos.get(auxLocal + 1));
							}
							auxLocal = equipos.indexOf(partido.getEquipoLocal());

							if (auxVisitante == 1) {
								partido.setEquipoVisitante(equipos.get(cantidadDeEquipos - 1));
							} else {
								partido.setEquipoVisitante(equipos.get(auxVisitante - 1));
							}
							auxVisitante = equipos.indexOf(partido.getEquipoVisitante());
						}
					}
					partidoDao.save(partido);
				}

			}
			return torneo;
		}
		return null;
	}

	@Override
	public Torneo buscarPorId(Long idTorneo) {
		return torneoDao.findById(idTorneo);
	}

	@Override
	public List<Fecha> obtenerFechas(Long idTorneo) {
		return torneoDao.getFechas(idTorneo);
	}

	@Override
	public boolean validarTorneoFinalizado(Long idTorneo) {
		Torneo torneo = buscarPorId(idTorneo);
		Integer cantidadDePartidosTorneo = torneo.getCantPartidos();
		Integer cantidadDePartidosJugados = torneo.getCantPartidosJugados();
		if (cantidadDePartidosJugados == cantidadDePartidosTorneo) {
			torneo.setIsTerminado(true);
			torneoDao.update(torneo);
		}
		return torneo.getIsTerminado();
	}

	@Override
	public void actualizarPartidosJugados(Long idTorneo) {
		Torneo torneo = torneoDao.findById(idTorneo);
		torneo.setCantPartidosJugados(torneo.getCantPartidosJugados() + 1);
		torneoDao.update(torneo);
	}

	public void obtenerFiguraDelTorneo(Long idTorneo) {

	}

}
