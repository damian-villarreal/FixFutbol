package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.PartidoDao;
import ar.edu.unlam.tallerweb1.modelo.Figura;
import ar.edu.unlam.tallerweb1.modelo.Partido;

@Service("servicioPartido")
// Solo necesita leer, no escribir , y no tiene prioridad de generacion
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ServicioPartidoImpl implements ServicioPartido {

	@Inject
	private PartidoDao partidoDao;

	@Inject
	private ServicioTorneo servicioTorneo;

	@Inject
	private ServicioFigura servicioFigura;


	@Override
	public List<Partido> listarTodosLosPartidos() {
		return partidoDao.findAll();
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public void guardarPartido(Partido partido) {
		partidoDao.save(partido);

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public void actualizarPartido(Partido partido) {
		partidoDao.update(partido);
	}

	@Override
	public Partido buscarPorId(Long id) {
		return partidoDao.findById(id);
	}

	@Override
	public Partido consultarPartido(Partido partido) {
		return partidoDao.findById((Long) partido.getId());
	}

	@Override
	public List<Partido> listarTodosLosPartidosSinTerminar() {
		return partidoDao.findUnfinishedMatch();
	}

	@Override
	public List<Partido> buscarPorTorneo(Long id) {
		return partidoDao.findByTournament(id);
	}

	@Override
	public void ActualizarResultado(Partido partido) {
		Partido p = buscarPorId(partido.getId());
		p.setGolesLocales(partido.getGolesLocales());
		p.setGolesVisitantes(partido.getGolesVisitantes());
		p.setIsResultadoFinal(true);
		p.setIsTerminado(true);
		actualizarPartido(p);
		servicioTorneo.actualizarPartidosJugados(p.getFecha().getTorneo().getId());
	}

	@Override
	public void actualizarFigura(Partido partido) {
		Partido p = buscarPorId(partido.getId());
		Figura figura = new Figura();
		figura = servicioFigura.buscarFigura(partido.getFigura());
		if (figura != null) {
			p.setFigura(figura);
			figura.setVecesFigura(figura.getVecesFigura()+1);
			servicioFigura.actualizarFigura(figura);
		} else {
			Figura f = new Figura();
			f.setNombreCompleto(partido.getFigura().getNombreCompleto());
			f.setEquipo(partido.getFigura().getEquipo());
			f.setVecesFigura(1);
			servicioFigura.guardarFigura(f);
			p.setFigura(f);
		}
		actualizarPartido(p);
	}
}