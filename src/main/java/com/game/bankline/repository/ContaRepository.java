package com.game.bankline.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.bankline.entity.Conta;
import com.game.bankline.entity.enums.TipoConta;

public interface ContaRepository extends JpaRepository<Conta, Integer>{
	
	Optional<Conta> findByNumeroAndTipoConta(String numeroDaConta, TipoConta tipoMovimento);
	
	List<Conta> findAllByNumero(String numeroDaConta);	

}
