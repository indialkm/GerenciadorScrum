package model;

import java.time.LocalDate;

public class Tarefas {
	private Integer id;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Integer quantHorasUsadas;
	private Integer quantHorasEstimadas;
	private Integer idMembro;
	private Integer idSprint;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	public Integer getQuantHorasUsadas() {
		return quantHorasUsadas;
	}
	public void setQuantHorasUsadas(Integer quantHorasUsadas) {
		this.quantHorasUsadas = quantHorasUsadas;
	}
	public Integer getQuantHorasEstimadas() {
		return quantHorasEstimadas;
	}
	public void setQuantHorasEstimadas(Integer quantHorasEstimadas) {
		this.quantHorasEstimadas = quantHorasEstimadas;
	}
	public Integer getIdMembro() {
		return idMembro;
	}
	public void setIdMembro(Integer idMembro) {
		this.idMembro = idMembro;
	}
	public Integer getIdSprint() {
		return idSprint;
	}
	public void setIdSprint(Integer idSprint) {
		this.idSprint = idSprint;
	}
	
	
}
