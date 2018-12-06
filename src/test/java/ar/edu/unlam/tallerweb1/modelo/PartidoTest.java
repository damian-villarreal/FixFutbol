package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import ar.edu.unlam.tallerweb1.SpringTest;
import static org.assertj.core.api.Assertions.assertThat;

public class PartidoTest extends SpringTest {

	private Partido partidoUno;
	private Equipo equipoUno , equipoDos;
	private Fecha fechaUno;
	private Figura figuraUno;
	private Session sesion;
	private List<Partido> partidos;
	
	@Before
	public void init() {
		partidoUno = new Partido();
		equipoUno = new Equipo();
		equipoDos = new Equipo();
		fechaUno = new Fecha();
		figuraUno = new Figura();
		sesion = getSession();
		partidos = new ArrayList<Partido>();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback
	public void testQueDeterminaQueBocaYRiverJueganEnLaFecha10ConVictoriaDelEquipoLocalPorDosTantosContraCeroYComoFiguraDelEncuentroEsWanchope() {
		partidoUno.setGolesLocales(2);
		partidoUno.setGolesVisitantes(0);
		
		equipoUno.setNombre("Boca Juniors");
		equipoDos.setNombre("River Plate");
		
		fechaUno.setNumero(10);
		
		figuraUno.setNombreCompleto("Wanchope");
		
		partidoUno.setEquipoLocal(equipoUno);
		partidoUno.setEquipoVisitante(equipoDos);
		partidoUno.setFecha(fechaUno);
		partidoUno.setFigura(figuraUno);
		
		sesion.save(partidoUno);
		sesion.save(equipoUno);
		sesion.save(equipoDos);
		sesion.save(figuraUno);
		sesion.save(fechaUno);
		
		partidos = sesion.createCriteria(Partido.class)
				.createAlias("equipoLocal", "local")
					.add(Restrictions.eq("local.nombre", "Boca Juniors"))
				.createAlias("equipoVisitante", "visitante")
					.add(Restrictions.eq("visitante.nombre", "River Plate"))
				.createAlias("fecha", "f")
					.add(Restrictions.eq("f.numero", 10))
				.createAlias("figura", "fi")
					.add(Restrictions.eq("fi.nombreCompleto", "Wanchope"))
					.add(Restrictions.eq("golesLocales", 2))
					.add(Restrictions.eq("golesVisitantes", 0))
				.list();
		
		assertThat(partidos).hasSize(1);
		assertThat(partidos).isNotEmpty();
		assertThat(partidos.get(0).getEquipoLocal().getNombre()).isEqualTo("Boca Juniors");
		assertThat(partidos.get(0).getEquipoVisitante().getNombre()).isEqualTo("River Plate");
		assertThat(partidos.get(0).getFecha().getNumero()).isEqualTo(10);
		assertThat(partidos.get(0).getFigura().getNombreCompleto()).isEqualTo("Wanchope");
		assertThat(partidos.get(0).getGolesLocales()).isEqualTo(2);
		assertThat(partidos.get(0).getGolesVisitantes()).isEqualTo(0);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback
	public void testQueValidaQueElPartidoEntreIndependienteYRacingPorLaFechaDosSalioEmpatadoConMezaComoFigura() {
		
		partidoUno.setGolesLocales(1);
		partidoUno.setGolesVisitantes(1);
		
		equipoUno.setNombre("Independiente");
		equipoDos.setNombre("Racing Club");
		
		fechaUno.setNumero(2);
		
		figuraUno.setNombreCompleto("Meza");
		
		partidoUno.setEquipoLocal(equipoUno);
		partidoUno.setEquipoVisitante(equipoDos);
		partidoUno.setFecha(fechaUno);
		partidoUno.setFigura(figuraUno);
		
		sesion.save(partidoUno);
		sesion.save(equipoUno);
		sesion.save(equipoDos);
		sesion.save(figuraUno);
		sesion.save(fechaUno);
		
		partidos = sesion.createCriteria(Partido.class)
				.createAlias("equipoLocal", "local")
					.add(Restrictions.eq("local.nombre", "Independiente"))
				.createAlias("equipoVisitante", "visitante")
					.add(Restrictions.eq("visitante.nombre", "Racing Club"))
				.createAlias("fecha", "f")
					.add(Restrictions.eq("f.numero", 2))
				.createAlias("figura", "fig")
					.add(Restrictions.eq("fig.nombreCompleto", "Meza"))
					.add(Restrictions.eq("golesLocales", 1))
					.add(Restrictions.eq("golesVisitantes", 1))
				.list();
		
		assertThat(partidos).hasSize(1);
		assertThat(partidos).isNotEmpty();
		assertThat(partidos.get(0).getEquipoLocal().getNombre()).isEqualTo("Independiente");
		assertThat(partidos.get(0).getEquipoVisitante().getNombre()).isEqualTo("Racing Club");
		assertThat(partidos.get(0).getFecha().getNumero()).isEqualTo(2);
		assertThat(partidos.get(0).getFigura().getNombreCompleto()).isEqualTo("Meza");
		assertThat(partidos.get(0).getGolesLocales()).isEqualTo(1);
		assertThat(partidos.get(0).getGolesVisitantes()).isEqualTo(1);
		
		
	}
}
