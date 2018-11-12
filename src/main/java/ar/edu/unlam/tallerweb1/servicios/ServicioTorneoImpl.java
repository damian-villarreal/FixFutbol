package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.EquipoDao;
import ar.edu.unlam.tallerweb1.dao.FechaDao;
import ar.edu.unlam.tallerweb1.dao.PartidoDao;
import ar.edu.unlam.tallerweb1.dao.TorneoDao;
import ar.edu.unlam.tallerweb1.modelo.Fecha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

@Service("servicioTorneo")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)

public class ServicioTorneoImpl implements ServicioTorneo {

	@Inject
	private TorneoDao torneoDao;
	@Inject
	private FechaDao fechaDao;
	@Inject
	private PartidoDao partidoDao;
	@Inject
	private EquipoDao equipoDao;

	@Inject
	private ServicioEquipo servicioEquipo;

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

	@Override
	public void crearLiguilla() {

		Integer cantidadDeEquipos = equipoDao.findAll().size();
		Integer cantidadDeFechas = cantidadDeEquipos - 1;
		Integer cantidadDePartidosPorFecha = cantidadDeEquipos / 2;
		Long auxLocal = null;
		Long auxVisitante = null;

		Torneo torneo = new Torneo();

		for (int f = 0; f < cantidadDeFechas; f++) {
			Fecha fecha = new Fecha();
			fecha.setNumero(f + 1);
			fecha.setTorneo(torneo);

			for (int p = 0; p < cantidadDePartidosPorFecha; p++) {
				Partido partido = new Partido();
				partido.setFecha(fecha);

				if (p == 0) {
					partido.setEquipoLocal(equipoDao.findById(1L));
					partido.setEquipoVisitante(equipoDao.findById(Long.valueOf(cantidadDeEquipos - f)));
					auxLocal = partido.getEquipoLocal().getId();
					auxVisitante = partido.getEquipoVisitante().getId();

				
				} else {

					if (auxLocal == 1L || auxLocal == Long.valueOf(cantidadDeEquipos)) {

						partido.setEquipoLocal(equipoDao.findById(2L));
						auxLocal = partido.getEquipoLocal().getId();

					} else {
						partido.setEquipoLocal(equipoDao.findById(auxLocal + 1));
						auxLocal = partido.getEquipoLocal().getId();

					}

					if (auxVisitante == 2) {
						partido.setEquipoVisitante(equipoDao.findById(Long.valueOf(cantidadDeEquipos)));
						auxVisitante = partido.getEquipoVisitante().getId();

					} else {
						partido.setEquipoVisitante(equipoDao.findById(auxVisitante - 1));
						auxVisitante = partido.getEquipoVisitante().getId();

					partidoDao.save(partido);
					}
				}
			}
		}
	}

}
