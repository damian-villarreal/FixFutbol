package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ControladorPartidoTest {

	@Mock
	private ServicioPartido servicioPartido;
	
	@Mock
	private Partido partido;
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpSession sesion;
	
	@InjectMocks
	private ControladorPartido controladorPartido;
	
	
	@Before
	public void injectionOfMocksInitialized() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testQueCargaUnResultado() {
		when(servicioPartido.consultarPartido(any(Partido.class))).thenReturn(partido);
		when(partido.getGolesLocales()).thenReturn(2);
		when(partido.getGolesVisitantes()).thenReturn(0);
		when(partido.getId()).thenReturn(91L);
		
		ModelAndView modelo = controladorPartido.cargarResultado(partido.getId());
		
		assertThat(modelo.getViewName()).isEqualTo("cargar-resultado");
		
		verify(sesion , times(1));
	}
	

	
}
