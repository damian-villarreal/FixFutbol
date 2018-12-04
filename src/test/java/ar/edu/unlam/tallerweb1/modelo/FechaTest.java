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

public class FechaTest extends SpringTest {
	
	private Fecha fechaUno , fechaDos , fechaTres;
	private Torneo torneoUno , torneoDos , torneoTres;
	private Session sesion;
	private List<Fecha> fechas;
	
	@Before
	public void init() {
		fechaUno = new Fecha();
		fechaDos = new Fecha();
		fechaTres = new Fecha();
		torneoUno = new Torneo();
		torneoDos = new Torneo();
		torneoTres = new Torneo();
		sesion = getSession();
		fechas = new ArrayList<Fecha>();
	}

	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback
	public void testQueTraeElTipoDeTorneoDenominadoComoLaSuperligaConFechaUno() {
		fechaUno.setNumero(1);
		fechaDos.setNumero(2);
		fechaTres.setNumero(4);
		
		torneoUno.setNombre("Superliga");
		torneoDos.setNombre("Copa Libertadores");
		torneoTres.setNombre("Uefa Champions League");
		
		fechaUno.setTorneo(torneoUno);
		fechaDos.setTorneo(torneoDos);
		fechaTres.setTorneo(torneoTres);
		
		sesion.save(fechaUno);
		sesion.save(fechaDos);
		sesion.save(fechaTres);
		
		fechas = sesion.createCriteria(Fecha.class)
				.createAlias("torneo", "t")
				.add(Restrictions.eq("t.nombre", "Superliga"))
				.add(Restrictions.eq("numero", 1))
				.list();
		
		assertThat(fechas).hasSize(1);
		assertThat(fechas).isNotEmpty();
		assertThat(fechas.get(0).getNumero()).isEqualTo(1);
		assertThat(fechas.get(0).getNumero()).isNotEqualTo(2);
		assertThat(fechas.get(0).getNumero()).isNotEqualTo(4);
		assertThat(fechas.get(0).getTorneo().getNombre()).isEqualTo("Superliga");
		assertThat(fechas.get(0).getTorneo().getNombre()).isNotEqualTo("Copa Libertadores");
		assertThat(fechas.get(0).getTorneo().getNombre()).isNotEqualTo("Uefa Champions League");
	}
}
