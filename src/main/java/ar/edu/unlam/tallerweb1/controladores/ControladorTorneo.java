package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Fecha;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipoImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioFechaImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartidoImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneoImpl;

@Controller
public class ControladorTorneo {
	
	ServicioTorneoImpl servicioTorneo = new ServicioTorneoImpl();
	ServicioFechaImpl servicioFecha = new ServicioFechaImpl();
	ServicioPartidoImpl servicioPartido = new ServicioPartidoImpl();
	ServicioEquipoImpl servicioEquipo = new ServicioEquipoImpl();
	
	
	@RequestMapping("/liguilla")
	public ModelAndView crearFixture() {
		
		Integer cantidadDeEquipos = servicioEquipo.listarTodosLosEquipo().size();
		Integer cantidadDeFechas = cantidadDeEquipos/2;
		Integer cantidadDePartidosPorFecha = cantidadDeEquipos-1;
		
		//creo un nuevo torneo
		Torneo torneo = new Torneo();
		torneo.setNombre("Torneo1");
		
		//creo todas las fechas 
		for (int i = 0; i<cantidadDeFechas;i++) {
			Fecha fecha = new Fecha();
			fecha.setNumero(i+1);
			fecha.setTorneo(torneo);
		}
		
		ModelMap modelo = new ModelMap();
		return new ModelAndView("fixture", modelo);
	}
}
