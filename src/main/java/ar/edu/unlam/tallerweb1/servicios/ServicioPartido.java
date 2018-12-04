package ar.edu.unlam.tallerweb1.servicios;

import java.util.*;
import ar.edu.unlam.tallerweb1.modelo.*;

public interface ServicioPartido {

	List<Partido> listarTodosLosPartidos();
	void guardarPartido(Partido partido);
	void actualizarPartido(Partido partido);
	Partido buscarPorId(Long id);
	Partido consultarPartido(Partido partido);
	List<Partido> listarTodosLosPartidosSinTerminar();
	List<Partido> buscarPorTorneo(Long id);
	void ActualizarResultado(Partido partido);
	void actualizarFigura(Partido partido);
}
