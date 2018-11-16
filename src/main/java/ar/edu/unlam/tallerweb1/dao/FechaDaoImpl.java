package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Fecha;


@Service("FechaDao")
@Transactional

public class FechaDaoImpl implements FechaDao{
	
	@Inject
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Fecha> findAll(Fecha fecha) {
		List <Fecha> fechas = sessionFactory.getCurrentSession().createCriteria(Fecha.class)
				.add(Restrictions.eq("numero", fecha.getNumero() )).list();
		return fechas;
	}

	@Override
	public void save(Fecha fecha) {
		sessionFactory.getCurrentSession().save(fecha);
		
	}

	@Override
	public void update(Fecha fecha) {
		sessionFactory.getCurrentSession().update(fecha);
		
	}

}
