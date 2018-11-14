package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tabla {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer puntos;
	private Integer ganados;
	private Integer empatados;
	private Integer perdidos;
	private Integer golesfavor;
	private Integer golescontra;
	private Integer diferenciagoles;
	
	
	@ManyToOne (cascade = { CascadeType.ALL } , fetch = FetchType.LAZY)
	private Equipo equipo;
	
	
	
	
	
	
	//GETTER Y SETTER
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	public Integer getGanados() {
		return ganados;
	}
	public void setGanados(Integer ganados) {
		this.ganados = ganados;
	}
	public Integer getEmpatados() {
		return empatados;
	}
	public void setEmpatados(Integer empatados) {
		this.empatados = empatados;
	}
	public Integer getPerdidos() {
		return perdidos;
	}
	public void setPerdidos(Integer perdidos) {
		this.perdidos = perdidos;
	}
	public Integer getGolesfavor() {
		return golesfavor;
	}
	public void setGolesfavor(Integer golesfavor) {
		this.golesfavor = golesfavor;
	}
	public Integer getGolescontra() {
		return golescontra;
	}
	public void setGolescontra(Integer golescontra) {
		this.golescontra = golescontra;
	}
	public Integer getDiferenciagoles() {
		return diferenciagoles;
	}
	public void setDiferenciagoles(Integer diferenciagoles) {
		this.diferenciagoles = diferenciagoles;
	}
	
	
	
	
	

}
