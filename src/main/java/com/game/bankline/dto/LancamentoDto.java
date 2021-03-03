package com.game.bankline.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LancamentoDto {
	
	private Integer conta;
  
	private String contaDestino;
  
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date data;
  
	private String descricao;
	
	private String contaDestino;

	private Integer planoConta;
	
	private Double valor;
	
	public LancamentoDto() {}
  
	public LancamentoDto(Integer conta, Date data, String descricao, Integer planoConta, Double valor) {
		super();
		this.conta = conta;
		this.data = data;
		this.descricao = descricao;
		this.planoConta = planoConta;
		this.valor = valor;
	}
  
	public LancamentoDto(Integer conta, Date data,String contaDestino, String descricao, Integer planoConta, Double valor) {
		super();
		this.conta = conta;
		this.data = data;
		this.descricao = descricao;
		this.planoConta = planoConta;
		this.valor = valor;
	}
  
	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}	

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
  
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
