package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Fecha;
import ar.edu.unlam.tallerweb1.servicios.ServicioFecha;

@Controller
public class ControladorFiltroFechas {
	
	@Inject
	private ServicioFecha servicioFecha;

	@RequestMapping(path = "/filtroFechas" , method = RequestMethod.POST)
	public ModelAndView filtrarFechas() {
		ModelMap modelo = new ModelMap();
		Fecha fecha = new Fecha();
		List<Fecha> fechas = servicioFecha.listarTodosLasFechas(fecha);
		modelo.put("fechas", fechas );
		return new ModelAndView("liguilla",modelo);
	}
}
