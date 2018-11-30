package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Tabla;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

public interface ServicioTabla {
	
	void guardarTabla (Tabla tabla);
//	void actualizarTabla(Tabla tabla);
	List<Tabla> listarTabla(Long idTorneo);
	void crearTabla(Torneo torneo, Long idEquipo);
	List<Tabla> buscarPorTorneo(Long idTorneo);
	void actualizarTabla(Partido partido);
	Tabla buscarEquipoTorneo(Long idEquipo, Long idTorneo);
}
