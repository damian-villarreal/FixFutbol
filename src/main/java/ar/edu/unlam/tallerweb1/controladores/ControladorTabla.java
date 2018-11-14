package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Tabla;
import ar.edu.unlam.tallerweb1.servicios.ServicioEquipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioTabla;

@Controller
public class ControladorTabla {
	
	@Inject
	private ServicioTabla servicioTabla;
	
	@Inject
	private ServicioEquipo servicioEquipo;
	
	
	@RequestMapping ("/posiciones")
	public ModelAndView verposiciones(){
		ModelMap modelo = new ModelMap();
		java.util.List<Tabla> tabla = servicioTabla.listarTabla();
		modelo.put("tablas", tabla);
		return new ModelAndView ("tabla", modelo);
		
		
	}

}
