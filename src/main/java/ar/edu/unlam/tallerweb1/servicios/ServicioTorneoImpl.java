package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TorneoDao;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

@Service("ServicioTorneo")
@Transactional(readOnly = true , propagation = Propagation.SUPPORTS)

public class ServicioTorneoImpl implements ServicioTorneo {

	@Inject
	private TorneoDao torneoDao;

	@Override
	@Transactional(readOnly = false , propagation = Propagation.REQUIRED , rollbackFor = { Exception.class } )
	public void guardarTorneo(Torneo torneo) {
		torneoDao.save(torneo);
	}

	@Override
	@Transactional(readOnly = false , propagation = Propagation.REQUIRED , rollbackFor = { Exception.class } )
	public void actualizarTorneo(Torneo torneo) {
		torneoDao.update(torneo);
	}

}
