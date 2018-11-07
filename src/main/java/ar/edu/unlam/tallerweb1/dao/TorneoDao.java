package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Torneo;;

public interface TorneoDao {

	Torneo findByTournament(Torneo torneo);
	void save(Torneo torneo);
	void update(Torneo torneo);
}
