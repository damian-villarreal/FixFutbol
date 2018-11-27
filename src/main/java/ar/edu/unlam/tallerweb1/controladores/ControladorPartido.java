package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioTabla;

@Controller
public class ControladorPartido {

	@Inject
	public ServicioPartido servicioPartido;

	@Inject
	public ServicioTabla servicioTabla;

	@RequestMapping(path = "/cargar-resultado")
	public ModelAndView cargarResultado(@RequestParam(value = "idPartido") Long idPartido) {
		ModelMap modelo = new ModelMap();
		Partido partido = servicioPartido.buscarPorId(idPartido);
		modelo.put("partido", partido);
		return new ModelAndView("cargar-resultado", modelo);
	}

	@RequestMapping(path = "/guardar-resultado", method = RequestMethod.POST)
	public ModelAndView guardarResultado(@ModelAttribute("partido") Partido partido) {
		servicioPartido.ActualizarResultado(partido);
		Partido partidoActualizarTabla = servicioPartido.buscarPorId(partido.getId());
		servicioTabla.actualizarTabla(partidoActualizarTabla);
		return new ModelAndView("redirect:index");
	}
}
