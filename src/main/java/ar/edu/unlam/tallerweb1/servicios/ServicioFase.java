package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Fase;

public interface ServicioFase {
	
	List<Fase> crearFases();
	void guardarFases(List<Fase> fases);
	void actualizarFases(List<Fase> fases);
	List<Fase> armarFases();
}