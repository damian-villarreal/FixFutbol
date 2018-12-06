package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.FiguraDao;
import ar.edu.unlam.tallerweb1.modelo.Figura;
import ar.edu.unlam.tallerweb1.modelo.FiguraTabla;
import ar.edu.unlam.tallerweb1.modelo.Partido;

@Service("servicioFigura")
//Solo necesita leer, no escribir , y no tiene prioridad de generacion
@Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
public class ServicioFiguraImpl implements ServicioFigura {
	
	
	
	@Inject
	private FiguraDao figuraDao;
	
	@Inject
	private ServicioPartido servicioPartido;
	
	
	@Override
	public void guardarFigura(Figura figura) {
		figuraDao.save(figura);
	}
	
	public void actualizarFigura(Figura figura) {
		figuraDao.update(figura);
	}

	
	public Figura buscarFigura(Figura figura) {
		return figuraDao.find(figura);		 
	}

	@Override
	public List<Figura> listarFiguras() {
		return figuraDao.listFiguras();
	}
	

	@Override
	public List<FiguraTabla> listarFiguraTabla(Long idTorneo) {
		List<FiguraTabla> figurasTabla = new ArrayList<>();
		List <Figura> figuras = listarFiguras();
		for(Figura f: figuras){
			 List<Partido> partidos = servicioPartido.buscarPorFiguraYTorneo(f.getId(), idTorneo);
			 if (partidos!=null) {
				 FiguraTabla ft=new FiguraTabla();
				 ft.setFigura(f);
				 ft.setCantFigura(partidos.size());
				 figurasTabla.add(ft);
			 }
		}
		return figurasTabla;
	}
	
	
	
}
