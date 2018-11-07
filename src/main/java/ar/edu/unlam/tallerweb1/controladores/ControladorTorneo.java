package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;

import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;


@Controller
public class ControladorTorneo {
	
	@Inject
	private ServicioTorneo servicioTorneo;
	
	@Inject
	private ServicioEquipo servicioEquipo;
	
	@RequestMapping(path = "fixture" , method = RequestMethod.POST)
	public ModelAndView consultarTorneo(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		Torneo torneo = new Torneo();
		modelo.put("torneo", torneo);
		
		List<Torneo> torneos = servicioTorneo.listarTodosLosTorneos();
		modelo.put("torneos", torneos);
		
		return new ModelAndView("fixture",modelo);
	}
	
	@RequestMapping(path = "crear-torneo" , method = RequestMethod.POST)
	public ModelAndView crearTorneo(@ModelAttribute("torneo") Torneo torneo , HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		if(servicioTorneo.consultarTorneo(torneo) == null) {
			servicioTorneo.guardarTorneo(torneo);
			modelo.put("aviso", "Se creo la liguilla correctamente");
		} else {
			modelo.put("aviso", "No se pudo crear la liguilla correctamente");
		}
		
		Torneo torneoNuevo = new Torneo();
		modelo.put("torneo", torneoNuevo);
		
		List<Equipo> equipos = servicioEquipo.listarTodosLosEquipo();
		modelo.put("equipos", equipos);
		
		List<Equipo> equiposSinPartidos = servicioEquipo.traerEquiposQueNoJueganPartidos(equipos);
		modelo.put("equiposSinPartidos", equiposSinPartidos);
		
		return new ModelAndView("fixture", modelo);
	}
	
	@RequestMapping(path = "actualizar-torneo" , method = RequestMethod.POST)
	public ModelAndView actualizarTorneo(@ModelAttribute("torneo") Torneo torneo , HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		if(servicioTorneo.consultarTorneo(torneo) == null) {
			servicioTorneo.actualizarTorneo(torneo);
			modelo.put("aviso", "Se actualizo correctamente");
		} else {
			modelo.put("aviso", "El nombre se encuentra en uso");
		}
		
		Torneo torneoCreado = new Torneo();
		modelo.put("torneo", torneoCreado);
		
		List<Equipo> equipos = servicioEquipo.listarTodosLosEquipo();
		modelo.put("equipos", equipos);
		
		List<Equipo> equiposSinEncuentros = servicioEquipo.traerEquiposQueNoJueganPartidos(equipos);
		modelo.put("equiposSinPartidos", equiposSinEncuentros);
		
		return new ModelAndView("fixture",modelo);
	}
	
	@RequestMapping("/fixture")
	public ModelAndView fixture() {
		ModelMap modelo = new ModelMap();
		return new ModelAndView("fixture",modelo);
	}
}
