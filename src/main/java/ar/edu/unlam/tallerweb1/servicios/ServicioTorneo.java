package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

public interface ServicioTorneo {
	void guardarTorneo(Torneo torneo);
	void actualizarTorneo(Torneo torneo);
	List<Partido> crearLiguilla(Equipo equipoLocal, Equipo equipoVisitante);
	Torneo consultarTorneo(Torneo torneo);
}
