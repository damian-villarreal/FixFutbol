package ar.edu.unlam.tallerweb1.dao;

import java.util.*;
import ar.edu.unlam.tallerweb1.modelo.*;

public interface EquipoDao {

	List<Equipo> findAll();
	List<Equipo> add(Equipo equipo);
	void save(Equipo equipo);
	void update(Equipo equipo);
	Equipo findByMatch(Equipo equipo);
	List<Equipo> findTeamsWithoutMatches(List<Equipo> equipos);
}
