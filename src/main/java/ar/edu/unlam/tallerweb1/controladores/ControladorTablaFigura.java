package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Figura;
import ar.edu.unlam.tallerweb1.modelo.FiguraTabla;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioFigura;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioTabla;

@Controller
public class ControladorTablaFigura {
	
	@Inject
	private ServicioFigura servicioFigura;
	@Inject
	private ServicioPartido servicioPartido;
	
	@RequestMapping ("/figuras")
	public ModelAndView verFigura(@RequestParam(name = "idTorneo") Long idTorneo){
		ModelMap modelo = new ModelMap();		
		List<Figura> figuras = servicioFigura.listarFiguras();
		List<FiguraTabla> figuraTabla = servicioFigura.listarFiguraTabla(idTorneo);
		modelo.put("figuras", figuraTabla);
		return new ModelAndView ("figuras", modelo);
	}
		
}
