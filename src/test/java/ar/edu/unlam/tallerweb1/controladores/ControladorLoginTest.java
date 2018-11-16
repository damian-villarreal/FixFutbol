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
	
	@Test
	public void testQueVerificaQueElLoginSeaValido() {
		when(request.getSession()).thenReturn(sesion);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(usuario);
		when(usuario.getRol()).thenReturn("USER");
		
		ModelAndView modelo = controladorLogin.validarLogin(usuario, request);
		
		assertThat(modelo.getViewName()).isEqualTo("redirect:/home");
		
		verify(sesion , times(1)).setAttribute("ROL", usuario.getRol());
		
	}
	
	@Test
	public void testQueVerificaQueElLoginSeaInvalido() {
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(null);
		
		ModelAndView modelo = controladorLogin.validarLogin(usuario, null);
		
		assertThat(modelo.getViewName()).isEqualTo("login");
		assertThat(modelo.getModel().get("error")).isEqualTo("Usuario o clave incorrecta");
		
		verify(sesion , never()).setAttribute(anyString(), anyString());
	}
	
	
	
	
	
	
	
}