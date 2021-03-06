package com.game.bankline.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.game.bankline.entity.enums.TipoMovimento;

@Entity
@Table(name="tb_lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer conta;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date data;
	
	private String descricao;

	private Integer tipoMovimento;
	
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "id_plano_conta")
	private PlanoConta planoConta;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PlanoConta getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public TipoMovimento getTipo() {
		return TipoMovimento.toEnum(tipoMovimento);
	}

	public void setTipo(TipoMovimento tipo) {
		this.tipoMovimento = tipo.getId();
	}

}
