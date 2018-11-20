package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Fase;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

public interface ServicioTorneo {
	void guardarTorneo(Torneo torneo);
	void actualizarTorneo(Torneo torneo);
	Torneo consultarTorneo(Torneo torneo);
	List<Torneo> listarTodosLosTorneos();
	List<Partido> crearLiguilla();
	List<Partido> crearEliminacion();
	void calcularEquipoQuePasaALaSiguienteFase(List<Partido> partidos, Fase fase);
}
