package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	
}
