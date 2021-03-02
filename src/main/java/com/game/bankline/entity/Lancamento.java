package com.game.bankline.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.game.bankline.entity.enums.TipoMovimento;

@Entity
@Table(name="tb_lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private Integer conta;
	
	@Column(columnDefinition = "DATE")
	private LocalDate data;
	
	private String descricao;

	@Enumerated(EnumType.STRING)
	private TipoMovimento tipo;
	
	private Double valor;
	
	
	private Integer planoConta;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	

	public TipoMovimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimento tipo) {
		this.tipo = tipo;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public Integer getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(Integer planoConta) {
		this.planoConta = planoConta;
	}

	

	
	
}
