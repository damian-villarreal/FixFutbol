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

import ar.edu.unlam.tallerweb1.modelo.Tabla;
import ar.edu.unlam.tallerweb1.servicios.ServicioTabla;

public class ControladorTablaTest {

	@Mock
	private ServicioTabla servicioTabla;
	
	@Mock
	private Tabla tabla;
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpSession sesion;
	
	@InjectMocks
	private ControladorTabla controladorTabla;
	
	@Before
	public void injectionOfMocksInitialized() {
		MockitoAnnotations.initMocks(this);
	}
	
	/*@Test
	public void testQueDevuelveLasPosicionesDeLosEquipos() {
		when(request.getSession()).thenReturn(sesion);
		when(servicioTabla.consultarTabla(any(Tabla.class))).thenReturn(tabla);
	}*/
}
