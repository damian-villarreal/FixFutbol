package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.FiguraDao;
import ar.edu.unlam.tallerweb1.modelo.Figura;

@Service("servicioFigura")
//Solo necesita leer, no escribir , y no tiene prioridad de generacion
@Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
public class ServicioFiguraImpl implements ServicioFigura {
	
	@Inject
	private FiguraDao figuraDao;
	
	@Override
	public void guardarFigura(Figura figura) {
		figuraDao.save(figura);
	}

	public Figura buscarPorNombreYEquipo(String nombreCompleto, Long idEquipo) {
		return figuraDao.findByNameAndTeam(nombreCompleto,idEquipo);		 
	}
	
	
}
