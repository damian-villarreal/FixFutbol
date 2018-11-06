package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;

import ar.edu.unlam.tallerweb1.servicios.ServicioFecha;

import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;

import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;


@Controller
public class ControladorTorneo {
	
	@Inject
	private ServicioTorneo servicioTorneo;
	
	@Inject
	private ServicioFecha servicioFecha;
	
	@Inject
	private ServicioPartido servicioPartido;
	
	@Inject
	private ServicioEquipo servicioEquipo;
	
	
	@RequestMapping("/liguilla")
	public ModelAndView crearLiguilla() {
		
		ModelMap modelo = new ModelMap();
		return new ModelAndView("fixture", modelo);
	}
}
