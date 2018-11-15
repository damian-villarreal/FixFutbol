package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import ar.edu.unlam.tallerweb1.modelo.Tabla;
import ar.edu.unlam.tallerweb1.servicios.ServicioTabla;

@Controller
public class ControladorTabla {
	
	@Inject
	private ServicioTabla servicioTabla;
	
	
	
	@RequestMapping ("/posiciones")
	public ModelAndView verPosiciones(){
		ModelMap modelo = new ModelMap();
		List<Tabla> tabla = servicioTabla.listarTabla();
		modelo.put("tablas", tabla);
		return new ModelAndView ("tabla", modelo);
		
		
	}

}
