package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

import ar.edu.unlam.tallerweb1.modelo.Fecha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Tabla;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ServicioTabla;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;

@Controller
public class ControladorTabla {
	
	@Inject
	private ServicioTabla servicioTabla;
	
	@Inject
	private ServicioTorneo servicioTorneo;
	
	@RequestMapping ("/detalle-posiciones")
	public ModelAndView verPosiciones(@RequestParam(name = "idTorneo") Long idTorneo){
		ModelMap modelo = new ModelMap();
		List<Tabla> tablas = servicioTabla.buscarPorTorneo(idTorneo);
		modelo.put("tablas", tablas);
		return new ModelAndView ("detalle-posiciones", modelo);
	}
		
	@RequestMapping(path = "/posiciones-torneo")
	public ModelAndView VerPosiciones() {
		List<Torneo> torneos = servicioTorneo.listarTodosLosTorneos();
		ModelMap modelo = new ModelMap();
		modelo.put("torneos", torneos);
		return new ModelAndView("posiciones-torneo", modelo);
	}
	
}
