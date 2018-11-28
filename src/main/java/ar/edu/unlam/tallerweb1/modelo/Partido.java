package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import org.springframework.format.annotation.*;
import java.text.*;
import java.util.*;

@Entity
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer golesLocales = 0;
	private Integer golesVisitantes = 0;

	@ManyToOne // (cascade = { CascadeType.ALL } , fetch = FetchType.LAZY)
	private Equipo equipoLocal;

	@ManyToOne // (cascade = { CascadeType.ALL } , fetch = FetchType.LAZY)
	private Equipo equipoVisitante;

	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private Date fechaPartido;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Fecha fecha;

	private Boolean isTerminado = false;
	private Boolean isResultadoFinal = false;

	@OneToOne
	private Equipo ganador;

	public Partido() {
	}

	public Partido(Equipo equipoLocal, Equipo equipoVisitante) {

		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesLocales = 0;
		this.golesVisitantes = 0;
		this.isTerminado = false;
		this.isResultadoFinal = false;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGolesLocales() {
		return golesLocales;
	}

	public void setGolesLocales(Integer golesLocales) {
		this.golesLocales = golesLocales;
	}

	public Integer getGolesVisitantes() {
		return golesVisitantes;
	}

	public void setGolesVisitantes(Integer golesVisitantes) {
		this.golesVisitantes = golesVisitantes;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public Date getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(Date fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public Boolean getIsTerminado() {
		return isTerminado;
	}

	public void setIsTerminado(Boolean isTerminado) {
		this.isTerminado = isTerminado;
	}

	public Boolean getIsResultadoFinal() {
		return isResultadoFinal;
	}

	public void setIsResultadoFinal(Boolean isResultadoFinal) {
		this.isResultadoFinal = isResultadoFinal;
	}

	public String mostrarResultado() {
		return equipoLocal.getNombre() + " " + this.golesLocales + " - " + this.golesVisitantes + " "
				+ equipoVisitante.getNombre();
	}

	public String getInformacion() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm");
		String fechaSimple = dateFormat.format(fecha);
		return equipoLocal.getNombre() + " Vs " + equipoVisitante.getNombre() + " - " + fechaSimple + "Hs";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipoLocal == null) ? 0 : equipoLocal.hashCode());
		result = prime * result + ((equipoVisitante == null) ? 0 : equipoVisitante.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((golesLocales == null) ? 0 : golesLocales.hashCode());
		result = prime * result + ((golesVisitantes == null) ? 0 : golesVisitantes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isResultadoFinal == null) ? 0 : isResultadoFinal.hashCode());
		result = prime * result + ((isTerminado == null) ? 0 : isTerminado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		if (equipoLocal == null) {
			if (other.equipoLocal != null)
				return false;
		} else if (!equipoLocal.equals(other.equipoLocal))
			return false;
		if (equipoVisitante == null) {
			if (other.equipoVisitante != null)
				return false;
		} else if (!equipoVisitante.equals(other.equipoVisitante))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (golesLocales == null) {
			if (other.golesLocales != null)
				return false;
		} else if (!golesLocales.equals(other.golesLocales))
			return false;
		if (golesVisitantes == null) {
			if (other.golesVisitantes != null)
				return false;
		} else if (!golesVisitantes.equals(other.golesVisitantes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isResultadoFinal == null) {
			if (other.isResultadoFinal != null)
				return false;
		} else if (!isResultadoFinal.equals(other.isResultadoFinal))
			return false;
		if (isTerminado == null) {
			if (other.isTerminado != null)
				return false;
		} else if (!isTerminado.equals(other.isTerminado))
			return false;
		return true;
	}

	public Equipo getGanador() {
		return ganador;
	}

	public void setGanador(Equipo ganador) {

		if (this.getGolesLocales() > this.getGolesVisitantes()) {
			this.ganador = this.equipoLocal;
		} else {
			this.ganador = this.equipoVisitante;
		}
	}
}