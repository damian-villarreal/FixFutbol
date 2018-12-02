package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Fecha;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioTabla;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;

@Controller
public class ControladorTorneo {

	@Inject
	private ServicioTorneo servicioTorneo;

	@Inject
	private ServicioEquipo servicioEquipo;

	@Inject
	private ServicioPartido servicioPartido;
	
	@Inject
	private ServicioTabla servicioTabla;
	

//	@RequestMapping(path = "fixture", method = RequestMethod.POST)
//	public ModelAndView consultarTorneo(HttpServletRequest request) {
//		ModelMap modelo = new ModelMap();
//		Torneo torneo = new Torneo();
//		modelo.put("torneo", torneo);
//		List<Torneo> torneos = servicioTorneo.listarTodosLosTorneos();
//		modelo.put("torneos", torneos);
//		return new ModelAndView("fixture", modelo);
//	}

//	@RequestMapping(path = "crear-torneo", method = RequestMethod.POST)
//	public ModelAndView crearTorneo(@ModelAttribute("torneo") Torneo torneo) {
//		ModelMap modelo = new ModelMap();
//		if (servicioTorneo.consultarTorneo(torneo) == null) {
//			servicioTorneo.guardarTorneo(torneo);
//			modelo.put("aviso", "Se creo la liguilla correctamente");
//		} else {
//			modelo.put("aviso", "No se pudo crear la liguilla correctamente");
//		}
//
//		Torneo torneoNuevo = new Torneo();
//		modelo.put("torneo", torneoNuevo);
//
//		List<Equipo> equipos = servicioEquipo.listarTodosLosEquipo();
//		modelo.put("equipos", equipos);
//
//		List<Equipo> equiposSinPartidos = servicioEquipo.traerEquiposQueNoJueganPartidos(equipos);
//		modelo.put("equiposSinPartidos", equiposSinPartidos);
//
//		return new ModelAndView("fixture", modelo);
//	}

//	@RequestMapping(path = "actualizar-torneo", method = RequestMethod.POST)
//	public ModelAndView actualizarTorneo(@ModelAttribute("torneo") Torneo torneo, HttpServletRequest request) {
//		ModelMap modelo = new ModelMap();
//
//		if (servicioTorneo.consultarTorneo(torneo) == null) {
//			servicioTorneo.actualizarTorneo(torneo);
//			modelo.put("aviso", "Se actualizo correctamente");
//		} else {
//			modelo.put("aviso", "El nombre se encuentra en uso");
//		}
//
//		Torneo torneoCreado = new Torneo();
//		modelo.put("torneo", torneoCreado);
//
//		List<Equipo> equipos = servicioEquipo.listarTodosLosEquipo();
//		modelo.put("equipos", equipos);
//
//		List<Equipo> equiposSinEncuentros = servicioEquipo.traerEquiposQueNoJueganPartidos(equipos);
//		modelo.put("equiposSinPartidos", equiposSinEncuentros);
//
//		return new ModelAndView("fixture", modelo);
//	}

	@RequestMapping(path = "/crear-liguilla")
	public ModelAndView crearLiguilla() {
		ModelMap modelo = new ModelMap();
		List<Partido> partidos = servicioTorneo.crearLiguilla();
		modelo.put("partidos", partidos);
		return new ModelAndView("liguilla", modelo);
	}

//	@RequestMapping(path = "/crear-eliminacion")
//	public ModelAndView CrearEliminacion() {
//		ModelMap modelo = new ModelMap();
//		List<Partido> partidos = servicioTorneo.crearEliminacion();
//		modelo.put("partidos", partidos);
//		return new ModelAndView("eliminacion", modelo);
//	}

//	@RequestMapping(path = "/crear-mundial")
//	public ModelAndView CrearMundial() {
//		ModelMap modelo = new ModelMap();
//		return new ModelAndView("mundial", modelo);
//	}

	@RequestMapping(path = "/ver-torneos")
	public ModelAndView VerTorneos() {
		List<Torneo> torneos = servicioTorneo.listarTodosLosTorneos();
		ModelMap modelo = new ModelMap();
		modelo.put("torneos", torneos);
		return new ModelAndView("ver-torneos", modelo);
	}

	/*
	 * @RequestMapping(path="/detalle-torneo/{id}" , method = RequestMethod.GET)
	 * public ModelAndView DetalleTorneo(@PathVariable Long id) { ModelMap modelo =
	 * new ModelMap(); List<Partido> partidos = servicioPartido.buscarPorTorneo(id);
	 * modelo.put("partidos", partidos); return new ModelAndView("detalle-torneo",
	 * modelo);
	 * 
	 * }
	 */

	@RequestMapping(path = "/detalle-torneo")
	public ModelAndView detalleTorneo(@RequestParam(name = "idTorneo") Long idTorneo) {
		ModelMap modelo = new ModelMap();
		List<Partido> partidos = servicioPartido.buscarPorTorneo(idTorneo);
		List<Fecha> fechas = servicioTorneo.obtenerFechas(idTorneo);
		
		if(servicioTorneo.validarTorneoFinalizado(idTorneo))
		{
			modelo.put("mensaje", "Torneo Finalizado. El campeon es: "+servicioTabla.listarTabla(idTorneo).get(0).getEquipo().getNombre());
		}		
		modelo.put("fechas", fechas);
		modelo.put("partidos", partidos);
		return new ModelAndView("detalle-torneo", modelo);
	}

	/*
	 * @RequestMapping(path = "filtroPorFechas" , method = RequestMethod.POST)
	 * public ModelAndView filtrarPorFechas(@ModelAttribute("fecha") Fecha fecha ,
	 * HttpServletRequest request) { ModelMap modelo = new ModelMap();
	 * 
	 * return new ModelAndView("liguilla",modelo); }
	 */

}
