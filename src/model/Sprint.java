package model;

import java.time.LocalDate;

public class Sprint {
	private Integer id;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String nomeSprint;
	private Integer projetoId;
	
	public String getNomeSprint() {
		return nomeSprint;
	}
	public void setNomeSprint(String nomeSprint) {
		this.nomeSprint = nomeSprint;
	}
	
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
	public Integer getProjetoId() {
		return projetoId;
	}
	public void setProjetoId(Integer projetoId) {
		this.projetoId = projetoId;
	}

	
}
