package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Figura;

@Service("FiguraDao")
@Transactional
public class FiguraDaoImpl implements FiguraDao {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void save(Figura figura) {
		sessionFactory.getCurrentSession().save(figura);	
	}

	@Override
	public Figura findByNameAndTeam(String nombreCompleto, Long idEquipo) {
		return (Figura) sessionFactory.getCurrentSession().createCriteria(Figura.class)
		.add(Restrictions.eq("nombreCompleto", nombreCompleto))
		.createAlias("equipo", "e")
		.add(Restrictions.eq("e.id", idEquipo))
		.uniqueResult();
	}
}
