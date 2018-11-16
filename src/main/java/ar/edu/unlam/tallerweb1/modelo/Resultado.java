package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Resultado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numero;
	
	@ManyToOne(fetch = FetchType.LAZY , cascade = { CascadeType.ALL })
	private Partido partido;
	
	@ManyToOne(fetch = FetchType.LAZY , cascade = { CascadeType.ALL })
	private Equipo equipoLocal;
	
	@ManyToOne(fetch = FetchType.LAZY , cascade = { CascadeType.ALL })
	private Equipo equipoVisitante;
	
	@ManyToOne(fetch = FetchType.LAZY , cascade = { CascadeType.ALL })
	private Tabla tabla;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
