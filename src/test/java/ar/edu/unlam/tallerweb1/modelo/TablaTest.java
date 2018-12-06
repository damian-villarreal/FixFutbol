package ar.edu.unlam.tallerweb1.modelo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;

public class TablaTest extends SpringTest {

	private Tabla tablaUno;
	private Equipo equipoUno , equipoDos , equipoTres;
	private Torneo torneoUno;
	private Session sesion;
	private List<Tabla> tablas;
	
	@Before
	public void init() {
		tablaUno = new Tabla();
		equipoUno = new Equipo();
		equipoDos = new Equipo();
		equipoTres = new Equipo();
		torneoUno = new Torneo();
		sesion = getSession();
		tablas= new ArrayList<Tabla>();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback
	public void testQueVerificaQueElEquipoRacingSeEncuentraEnLaTablaDelTorneo() {
			
		equipoUno.setNombre("River Plate");
		equipoDos.setNombre("Boca Juniors");
		equipoTres.setNombre("Racing Club");
		
		tablaUno.setEquipo(equipoUno);
		tablaUno.setEquipo(equipoDos);
		tablaUno.setEquipo(equipoTres);
				
		sesion.save(torneoUno);
		sesion.save(equipoUno);
		sesion.save(equipoDos);
		sesion.save(equipoTres);
		sesion.save(tablaUno);
		
		tablas = sesion.createCriteria(Tabla.class)
				.createAlias("equipo", "e")
				.add(Restrictions.eq("e.nombre" , "Racing Club"))
				.list();
	
			assertThat(tablas).hasSize(1);
			assertThat(tablas).isNotEmpty();
			assertThat(tablas.get(0).getEquipo().getNombre()).isEqualTo("Racing Club");
			
	}
}
