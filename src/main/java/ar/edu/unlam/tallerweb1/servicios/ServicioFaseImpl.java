package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.FaseDao;
import ar.edu.unlam.tallerweb1.modelo.Fase;

@Service("servicioFase")
//Solo necesita leer , no escribir , y no tiene prioridad de generacion
@Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
public class ServicioFaseImpl implements ServicioFase {
	
	@Inject
    private FaseDao faseDao;
	
    private String faseOctavos;
    private String faseCuartos;
    private String faseSemiFinal;
    private String faseFinal;

    private String OCTAVOS_1;
    private String OCTAVOS_2;
    private String OCTAVOS_3;
    private String OCTAVOS_4;
    private String OCTAVOS_5;
    private String OCTAVOS_6;
    private String OCTAVOS_7;
    private String OCTAVOS_8;

    private String CUARTOS_1;
    private String CUARTOS_2;
    private String CUARTOS_3;
    private String CUARTOS_4;

    private String SEMIFINAL_1;
    private String SEMIFINAL_2;
    
    private String FINAL;
    
	@Override
	public List<Fase> crearFases() {
		
		List<Fase> fases = new ArrayList<>();
		
		fases.add(new Fase(OCTAVOS_1, faseOctavos));
		fases.add(new Fase(OCTAVOS_2, faseOctavos));
		fases.add(new Fase(OCTAVOS_3, faseOctavos));
		fases.add(new Fase(OCTAVOS_4, faseOctavos));
		fases.add(new Fase(OCTAVOS_5, faseOctavos));
		fases.add(new Fase(OCTAVOS_6, faseOctavos));
		fases.add(new Fase(OCTAVOS_7, faseOctavos));
		fases.add(new Fase(OCTAVOS_8, faseOctavos));
		
		fases.add(new Fase(CUARTOS_1, faseCuartos));
		fases.add(new Fase(CUARTOS_2, faseCuartos));
		fases.add(new Fase(CUARTOS_3, faseCuartos));
		fases.add(new Fase(CUARTOS_4, faseCuartos));
		
		fases.add(new Fase(SEMIFINAL_1, faseSemiFinal));
		fases.add(new Fase(SEMIFINAL_2, faseSemiFinal));
		
		fases.add(new Fase(FINAL, faseFinal));
		
		return fases;
		
	}

	@Override
	public void guardarFases(List<Fase> fases) {
		for(Fase fase : fases) {
			faseDao.create(fase);	
		}	
	}

	@Override
	public void actualizarFases(List<Fase> fases) {
		for(Fase fase : fases) {
			faseDao.update(fase);
		}	
	}

	@Override
	public List<Fase> armarFases() {
		
		Fase octavos1 = faseDao.readFase(OCTAVOS_1, faseOctavos);
		Fase octavos2 = faseDao.readFase(OCTAVOS_2, faseOctavos);
		Fase octavos3 = faseDao.readFase(OCTAVOS_3, faseOctavos);
		Fase octavos4 = faseDao.readFase(OCTAVOS_4, faseOctavos);
		Fase octavos5 = faseDao.readFase(OCTAVOS_5, faseOctavos);
		Fase octavos6 = faseDao.readFase(OCTAVOS_6, faseOctavos);
		Fase octavos7 = faseDao.readFase(OCTAVOS_7, faseOctavos);
		Fase octavos8 = faseDao.readFase(OCTAVOS_8, faseOctavos);

		Fase cuartos1 = faseDao.readFase(CUARTOS_1, faseCuartos);
		Fase cuartos2 = faseDao.readFase(CUARTOS_2, faseCuartos);
		Fase cuartos3 = faseDao.readFase(CUARTOS_3, faseCuartos);
		Fase cuartos4 = faseDao.readFase(CUARTOS_4, faseCuartos);
       
		Fase semifinal1 = faseDao.readFase(SEMIFINAL_1, faseSemiFinal);
		Fase semifinal2 = faseDao.readFase(SEMIFINAL_2, faseSemiFinal);

		Fase partidoFinal = faseDao.readFase(FINAL, faseFinal);
        
		octavos1.setSiguienteFase(cuartos1);
		octavos2.setSiguienteFase(cuartos1);
		
		octavos3.setSiguienteFase(cuartos2);
		octavos4.setSiguienteFase(cuartos2);
		
		octavos5.setSiguienteFase(cuartos3);
		octavos6.setSiguienteFase(cuartos3);
		
		octavos7.setSiguienteFase(cuartos4);
		octavos8.setSiguienteFase(cuartos4);
		
		cuartos1.setSiguienteFase(semifinal1);
		cuartos2.setSiguienteFase(semifinal1);
		
		cuartos3.setSiguienteFase(semifinal2);
		cuartos4.setSiguienteFase(semifinal2);
		
		semifinal1.setSiguienteFase(partidoFinal);
		semifinal2.setSiguienteFase(partidoFinal);
		
		List<Fase> fases = new ArrayList<>();
		
		fases.add(octavos1);
		fases.add(octavos2);
		fases.add(octavos3);
		fases.add(octavos4);
		fases.add(octavos5);
		fases.add(octavos6);
		fases.add(octavos7);
		fases.add(octavos8);
		
		fases.add(cuartos1);
		fases.add(cuartos2);
		fases.add(cuartos3);
		fases.add(cuartos4);
		
		fases.add(semifinal1);
		fases.add(semifinal2);
		
		fases.add(partidoFinal);
		
		return fases;
	}
}
