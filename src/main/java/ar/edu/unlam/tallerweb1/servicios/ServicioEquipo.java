package ar.edu.unlam.tallerweb1.servicios;

import java.util.*;
import ar.edu.unlam.tallerweb1.modelo.*;

public interface ServicioEquipo {

	List<Equipo> listarTodosLosEquipo();
	List<Equipo> agregarEquipo(Equipo equipo);
	void guardarEquipo(Equipo equipo);
	void actualizarEquipo(Equipo equipo);
	Equipo consultarEquipo(Equipo equipo);
	List<Equipo> traerEquiposQueNoJueganPartidos(List<Equipo> equipos);
}
