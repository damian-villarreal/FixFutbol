package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

import ar.edu.unlam.tallerweb1.modelo.Tabla;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ServicioTabla;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;

@Controller
public class ControladorTabla {

	@Inject
	private ServicioTabla servicioTabla;

	@Inject
	private ServicioTorneo servicioTorneo;

	@RequestMapping("/posiciones")
	public ModelAndView verPosiciones(@RequestParam(name = "idTorneo") Long idTorneo) {
		ModelMap modelo = new ModelMap();
		List<Tabla> tablas = servicioTabla.listarTabla(idTorneo);
		if (!(servicioTorneo.buscarPorId(idTorneo).getIsTerminado())) {
			if (servicioTabla.ValidarCampeonAnticipado(tablas)) {
				modelo.put("mensaje", "El Campeon es " + tablas.get(0).getEquipo().getNombre()
						+ ". Ya no hay equipos que lo puedan alcanzar");
			}
		} else {
			modelo.put("mensaje", "Torneo Finalizado! El campeon es: "
					+ servicioTabla.listarTabla(idTorneo).get(0).getEquipo().getNombre());
		}

		modelo.put("tablas", tablas);
		return new ModelAndView("posiciones", modelo);
	}

}
