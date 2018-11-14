package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Tabla;

@Service("TablaDao")
@Transactional
public class TablaDaoImpl implements TablaDao {
	@Inject
	private SessionFactory sessionFactory;
	
		
	@Override
	public void save(Tabla tabla) {
		sessionFactory.getCurrentSession().save(tabla);
		}

	@Override
	public void update(Tabla tabla) {
		sessionFactory.getCurrentSession().update(tabla);
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tabla> findAll() {
		List<Tabla> tabla = sessionFactory.getCurrentSession().createCriteria(Tabla.class)
				.list();
		return tabla;
	}


}

