package com.game.bankline.service;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.game.bankline.entity.Conta;
import com.game.bankline.entity.Login;
import com.game.bankline.entity.Sessao;
import com.game.bankline.entity.Usuario;
import com.game.bankline.entity.enums.TipoConta;
import com.game.bankline.exceptions.ObjectNotFoundException;
import com.game.bankline.repository.ContaRepository;
import com.game.bankline.repository.UsuarioRepository;

@Service
public class LoginService {
	
	private static Long EXPIRATION_TIME=1800000L;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@SuppressWarnings("deprecation")
	public Sessao fazerLogin(Login login) {
		Usuario usuario=new Usuario();
		Conta contaCredito = new Conta();
		Conta contaDebito = new Conta();
		if(usuarioRepository.findByCpf(login.getLogin()).isPresent()){
			usuario = usuarioRepository.findByCpf(login.getLogin()).get();
			if(validaSenha(login.getPassword(),usuario.getSenha())==false) {
				throw new ObjectNotFoundException("Usuario ou senha errada!");
			}
        } else if(usuarioRepository.findByLogin(login.getLogin()).isPresent()){
        	usuario = usuarioRepository.findByLogin(login.getLogin()).get();
			if(validaSenha(login.getPassword(),usuario.getSenha())==false) {
				throw new ObjectNotFoundException("Usuario ou senha errada!");
			}
        }else {
        	throw new ObjectNotFoundException("Usuario ou senha errada!");
        }
		
		Sessao sessao = new Sessao();
		sessao.setUsuario(usuario);
		contaCredito = contaRepository.findByNumeroAndTipoConta(usuario.getLogin(), TipoConta.CREDITO).get();
		sessao.setContaCredito(contaCredito);
		contaDebito = contaRepository.findByNumeroAndTipoConta(usuario.getLogin(), TipoConta.DEBITO).get();
		sessao.setContaDebito(contaDebito);
		Date dataAtual = new Date(System.currentTimeMillis());
		sessao.setDataInicio(dataAtual.toGMTString());
		Date dataExpiracao = new Date(dataAtual.getTime()+EXPIRATION_TIME);
		sessao.setDataFim(dataExpiracao.toGMTString());
		return sessao;
	}
	
	private boolean validaSenha(String senhaPura, String senhaEncoded) {
		passwordEncoder= new BCryptPasswordEncoder();
		return passwordEncoder.matches(senhaPura, senhaEncoded);
	}
	

}
