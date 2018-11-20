package ar.edu.unlam.tallerweb1.dao;

import java.util.*;
import ar.edu.unlam.tallerweb1.modelo.*;

public interface EquipoDao {

	List<Equipo> findAll();
	void save(Equipo equipo);
	void update(Equipo equipo);
	Equipo findByMatch(Equipo equipo);
	Equipo findById(Long id);
	List<Equipo> findTeamsWithoutMatches(List<Equipo> equipos);
	Equipo findByName(String nombre);
}
