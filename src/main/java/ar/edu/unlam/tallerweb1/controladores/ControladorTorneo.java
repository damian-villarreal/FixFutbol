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
	public ModelAndView crearLiguilla() {
		
		ModelMap modelo = new ModelMap();
		return new ModelAndView("fixture", modelo);
	}
}
