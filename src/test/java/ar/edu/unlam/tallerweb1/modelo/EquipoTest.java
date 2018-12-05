package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.unlam.tallerweb1.SpringTest;

public class EquipoTest extends SpringTest {
	
	private Equipo equipoUno , equipoDos , equipoTres;
	private Session sesion;
	private List<Equipo> equipos;
	
	@Before
	public void init() {
		equipoUno = new Equipo();
		equipoDos = new Equipo();
		equipoTres = new Equipo();
		sesion = getSession();
		equipos = new ArrayList<Equipo>();
	}

	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback
	public void testQueBuscaTodosLosEquiposConNombreQueEmpiezanConB() {
		equipoUno.setNombre("Boca Juniors");
		equipoDos.setNombre("Boca Unidos");
		equipoTres.setNombre("Tigre");
		
		sesion.save(equipoUno);
		sesion.save(equipoDos);
		sesion.save(equipoTres);
		
		equipos = sesion.createCriteria(Equipo.class)
				.add(Restrictions.like("nombre", "B%"))
				.list();
		
		assertThat(equipos).hasSize(2);
		assertThat(equipos).isNotEmpty();
		
		
	}
}
