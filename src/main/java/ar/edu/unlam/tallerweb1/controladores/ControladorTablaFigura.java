package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Figura;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ServicioFigura;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;

@Controller
public class ControladorTablaFigura {
	
	@Inject
	private ServicioFigura servicioFigura;

	@Inject
	private ServicioTorneo servicioTorneo;
	
	@RequestMapping ("/detalle-figura")
	public ModelAndView verFigura(@RequestParam(name = "idTorneo") Long idTorneo){
		ModelMap modelo = new ModelMap();
		List<Figura> figuras = servicioFigura.listarFiguras(idTorneo);
		modelo.put("figuras", figuras);
		return new ModelAndView ("detalle-figura", modelo);
	}
		
	@RequestMapping(path = "/posiciones-figura")
	public ModelAndView VerPosiciones() {
		List<Torneo> torneos = servicioTorneo.listarTodosLosTorneos();
		ModelMap modelo = new ModelMap();
		modelo.put("torneos", torneos);
		return new ModelAndView("posiciones-figura", modelo);
	}
}
