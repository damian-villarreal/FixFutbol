package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tabla {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer puntos;
	private Integer jugados;
	private Integer ganados;
	private Integer empatados;
	private Integer perdidos;
	private Integer golesfavor;
	private Integer golescontra;
	private Integer diferenciagoles;
	
	@ManyToOne (cascade = { CascadeType.ALL } , fetch = FetchType.EAGER)
	@JsonIgnore
	private Equipo equipo;
	
	@ManyToOne
	private Torneo torneo;
	
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
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public Integer getJugados() {
		return jugados;
	}
	public void setJugados(Integer jugados) {
		this.jugados = jugados;
	}
	
	public Torneo getTorneo() {
		return torneo;
	}
	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}
}
