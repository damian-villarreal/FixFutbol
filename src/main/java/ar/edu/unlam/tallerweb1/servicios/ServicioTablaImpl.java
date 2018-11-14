package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TablaDao;
import ar.edu.unlam.tallerweb1.modelo.Tabla;

@Service ("servicioTabla")
@Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
public class ServicioTablaImpl implements ServicioTabla {
	
	@Inject
	private TablaDao tablaDao;
	
	@Transactional(readOnly = false , propagation = Propagation.REQUIRED , rollbackFor = { Exception.class } )
	@Override
	public void guardarTabla(Tabla tabla) {
		tablaDao.save(tabla);
		
	}

	@Transactional(readOnly = false , propagation = Propagation.REQUIRED , rollbackFor = { Exception.class } )
	@Override
	public void actualizarTabla(Tabla tabla) {
		tablaDao.update(tabla);

	}
	
	@Override
	public List<Tabla> listarTabla() {
		return tablaDao.findAll();
	}
	

}

