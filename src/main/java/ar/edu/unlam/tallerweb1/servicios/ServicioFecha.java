package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Fecha;

public interface ServicioFecha {

	List<Fecha> listarTodosLasFechas(Fecha fecha);
	void guardarFecha(Fecha fecha);
	void ActualizarFecha(Fecha fecha);
	void crearLiguilla();
}
