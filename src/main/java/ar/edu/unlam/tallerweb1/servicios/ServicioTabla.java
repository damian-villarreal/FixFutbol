package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.FiguraTabla;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Tabla;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

public interface ServicioTabla {
	
	void guardarTabla (Tabla tabla);
//	void actualizarTabla(Tabla tabla);
	List<Tabla> listarTabla(Long idTorneo);
	void crearTabla(Torneo torneo, Equipo equipo);
	List<Tabla> buscarPorTorneo(Long idTorneo);
	void actualizarTabla(Partido partido);
	Tabla buscarEquipoTorneo(Long idEquipo, Long idTorneo);
	boolean ValidarCampeonAnticipado(List<Tabla> tablas);
}
