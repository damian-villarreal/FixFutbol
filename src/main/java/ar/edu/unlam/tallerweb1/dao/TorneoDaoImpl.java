package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Fecha;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Torneo> findAll() {
		return (List<Torneo>) sessionFactory.getCurrentSession().createCriteria(Torneo.class).list();
	}

	@Override
	public Torneo findById(Long idTorneo) {		
		return (Torneo) sessionFactory.getCurrentSession().createCriteria(Torneo.class)
				.add(Restrictions.eq("id", idTorneo))
				.uniqueResult();
	}

	@Override
	public List<Fecha> getFechas(Long idTorneo) {
			
		return (List<Fecha>) sessionFactory.getCurrentSession().createCriteria(Fecha.class)
				.createAlias("torneo", "t")
				.add(Restrictions.eq("t.id", idTorneo))
				.list();
	}

}
