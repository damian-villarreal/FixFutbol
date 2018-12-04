package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Figura;

public interface FiguraDao {
	
	void save(Figura figura);

	Figura findByNameAndTeam(String nombreCompleto, Long IdEquipo);

}
