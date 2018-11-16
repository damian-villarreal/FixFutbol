package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.*;

public interface FechaDao {
	List<Fecha> findAll(Fecha fecha);
	void save(Fecha fecha);
	void update(Fecha fecha);
}
