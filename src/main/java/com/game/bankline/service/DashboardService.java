package com.game.bankline.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.bankline.dto.ContaDto;
import com.game.bankline.dto.DashboardDto;
import com.game.bankline.entity.Conta;
import com.game.bankline.entity.Lancamento;
import com.game.bankline.entity.enums.TipoConta;
import com.game.bankline.exceptions.ObjectNotFoundException;
import com.game.bankline.repository.ContaRepository;
import com.game.bankline.repository.LancamentoRepository;

@Service
public class DashboardService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired 
	private ContaRepository contaRepository;
	
	public DashboardDto getLancamentosDaConta(String numeroDaConta, Date dataInicial, Date dataFinal) {
		DashboardDto dashboardDto = new DashboardDto();
		
		if(contaRepository.findAllByNumero(numeroDaConta).isEmpty()) {
			
			throw new ObjectNotFoundException("Conta de numero "+numeroDaConta+" nao encontrada");			
			
		}else {
			
			Conta contaDebito = contaRepository.
					findByNumeroAndTipoConta(numeroDaConta, TipoConta.DEBITO).get();
			Conta contaCredito = contaRepository.
					findByNumeroAndTipoConta(numeroDaConta, TipoConta.CREDITO).get();
			
			dashboardDto.setContaDebito(getLancamentosDaConta(contaDebito,dataInicial,dataFinal));
			dashboardDto.setContaCredito(getLancamentosDaConta(contaCredito,dataInicial,dataFinal));			
		}
		
		return dashboardDto;
	}
	
	public ContaDto getLancamentosDaConta(Conta conta, Date dataInicial, Date dataFinal) {
		ContaDto contaDto = new ContaDto();
		List<Lancamento> lancamentos = lancamentoRepository
				.findAllByContaAndDataBetween(conta.getId(),dataInicial,dataFinal);
		
		contaDto.setId(conta.getId());
		contaDto.setSaldo(conta.getSaldo());
		contaDto.setLancamentos(lancamentos);
		
		return contaDto;		
	}

}
