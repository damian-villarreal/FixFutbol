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
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioTabla;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;

@Controller
public class ControladorTorneo {

	@Inject
	private ServicioTorneo servicioTorneo;

	@Inject
	private ServicioPartido servicioPartido;

	@Inject
	private ServicioTabla servicioTabla;

	@RequestMapping(path = "/crear-liguilla")
	public ModelAndView crearLiguilla() {
		ModelMap modelo = new ModelMap();
		Torneo torneo = servicioTorneo.crearLiguilla();
		List<Fecha> fechas = servicioTorneo.obtenerFechas(torneo.getId());
		List<Partido> partidos = servicioPartido.buscarPorTorneo(torneo.getId());
		modelo.put("fechas", fechas);
		modelo.put("partidos", partidos);
		return new ModelAndView("liguilla", modelo);
	}

	@RequestMapping(path = "/ver-torneos")
	public ModelAndView VerTorneos() {
		List<Torneo> torneos = servicioTorneo.listarTodosLosTorneos();
		ModelMap modelo = new ModelMap();
		modelo.put("torneos", torneos);
		return new ModelAndView("ver-torneos", modelo);
	}

	@RequestMapping(path = "/torneo")
	public ModelAndView detalleTorneo(@RequestParam(name = "idTorneo") Long idTorneo) {
		ModelMap modelo = new ModelMap();
		List<Partido> partidos = servicioPartido.buscarPorTorneo(idTorneo);
		List<Fecha> fechas = servicioTorneo.obtenerFechas(idTorneo);

		if (servicioTorneo.validarTorneoFinalizado(idTorneo)) {
			modelo.put("mensaje", "Torneo Finalizado! El campeon es: "
					+ servicioTabla.listarTabla(idTorneo).get(0).getEquipo().getNombre());
		}
		modelo.put("idTorneo", idTorneo);
		modelo.put("fechas", fechas);
		modelo.put("partidos", partidos);
		return new ModelAndView("torneo", modelo);
	}
}
