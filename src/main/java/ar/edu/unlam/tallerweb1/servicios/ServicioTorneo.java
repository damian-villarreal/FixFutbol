package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Fecha;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

public interface ServicioTorneo {

	void guardarTorneo(Torneo torneo);

	void actualizarTorneo(Torneo torneo);

	Torneo consultarTorneo(Torneo torneo);

	List<Torneo> listarTodosLosTorneos();

	Torneo crearLiguilla();

	Torneo buscarPorId(Long idTorneo);

	List<Fecha> obtenerFechas(Long idTorneo);

	boolean validarTorneoFinalizado(Long idTorneo);

	void actualizarPartidosJugados(Long idTorneo);
}
