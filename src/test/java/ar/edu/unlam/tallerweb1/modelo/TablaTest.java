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
	private Session sesion;
	private List<Equipo> equipos;
	
	@Before
	public void init() {
		tablaUno = new Tabla();
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
	public void testQueVerificaQueElEquipoRacingSeEncuentraEnLaTabla() {
		
		
		equipoUno.setNombre("River Plate");
		equipoDos.setNombre("Boca Juniors");
		equipoTres.setNombre("Racing Club");
		tablaUno.setEquipo(equipoUno);
		tablaUno.setEquipo(equipoDos);
		tablaUno.setEquipo(equipoTres);
				
		sesion.save(equipoUno);
		sesion.save(equipoDos);
		sesion.save(equipoTres);
		sesion.save(tablaUno);
		
		equipos = sesion.createCriteria(Tabla.class)
				.createAlias("equipo", "e")
				.add(Restrictions.eq("e.nombre" , "Racing Club"))
				.list();
	
			assertThat(equipos).hasSize(1);
			assertThat(equipos).isNotEmpty();
			//assertThat(equipos.get(0).getNombre()).isEqualTo("Racing Club");
	}
}
