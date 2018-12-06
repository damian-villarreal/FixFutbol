package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Figura;
import ar.edu.unlam.tallerweb1.modelo.FiguraTabla;
import ar.edu.unlam.tallerweb1.modelo.Partido;

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
	public Figura find(Figura figura) {
		return (Figura) sessionFactory.getCurrentSession().createCriteria(Figura.class)
				.add(Restrictions.eq("nombreCompleto", figura.getNombreCompleto())).createAlias("equipo", "e")
				.add(Restrictions.eq("e.id", figura.getEquipo().getId())).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Figura> listFiguras() {
		return sessionFactory.getCurrentSession().createCriteria(Figura.class)
				.list();
	}

	@Override
	public void update(Figura figura) {
		sessionFactory.getCurrentSession().update(figura);

	}
}
