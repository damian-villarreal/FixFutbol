package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Torneo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String tipoTorneo;
	private Boolean isTerminado = false;
	private Integer cantPartidos;
	private Integer cantPartidosJugados;
	
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
	public Boolean getIsTerminado() {
		return isTerminado;
	}
	public void setIsTerminado(Boolean isTerminado) {
		this.isTerminado = isTerminado;
	}
	public Integer getCantPartidos() {
		return cantPartidos;
	}
	public void setCantPartidos(Integer cantPartidos) {
		this.cantPartidos = cantPartidos;
	}
	public Integer getCantPartidosJugados() {
		return cantPartidosJugados;
	}
	public void setCantPartidosJugados(Integer cantPartidosJugados) {
		this.cantPartidosJugados = cantPartidosJugados;
	}
	
}
