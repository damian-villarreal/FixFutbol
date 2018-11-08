package ar.edu.unlam.tallerweb1.dao;

import java.util.*;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Partido;

@Service("EquipoDao")
@Transactional
public class EquipoDaoImpl implements EquipoDao {

	@Inject
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Equipo> findAll() {
		List<Equipo> equipo = sessionFactory.getCurrentSession().createCriteria(Equipo.class).list();
		return equipo;
	}

	@Override
	public void save(Equipo equipo) {
		sessionFactory.getCurrentSession().save(equipo);
		
	}

	@Override
	public void update(Equipo equipo) {
		sessionFactory.getCurrentSession().update(equipo);
		
	}

	@Override
	public Equipo findByMatch(Equipo equipo) {
		return (Equipo) sessionFactory.getCurrentSession().createCriteria(Equipo.class)
				.add(Restrictions.eq("nombre", equipo.getNombre()))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipo> findTeamsWithoutMatches(List<Equipo> equipos) {
		List<Equipo> equiposSinPartidos = new LinkedList<Equipo>();
		equiposSinPartidos.addAll(equipos);
		
		//Declaro un Set para evitar repetidos y traigo la lista de partidos
		Set<Equipo> equiposConPartidos = new HashSet<Equipo>();
		List<Partido> partidos = sessionFactory.getCurrentSession().createCriteria(Partido.class).list();
		
		//Agrego los equipos a la coleccion
		for(Partido partido : partidos) {
			equiposConPartidos.add(partido.getEquipoLocal());
			equiposConPartidos.add(partido.getEquipoVisitante());
		}
		
		//Quito los equipos que juegan algun partido y devuelvo la lista
		equiposSinPartidos.removeAll(equiposConPartidos);
		
		return equiposSinPartidos;
	}

	@Override
	public Equipo findById(Integer id) {
		return (Equipo) sessionFactory.getCurrentSession().createCriteria(Equipo.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

}
