package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.unlam.tallerweb1.SpringTest;

public class ResultadoTest extends SpringTest {
	
	private Resultado resultado;
	private Equipo equipoLocal , equipoVisitante ;
	private Partido partidoUno;
	private Session sesion;
	private List<Resultado> resultados;
	
	@Before
	public void init() {
		resultado = new Resultado();
		equipoLocal = new Equipo();
		equipoVisitante = new Equipo();
		partidoUno = new Partido();
		sesion = getSession();
		resultados = new ArrayList<Resultado>();
	}
	
	/*@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback
	public void testQueVerificaQueElResultadoDelPartidoEsDosParaRiverYTresParaRacing() {
		
		
		equipoLocal.setNombre("River Plate");
		equipoVisitante.setNombre("Racing Club");
		
		partidoUno.setEquipoLocal(equipoLocal);
		partidoUno.setEquipoVisitante(equipoVisitante);
		
		partidoUno.setGolesLocales(2);
		partidoUno.setGolesVisitantes(3);
		
		sesion.save(partidoUno);
		sesion.save(equipoLocal);
		sesion.save(equipoVisitante);
		
		resultados = sesion.createCriteria(Resultado.class)
					.createAlias("equipoLocal", "local")
						.add(Restrictions.eq("local.nombre", "River Plate"))
					//.createAlias("equipoVisitante", "visitante")
						//.add(Restrictions.eq("visitante.nombre", "Racing Club"))
					//.createAlias("partido", "p")
					//.add(Restrictions.eq("p.golesLocales", 2))
					//.add(Restrictions.eq("p.golesVisitanes", 3))
					.list();
	
		assertThat(resultados).hasSize(1);
		
	}*/
	
	
	

}
