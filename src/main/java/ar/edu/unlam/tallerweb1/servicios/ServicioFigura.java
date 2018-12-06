package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Figura;
import ar.edu.unlam.tallerweb1.modelo.FiguraTabla;
import ar.edu.unlam.tallerweb1.modelo.Partido;

public interface ServicioFigura {
	
	void guardarFigura(Figura figura);
	void actualizarFigura(Figura figura);
	Figura buscarFigura(Figura figura);
	List<Figura> listarFiguras();
	List<FiguraTabla> listarFiguraTabla(Long idTorneo);
}
