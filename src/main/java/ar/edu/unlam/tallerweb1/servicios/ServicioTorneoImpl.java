package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.EquipoDao;
import ar.edu.unlam.tallerweb1.dao.FaseDao;
import ar.edu.unlam.tallerweb1.dao.PartidoDao;
import ar.edu.unlam.tallerweb1.dao.TorneoDao;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Fase;
import ar.edu.unlam.tallerweb1.modelo.Fecha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

@Service("servicioTorneo")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)

public class ServicioTorneoImpl implements ServicioTorneo {

	@Inject
	private TorneoDao torneoDao;
	
	/*@Inject
	private FechaDao fechaDao;*/
	
	@Inject
	private PartidoDao partidoDao;
	
	@Inject
	private EquipoDao equipoDao;
	
	@Inject
	private FaseDao faseDao;

	/*@Inject
	private ServicioEquipo servicioEquipo;*/
	
	private String faseOctavos;
    private String faseCuartos;
    private String faseSemiFinal;
    private String faseFinal;

    private String OCTAVOS_1;
    private String OCTAVOS_2;
    private String OCTAVOS_3;
    private String OCTAVOS_4;
    private String OCTAVOS_5;
    private String OCTAVOS_6;
    private String OCTAVOS_7;
    private String OCTAVOS_8;

    private String CUARTOS_1;
    private String CUARTOS_2;
    private String CUARTOS_3;
    private String CUARTOS_4;

    private String SEMIFINAL_1;
    private String SEMIFINAL_2;
    
    private String FINAL;


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

	public List<Partido> crearLiguilla() {

		Integer cantidadDeEquipos = equipoDao.findAll().size();
		Integer cantidadDeFechas = cantidadDeEquipos - 1;
		Integer cantidadDePartidosPorFecha = cantidadDeEquipos / 2;
		Long auxLocal = null;
		Long auxVisitante = null;

		Torneo torneo = new Torneo();

		for (Integer f = 0; f < cantidadDeFechas; f++) {
			Fecha fecha = new Fecha();
			fecha.setNumero(f + 1);
			fecha.setTorneo(torneo);
			torneo.setTipoTorneo("Liguilla");
			torneo.setNombre("Torneo "+String.valueOf(torneoDao.findAll().size()+1));

			auxVisitante = Long.valueOf(cantidadDeEquipos - f);
			auxLocal = 1L;

			for (Integer p = 0; p < cantidadDePartidosPorFecha; p++) {
				Partido partido = new Partido();
				partido.setFecha(fecha);

				if (p == 0) {
					partido.setEquipoLocal(equipoDao.findById(1L));
					partido.setEquipoVisitante(equipoDao.findById(Long.valueOf(cantidadDeEquipos - f)));
					auxVisitante = partido.getEquipoVisitante().getId();
					auxLocal = auxVisitante;
				}

				else {
					if (p == 1) {
						if (auxVisitante == Long.valueOf(cantidadDeEquipos)) {
							partido.setEquipoLocal(equipoDao.findById(2L));
						} else {
							partido.setEquipoLocal(equipoDao.findById(auxVisitante + 1L));
						}
						auxLocal = partido.getEquipoLocal().getId();

						if (auxVisitante == 2L) {
							partido.setEquipoVisitante(equipoDao.findById(Long.valueOf(cantidadDeEquipos)));
						} else {
							partido.setEquipoVisitante(equipoDao.findById(auxVisitante - 1L));
						}
						auxVisitante = partido.getEquipoVisitante().getId();
					}

					else {
						if (auxLocal == Long.valueOf(cantidadDeEquipos)) {
							partido.setEquipoLocal(equipoDao.findById(2L));
						} else {
							partido.setEquipoLocal(equipoDao.findById(auxLocal + 1L));
						}
						auxLocal = partido.getEquipoLocal().getId();

						if (auxVisitante == 2L) {
							partido.setEquipoVisitante(equipoDao.findById(Long.valueOf(cantidadDeEquipos)));
						} else {
							partido.setEquipoVisitante(equipoDao.findById(auxVisitante - 1L));
						}
						auxVisitante = partido.getEquipoVisitante().getId();
					}
				}
				partidoDao.save(partido);
			}
		}
		
		
		return partidoDao.findByTournament(torneo.getId());
	}
	
	@Override
	public List<Partido> crearEliminacion() {
		
		Equipo river = equipoDao.findByName("River Plate");
		Equipo boca = equipoDao.findByName("Boca Juniors");
		Equipo racing = equipoDao.findByName("Racing Club");
		Equipo independiente = equipoDao.findByName("Independiente");
		Equipo sanLorenzo = equipoDao.findByName("San Lorenzo");
		Equipo defensa = equipoDao.findByName("Defensa y Justicia");
		Equipo central = equipoDao.findByName("Rosario Central");
		Equipo newells = equipoDao.findByName("Newells");
		Equipo estudiantes = equipoDao.findByName("Estudiantes LP");
		Equipo gimnasia = equipoDao.findByName("Gimnasia LP");
		Equipo atlTucuman = equipoDao.findByName("Atletico Tucuman");
		Equipo smTucuman = equipoDao.findByName("San Martin de Tucuman");
		Equipo velez = equipoDao.findByName("Velez Sarfield");
		Equipo godoy = equipoDao.findByName("Godoy Cruz");
		Equipo tigre = equipoDao.findByName("Tigre");
		Equipo colon = equipoDao.findByName("colon");
		
		Fase octavos1 = faseDao.readFase(OCTAVOS_1, faseOctavos);
		Fase octavos2 = faseDao.readFase(OCTAVOS_2, faseOctavos);
		Fase octavos3 = faseDao.readFase(OCTAVOS_3, faseOctavos);
		Fase octavos4 = faseDao.readFase(OCTAVOS_4, faseOctavos);
		Fase octavos5 = faseDao.readFase(OCTAVOS_5, faseOctavos);
		Fase octavos6 = faseDao.readFase(OCTAVOS_6, faseOctavos);
		Fase octavos7 = faseDao.readFase(OCTAVOS_7, faseOctavos);
		Fase octavos8 = faseDao.readFase(OCTAVOS_8, faseOctavos);
		
		Fase cuartos1 = faseDao.readFase(CUARTOS_1, faseCuartos);
		Fase cuartos2 = faseDao.readFase(CUARTOS_2, faseCuartos);
		Fase cuartos3 = faseDao.readFase(CUARTOS_3, faseCuartos);
		Fase cuartos4 = faseDao.readFase(CUARTOS_4, faseCuartos);
		
		Fase semi1 = faseDao.readFase(SEMIFINAL_1, faseSemiFinal);
		Fase semi2 = faseDao.readFase(SEMIFINAL_2, faseSemiFinal);
		
		Fase partidofinal = faseDao.readFase(FINAL, faseFinal);
		
		List<Partido> partidos = new ArrayList<>();
		
		partidos.add(new Partido(river, smTucuman, octavos1));
		partidos.add(new Partido(racing, velez, octavos2));
		partidos.add(new Partido(boca, colon, octavos3));
		partidos.add(new Partido(independiente, newells, octavos4));
		partidos.add(new Partido(sanLorenzo, tigre, octavos5));
		partidos.add(new Partido(estudiantes, atlTucuman, octavos6));
		partidos.add(new Partido(gimnasia, godoy, octavos7));
		partidos.add(new Partido(defensa, central, octavos8));
		
		partidos.add(new Partido(null, null, cuartos1));
		partidos.add(new Partido(null, null, cuartos2));
		partidos.add(new Partido(null, null, cuartos3));
		partidos.add(new Partido(null, null, cuartos4));
		
		partidos.add(new Partido(null, null, semi1));
		partidos.add(new Partido(null, null, semi2));
		
		partidos.add(new Partido(null, null, partidofinal));
		
		return partidos;		
	}
	

	@Override
	public void calcularEquipoQuePasaALaSiguienteFase(List<Partido> partidos, Fase fase) {
		
		Partido pasaALaSiguienteFase = null; 
		Equipo equipoLocal = ((Partido) partidos).getEquipoLocal();
		Equipo equipoVisitante = ((Partido) partidos).getEquipoVisitante();
		
		if(((Partido) partidos).getIsTerminado()==true) {
			if(((Partido) partidos).getGanador().equals(equipoLocal));
				pasaALaSiguienteFase.setEquipoLocal(equipoLocal);
			} else {
				pasaALaSiguienteFase.setEquipoVisitante(equipoVisitante);
				}
		
		partidoDao.update(pasaALaSiguienteFase);
	}
}
