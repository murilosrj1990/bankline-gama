package com.game.bankline.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LancamentoDto {
	
	private Integer conta;
	
<<<<<<< HEAD
	private String contaDestino;

	private LocalDate data;
=======
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date data;
>>>>>>> branch 'master' of https://github.com/tanakav/bankline-gama.git
	
	private String descricao;

	private Integer planoConta;
	
	private Double valor;
	
	public LancamentoDto() {}
<<<<<<< HEAD
	
	public LancamentoDto(Integer conta, LocalDate data, String descricao, Integer planoConta, Double valor) {
=======

	public LancamentoDto(Integer conta, Date data, String descricao, Integer planoConta, Double valor) {
>>>>>>> branch 'master' of https://github.com/tanakav/bankline-gama.git
		super();
		this.conta = conta;
		this.data = data;
		this.descricao = descricao;
		this.planoConta = planoConta;
		this.valor = valor;
	}

	public LancamentoDto(Integer conta,String contaDestino, LocalDate data, String descricao, Integer planoConta, Double valor) {
		super();
		this.conta = conta;
		this.contaDestino=contaDestino;
		this.data = data;
		this.descricao = descricao;
		this.planoConta = planoConta;
		this.valor = valor;
	}
	

	public Integer getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(Integer planoConta) {
		this.planoConta = planoConta;
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

<<<<<<< HEAD
=======
	public Integer getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(Integer planoConta) {
		this.planoConta = planoConta;
	}

>>>>>>> branch 'master' of https://github.com/tanakav/bankline-gama.git
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
