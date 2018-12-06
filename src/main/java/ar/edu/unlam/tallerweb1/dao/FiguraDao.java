package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Figura;

public interface FiguraDao {
	
	void save(Figura figura);
	void update(Figura figura);
	Figura find(Figura figura);
	List<Figura> listFiguras();

}
