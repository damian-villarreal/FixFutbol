package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.FechaDao;
import ar.edu.unlam.tallerweb1.modelo.Fecha;

@Service("servicioFecha")
@Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
public class ServicioFechaImpl implements ServicioFecha{
	
	@Inject 
	private FechaDao fechaDao;

	@Override
	public List<Fecha> listarTodosLasFechas() {		
		return fechaDao.findAll();
	}

	@Transactional(readOnly = false , propagation = Propagation.REQUIRED , rollbackFor = { Exception.class } )
	@Override
	public void guardarFecha(Fecha fecha) {
		fechaDao.save(fecha);
	}

	@Override
	public void ActualizarFecha(Fecha fecha) {
		fechaDao.update(fecha);		
	}

	@Override
	public void crearLiguilla() {
				
	}	
}
