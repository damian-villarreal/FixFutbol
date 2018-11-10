package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.List;
import java.util.Arrays;


import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.EquipoDao;
import ar.edu.unlam.tallerweb1.dao.EquipoDaoImpl;
import ar.edu.unlam.tallerweb1.dao.FechaDao;
import ar.edu.unlam.tallerweb1.dao.PartidoDao;
import ar.edu.unlam.tallerweb1.dao.TorneoDao;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Fecha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

@Service("servicioTorneo")
@Transactional(readOnly = true , propagation = Propagation.SUPPORTS)

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
	@Transactional(readOnly = false , propagation = Propagation.REQUIRED , rollbackFor = { Exception.class } )
	public void guardarTorneo(Torneo torneo) {
		torneoDao.save(torneo);
	}

	@Override
	@Transactional(readOnly = false , propagation = Propagation.REQUIRED , rollbackFor = { Exception.class } )
	public void actualizarTorneo(Torneo torneo) {
		torneoDao.update(torneo);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Partido> crearLiguilla(Equipo equipoLocal, Equipo equipoVisitante) {
//		
//		ServicioEquipoImpl servicioEquipo = new ServicioEquipoImpl();
//		List<Partido> listaDePartidos = new ArrayList<>();
//		List<Equipo> listaDeEquipos = new ArrayList<>();
//		
//		Integer cantidadDeEquipos = servicioEquipo.listarTodosLosEquipo().size();
//		Integer cantidadDeFechas = cantidadDeEquipos/2;
//		//Integer cantidadDePartidosPorFecha = cantidadDeEquipos-1;
//		
//		//creo un nuevo torneo
//		Torneo torneo = new Torneo();
//		torneo.setNombre("Torneo1");
//		
//		//creo todas las fechas 
//		for (Integer i = 0; i<cantidadDeFechas;i++) {
//			Fecha fecha = new Fecha();
//			fecha.setNumero(i+1);
//			fecha.setTorneo(torneo);
//		}
//		
//		//se generan los cruces
//		for(Integer i=0; i<cantidadDeEquipos; i++){
//			for(Integer j=0; j<cantidadDeEquipos; j++){
//				if(listaDeEquipos.get(i) != listaDeEquipos.get(j)) {
//					listaDePartidos= (List<Partido>) new Partido(listaDeEquipos.get(i), listaDeEquipos.get(j));
//				}
//			}
//		}
//		return listaDePartidos;
//	}

	@Override
	public Torneo consultarTorneo(Torneo torneo) {
		return torneoDao.findByTournament(torneo);
	}

	@Override
	public List<Torneo> listarTodosLosTorneos() {
		return torneoDao.findAll();
	}
	
	@Override
<<<<<<< HEAD
	
	public void crearLiguilla() {
		Torneo torneo = new Torneo();
		torneo.setNombre("Torneo1");
		Integer cantidadDeEquipos = equipoDao.findAll().size();		
		Integer cantidadDePartidosPorFecha = cantidadDeEquipos/2;
=======
	public  void crearLiguilla() {
		
		Integer cantidadDeEquipos = servicioEquipo.listarTodosLosEquipo().size();
>>>>>>> 513914c2c2eeea5945c164c1574c21517afd193d
		Integer cantidadDeFechas = cantidadDeEquipos-1;
		
		Long auxLocal = null;
		Long auxVisitante = null;
		
		//creo todas las fechas
		for (int f=1; f<=cantidadDeFechas;f++) {
			Fecha fecha = new Fecha();
			fecha.setNumero(f+1);
			fecha.setTorneo(torneo);
			fechaDao.save(fecha);
		
<<<<<<< HEAD
		//primer partido de cada fecha
		
		Partido primerPartido = new Partido();
		primerPartido.setFecha(fecha);
		primerPartido.setEquipoLocal(equipoDao.findById(1L));
		int c=cantidadDeEquipos-f
		primerPartido.setEquipoVisitante(equipoDao.findById((long)(cantidadDeEquipos-f)));
		
		partidoDao.save(primerPartido);
		
		//creo el resto de los partidos de la primer fecha
		
		for(int i=2; i>=cantidadDePartidosPorFecha;i++) {
			Partido partido = new Partido();
			partido.setEquipoLocal(equipoDao.findById((long)i));
			partido.setEquipoVisitante(equipoDao.findById((long)cantidadDeEquipos-i+1));
			auxLocal=partido.getEquipoLocal().getId();
			auxVisitante=partido.getEquipoVisitante().getId();
			partido.setFecha(fecha);
			partidoDao.save(partido);
		}
		
		//creo el resto de los partidos
		for (int p=2;p<=cantidadDePartidosPorFecha;p++) {
			Partido partido = new Partido();
			
			if(auxLocal == 2) {
				partido.setEquipoLocal(equipoDao.findById((long)cantidadDeEquipos));
			}
			else {
				partido.setEquipoLocal(equipoDao.findById(auxLocal-1));
			}
			
			if(auxVisitante == 2) {
				partido.setEquipoVisitante(equipoDao.findById((long)cantidadDeEquipos));
			}
			else {
				partido.setEquipoVisitante(equipoDao.findById(auxVisitante-1));
			}
			partido.setFecha(fecha);
			partidoDao.save(partido);
			}
		}	
	}						
=======
			for(int j=0; j< cantidadDePartidosPorFecha; j++) {
				
				Partido partido = new Partido();
				partido.setFecha(fecha);
				//aca va la logica para ir rotando los equipos segun el numero de fecha
				Equipo equipoLocal = equipoDao.findById(j);
				Equipo equipoVisitante = equipoDao.findById(j+2);
				
				partido.setEquipoLocal(equipoLocal);
				partido.setEquipoVisitante(equipoVisitante);
				partidoDao.save(partido);
			}
		}		
	}
>>>>>>> 513914c2c2eeea5945c164c1574c21517afd193d
}

