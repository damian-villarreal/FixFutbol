package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Tabla;

public interface TablaDao {
	
	void save(Tabla tabla);
	void update(Tabla tabla);
	List<Tabla> findAll();
	List<Tabla> orderDesc(Long idTorneo);
	List<Tabla> findByTournament(Long idTorneo);
	Tabla findTeamAndTournament(Long idEquipo, Long idTorneo);

}
