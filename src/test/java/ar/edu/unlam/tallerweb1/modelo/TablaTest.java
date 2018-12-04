package ar.edu.unlam.tallerweb1.modelo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;

public class TablaTest extends SpringTest {

	private Tabla tablaUno , tablaDos , tablaTres;
	private Equipo equipoUno , equipoDos , equipoTres;
	private Torneo torneoUno , torneoDos , torneoTres;
	
	@Before
	public void init() {
		tablaUno = new Tabla();
		tablaDos = new Tabla();
		tablaTres = new Tabla();
		equipoUno = new Equipo();
		equipoDos = new Equipo();
		equipoTres = new Equipo();
		torneoUno = new Torneo();
		torneoDos = new Torneo();
		torneoTres = new Torneo();
	}
	
	@Test
	@Transactional
	@Rollback
	public void test() {
		
	}
}
