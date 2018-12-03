package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.SpringTest;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class TorneoTest extends SpringTest {

	private Torneo torneoUno , torneoDos , torneoTres;
	private Session sesion;
	private List<Torneo> torneos;
	
	@Before
	public void init() {
		torneoUno = new Torneo();
		torneoDos = new Torneo();
		torneoTres = new Torneo();
		sesion = getSession();
		torneos = new ArrayList<Torneo>();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback
	public void testQueDefineElNombreDelTorneoComoSuperliga() {
		torneoUno.setNombre("Superliga");
		torneoDos.setNombre("Copa Libertadores");
		torneoTres.setNombre("Uefa Champions League");
		
		sesion.save(torneoUno);
		sesion.save(torneoDos);
		sesion.save(torneoTres);
		
		torneos = sesion.createCriteria(Torneo.class)
				.add(Restrictions.eq("nombre", "Superliga"))
				.list();
		
		assertThat(torneos).hasSize(1);
		assertThat(torneos).isNotEmpty();
		assertThat(torneos.get(0).getNombre()).isEqualTo("Superliga");
		assertThat(torneos.get(0).getNombre()).isNotEqualTo("Copa Libertadores");
		assertThat(torneos.get(0).getNombre()).isNotEqualTo("Uefa Champions League");
	}
}
