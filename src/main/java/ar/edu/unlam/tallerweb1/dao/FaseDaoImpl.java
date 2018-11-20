package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.Fase;

@Repository("FaseDao")
public class FaseDaoImpl implements FaseDao {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void save(Fase fase) {
		sessionFactory.getCurrentSession().save(fase);
	}

	@Override
	public void update(Fase fase) {
		sessionFactory.getCurrentSession().update(fase);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fase> list() {
		return (List<Fase>) sessionFactory.getCurrentSession().createCriteria(Fase.class)
                .list();
	}

	@Override
	public Fase create(Fase fase) {
		sessionFactory.getCurrentSession().save(fase);
        return fase;
	}

	@Override
	public Fase readFase(String nombreDeLaFase, String instancia) {
		return (Fase) sessionFactory.getCurrentSession().createCriteria(Fase.class)
				.add(Restrictions.eq("nombreDeLaFase", nombreDeLaFase))
				.add(Restrictions.eq("instancia", instancia))
				.uniqueResult();
	}
}
