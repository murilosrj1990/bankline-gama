package com.game.bankline.dto;

import java.util.List;

import com.game.bankline.entity.Lancamento;

public class ContaDto {
	
	private Integer id;
	private Double saldo;
	private List<Lancamento> lancamentos;
	
	public ContaDto() {}
	
	public ContaDto(Integer numero, String tipo, Double saldo, List<Lancamento> lancamentos) {
		super();
		this.id = numero;
		this.lancamentos = lancamentos;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	

}
