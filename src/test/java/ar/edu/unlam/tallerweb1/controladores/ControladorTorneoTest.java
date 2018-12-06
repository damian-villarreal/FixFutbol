package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;

public class ControladorTorneoTest {

	@Mock
	private ServicioTorneo servicioTorneo;
	
	@Mock
	private Torneo torneo;
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpSession sesion;
	
	@InjectMocks
	private ControladorTorneo controladorTorneo;
	
	public void injectionOfMocksInitialized() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testQuePuedaCrearUnaLiguilla() {
		try {
			when(servicioTorneo.consultarTorneo(any(Torneo.class))).thenReturn(torneo);
			when(torneo.getId()).thenReturn(91L);
			when(torneo.getNombre()).thenReturn("Superliga");
			ModelAndView model = controladorTorneo.crearLiguilla();
			
			assertThat(model.getViewName()).isEqualTo("liguilla");
			
			verify(sesion , times(1)).setAttribute(anyString(), anyString());
		} catch(Exception e) {
			e.getMessage();
		}
		
		
		
	}
	
	@Test
	public void testQueDaElDetalleDelTorneo() {
		try {
			when(request.getSession()).thenReturn(sesion);
			when(servicioTorneo.consultarTorneo(any(Torneo.class))).thenReturn(torneo);
			when(torneo.getId()).thenReturn(91L);
			
			ModelAndView modelo = controladorTorneo.detalleTorneo(torneo.getId());
			
			assertThat(modelo.getViewName()).isEqualTo("torneo");
			
			verify(sesion , times(1)).setAttribute(anyString(), anyString());
		} catch(Exception e) {
			e.getMessage();
		}
		
		
	}
	
}
