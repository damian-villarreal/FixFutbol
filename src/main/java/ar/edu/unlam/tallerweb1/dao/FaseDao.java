package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Fase;

public interface FaseDao {
	
	List<Fase> list();
	Fase create (Fase fase);
	void save(Fase fase);
	void update(Fase fase);
	Fase readFase(String nombreDeLaFase, String instancia);
}
