package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class ControladorLoginTest {

	@Mock
	private ServicioLogin servicioLogin;
	
	@Mock
	private Usuario usuario;
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpSession sesion;
	
	@InjectMocks
	private ControladorLogin controladorLogin;
	
	@Before
	public void injectionOfMocksInitialized() {
		MockitoAnnotations.initMocks(this);
	}
	
	/*@Test
	public void testQueVerificaQueElLoginSeaValido() {
		when(request.getSession()).thenReturn(sesion);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(usuario);
		when(usuario.getId()).thenReturn(91L);
		when(usuario.getEmail()).thenReturn("admin@fixfutbol.com");
		when(usuario.getPassword()).thenReturn("admin");
		when(usuario.getRol()).thenReturn("ADMIN");
		
		ModelAndView model = controladorLogin.irALogin();
		
		assertThat(model.getViewName()).isEqualTo("index");
		assertThat(model.getModel()).isNotEmpty();
		
		verify(sesion , times(1)).setAttribute("AdminId", 91L);
		
	}*/
	
	
	
	
	
}