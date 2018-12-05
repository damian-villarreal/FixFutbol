package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ar.edu.unlam.tallerweb1.modelo.Figura;
import ar.edu.unlam.tallerweb1.servicios.ServicioFigura;

public class ControladorTablaFiguraTest {

	@Mock
	private ServicioFigura servicioFigura;
	
	@Mock
	private Figura figura;
	
	@Mock
	private HttpSession sesion;
	
	@Mock
	private HttpServletRequest request;
	
	@InjectMocks
	private ControladorTablaFigura controladorTablaFigura;
	
	@Before
	public void injectionOfMocksInitialized() {
		MockitoAnnotations.initMocks(this);
	}
	
	/*@Test
	public void testQueBuscaLaFigura() {
		when(servicioFigura.buscarFigura(any(Figura.class))).thenReturn(figura);
		//when(figura.getId()).thenReturn(1L);
		
		ModelAndView modelo = controladorTablaFigura.verFigura(figura.getId());
		
		assertThat(modelo.getViewName()).isEqualTo("figuras");
		
		verify(sesion , times(1));

	}*/

}
