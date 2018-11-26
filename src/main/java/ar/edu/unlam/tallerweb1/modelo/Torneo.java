package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Torneo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String tipoTorneo;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public String getTipoTorneo() {
		return tipoTorneo;
	}
	public void setTipoTorneo(String tipoTorneo) {
		this.tipoTorneo = tipoTorneo;
	}
	
}
