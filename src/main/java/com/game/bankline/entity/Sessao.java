package com.game.bankline.entity;

import java.sql.Date;

public class Sessao {
	
	private Conta contaCredito;
	
	private Conta contaDebito;
	
	private String dataInicio;
	
	private String dataFim;
	
	private String token;
	
	private Usuario usuario;
	
	
	public Conta getContaCredito() {
		return contaCredito;
	}
	public void setContaCredito(Conta contaCredito) {
		this.contaCredito = contaCredito;
	}
	public Conta getContaDebito() {
		return contaDebito;
	}
	public void setContaDebito(Conta contaDebito) {
		this.contaDebito = contaDebito;
	}
	
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
