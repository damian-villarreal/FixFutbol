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
	public  void crearLiguilla() {
		
		Integer cantidadDeEquipos = servicioEquipo.listarTodosLosEquipo().size();
		Integer cantidadDeFechas = cantidadDeEquipos-1;
		Integer cantidadDePartidosPorFecha = cantidadDeFechas;
		
		Torneo torneo = new Torneo();
		torneo.setNombre("nombreTorneo");
		torneoDao.save(torneo);
		
		for(int i=0;i<cantidadDeFechas;i++) {
			
			Fecha fecha = new Fecha();
			fecha.setNumero(i);
			fecha.setTorneo(torneo);
			fechaDao.save(fecha);
		
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
}
