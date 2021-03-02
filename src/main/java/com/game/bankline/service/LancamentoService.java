package com.game.bankline.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.bankline.dto.LancamentoDto;
import com.game.bankline.entity.Conta;
import com.game.bankline.entity.Lancamento;
import com.game.bankline.entity.PlanoConta;
import com.game.bankline.exceptions.ObjectNotFoundException;
import com.game.bankline.repository.LancamentoRepository;
import com.game.bankline.repository.PlanoContaRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PlanoContaRepository planoContaRepository;
	
	public Lancamento salvarLancamento(LancamentoDto lancamentoRequest) {
		Lancamento lancamento = new Lancamento();
		lancamento.setConta(lancamentoRequest.getConta());
		lancamento.setData(lancamentoRequest.getData());
		lancamento.setDescricao(lancamentoRequest.getDescricao());
<<<<<<< HEAD
		lancamento.setPlanoConta(lancamentoRequest.getPlanoConta());
		lancamento.setTipo(getPlanoConta(lancamento.getPlanoConta()).getTipoMovimento());
=======
		PlanoConta planoConta = getPlanoConta(lancamentoRequest.getPlanoConta());
		lancamento.setPlanoConta(planoConta);
		lancamento.setTipo(planoConta.getTipoMovimento());
>>>>>>> branch 'master' of https://github.com/tanakav/bankline-gama.git
		lancamento.setValor(lancamentoRequest.getValor());
		
		return lancamentoRepository.save(lancamento);	
	}
	
	private PlanoConta getPlanoConta(Integer id) {
		PlanoConta planoConta = new PlanoConta();
		
		if(planoContaRepository.findById(id).isPresent()) {
			planoConta = planoContaRepository.findById(id).get();
		}else {
			throw new ObjectNotFoundException("Plano Conta de id "+id+" nao encontrado");
		}
		
		return planoConta;
		
	}
	
	private Conta getConta(Integer id) {
		Conta conta = contaRepository.findById(id).get();
		
		if(conta==null) {
			throw new ObjectNotFoundException("Conta de id "+id+" nao encontrado");
		}
		return conta;
	}
	
}
