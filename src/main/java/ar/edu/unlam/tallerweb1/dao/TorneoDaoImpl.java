package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Torneo;

@Service("TorneoDao")
@Transactional
public class TorneoDaoImpl implements TorneoDao{

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void save(Torneo torneo) {
		sessionFactory.getCurrentSession().save(torneo);
	}

	@Override
	public void update(Torneo torneo) {
		sessionFactory.getCurrentSession().update(torneo);		
	}

	@Override
	public Torneo findByTournament(Torneo torneo) {
		return (Torneo) sessionFactory.getCurrentSession().createCriteria(Torneo.class)
				.add(Restrictions.eq("nombre", torneo.getNombre()))
				.uniqueResult();
	}

}
