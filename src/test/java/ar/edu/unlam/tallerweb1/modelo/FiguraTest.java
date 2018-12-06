package ar.edu.unlam.tallerweb1.modelo;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import ar.edu.unlam.tallerweb1.SpringTest;

public class FiguraTest extends SpringTest {

	private Figura figuraUno , figuraDos , figuraTres;
	private Equipo equipoUno , equipoDos , equipoTres;
	private Session sesion;
	private List<Figura> figuras;
	
	@Before
	public void init() {
		figuraUno = new Figura();
		figuraDos = new Figura();
		figuraTres = new Figura();
		equipoUno = new Equipo();
		equipoDos = new Equipo();
		equipoTres = new Equipo();
		sesion = getSession();
		figuras = new ArrayList<Figura>();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback
	public void testQueDaComoFiguraAPabloPerezDelEquipoDeBocaJuniors() {
		figuraUno.setNombreCompleto("Pablo Perez");
		figuraDos.setNombreCompleto("Lisandro Lopez");
		figuraTres.setNombreCompleto("Martin Benitez");
		
		equipoUno.setNombre("Boca Juniors");
		equipoDos.setNombre("Independiente");
		equipoTres.setNombre("Racing Club");
		
		figuraUno.setEquipo(equipoUno);
		figuraDos.setEquipo(equipoTres);
		figuraTres.setEquipo(equipoDos);
		
		sesion.save(figuraUno);
		sesion.save(figuraDos);
		sesion.save(figuraTres);
		sesion.save(equipoUno);
		sesion.save(equipoDos);
		sesion.save(equipoTres);
		
		figuras = sesion.createCriteria(Figura.class)
				.createAlias("equipo", "e")
				.add(Restrictions.eq("e.nombre", "Boca Juniors"))
				.add(Restrictions.eq("nombreCompleto", "Pablo Perez"))
				.list();
		
		assertThat(figuras).hasSize(1);
		assertThat(figuras).isNotEmpty();
		assertThat(figuras.get(0).getEquipo().getNombre()).isEqualTo("Boca Juniors");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback
	public void testQueValidaQueElJugadorPonzioDelEquipoRiverPlateSalioFiguraMasDeDosVeces() {
		
		figuraUno.setNombreCompleto("Leonardo Ponzio");
		figuraDos.setNombreCompleto("Lisandro Lopez");
		figuraTres.setNombreCompleto("Martin Benitez");
		
		equipoUno.setNombre("River Plate");
		equipoDos.setNombre("Racing Club");
		equipoTres.setNombre("Independiente");
		
		figuraUno.setEquipo(equipoUno);
		figuraDos.setEquipo(equipoDos);
		figuraTres.setEquipo(equipoTres);
		figuraUno.setVecesFigura(3);
		
		sesion.save(figuraUno);
		sesion.save(figuraDos);
		sesion.save(figuraTres);
		sesion.save(equipoUno);
		sesion.save(equipoDos);
		sesion.save(equipoTres);
		
		figuras = sesion.createCriteria(Figura.class)
					.add(Restrictions.eq("nombreCompleto", "Leonardo Ponzio"))
					.add(Restrictions.gt("vecesFigura", 2))
					.createAlias("equipo", "e")
					.add(Restrictions.eq("e.nombre", "River Plate"))
					.list();
		
		assertThat(figuras).hasSize(1);
		assertThat(figuras).isNotEmpty();
		assertThat(figuras.get(0).getEquipo().getNombre()).isEqualTo("River Plate");
		assertThat(figuras.get(0).getNombreCompleto()).isEqualTo("Leonardo Ponzio");
		assertThat(figuras.get(0).getVecesFigura()).isGreaterThan(2);
	}
}
