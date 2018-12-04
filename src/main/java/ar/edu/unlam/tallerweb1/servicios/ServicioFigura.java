package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Figura;

public interface ServicioFigura {
	
	void guardarFigura(Figura figura);
	Figura buscarFigura(Figura figura);
	List<Figura> listarFiguras(Long idTorneo);
}
