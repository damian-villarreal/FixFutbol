package ar.edu.unlam.tallerweb1.dao;

import java.util.*;
import ar.edu.unlam.tallerweb1.modelo.*;

public interface PartidoDao {

	List<Partido> findAll();
	void save(Partido partido);
	void update(Partido partido);
	Partido findById(Long id);
	Partido findByMatch(Partido partido);
	List<Partido> findUnfinishedMatch();
	List<Partido> findByTournament (Long id);
	List<Partido> findByTorneoYFigura(Long idFigura, Long idTorneo);
}
