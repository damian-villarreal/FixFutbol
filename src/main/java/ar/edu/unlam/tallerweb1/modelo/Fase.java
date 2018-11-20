package ar.edu.unlam.tallerweb1.modelo;
import javax.persistence.*;

@Entity
public class Fase {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreDeLaFase;
	private String instancia;
	@OneToOne
	private Fase siguienteFase;
	
	public Fase(String instancia, String nombreDeLaFase) {
		this.nombreDeLaFase = nombreDeLaFase;
		this.instancia = instancia;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstancia() {
		return instancia;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}

	public String getNombreDeLaFase() {
		return nombreDeLaFase;
	}

	public void setNombreDeLaFase(String nombreDeLaFase) {
		this.nombreDeLaFase = nombreDeLaFase;
	}

	public Fase getSiguienteFase() {
		return siguienteFase;
	}

	public void setSiguienteFase(Fase siguienteFase) {
		this.siguienteFase = siguienteFase;
	}	
}
