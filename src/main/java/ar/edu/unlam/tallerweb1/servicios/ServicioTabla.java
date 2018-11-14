package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Tabla;

public interface ServicioTabla {
	
	void guardarTabla (Tabla tabla);
	void actualizarTabla(Tabla tabla);
	List<Tabla> listarTabla();

	
}
