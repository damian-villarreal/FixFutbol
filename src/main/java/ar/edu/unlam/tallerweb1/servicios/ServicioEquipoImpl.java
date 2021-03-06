package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.dao.*;

@Service("servicioEquipo")
//Solo necesita leer , no escribir , y no tiene prioridad de generacion
@Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
public class ServicioEquipoImpl implements ServicioEquipo {

	@Inject
	private EquipoDao equipoDao;
	
	@Override
	public List<Equipo> listarTodosLosEquipo() {
		return equipoDao.findAll();
	}

	@Transactional(readOnly = false , propagation = Propagation.REQUIRED , rollbackFor = { Exception.class } )
	@Override
	public void guardarEquipo(Equipo equipo) {
		equipoDao.save(equipo);
		
	}

	@Transactional(readOnly = false , propagation = Propagation.REQUIRED , rollbackFor = { Exception.class } )
	@Override
	public void actualizarEquipo(Equipo equipo) {
		equipoDao.update(equipo);
	}

	@Override
	public Equipo consultarEquipo(Equipo equipo) {
		return equipoDao.findByMatch(equipo);
	}

	@Override
	public List<Equipo> traerEquiposQueNoJueganPartidos(List<Equipo> equipos) {
		return equipoDao.findTeamsWithoutMatches(equipos);
	}

	@Override
	public Equipo buscarPorId(Long idEquipo) {
		return equipoDao.findById(idEquipo);
	}

}
