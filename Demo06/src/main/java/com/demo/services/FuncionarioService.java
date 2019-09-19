package com.demo.services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dtos.FuncionarioDTO;
import com.demo.entity.Funcionario;
import com.demo.enums.PerfilEnum;
import com.demo.repositories.IFuncionarioRepository;
import com.demo.services.interfaces.IFuncionarioService;

@Service
public class FuncionarioService implements IFuncionarioService, Serializable {

	private static final long serialVersionUID = 145559084914989468L;

	@Autowired
	private IFuncionarioRepository funcionarioRepository;
	
	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
	}
	
	public Funcionario cadastrar(Funcionario funcionario) {
		return this.funcionarioRepository.save(funcionario);
	}

	public Funcionario atualizar(Funcionario funcionario) throws Exception {
		return this.funcionarioRepository.save(funcionario);
	}

	public void apagar(Long id) throws Exception {
		this.funcionarioRepository.deleteById(id);
	}

	public Funcionario buscar(Long id) throws Exception {
		return this.funcionarioRepository.findById(id).get();
	}

	public List<Funcionario> listaTodos() throws Exception {
		return this.funcionarioRepository.findAll();
	}

	public Funcionario cadastrarDTO(Object entity) throws Exception {
		
		FuncionarioDTO funcionarioDTO = (FuncionarioDTO) entity;
		
		Funcionario funcionario = montaObjeto(funcionarioDTO);
		
		funcionario = this.cadastrar(funcionario);
		
		return funcionario;
	}

	private Funcionario montaObjeto(FuncionarioDTO funcionarioDTO) throws Exception {
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf(funcionarioDTO.getCpf());
		funcionario.setEmail(funcionarioDTO.getEmail());
		funcionario.setNome(funcionarioDTO.getNome());
		funcionario.setQtdHrAlmoco(Float.valueOf(funcionarioDTO.getQtdHrAlmoco()));
		funcionario.setQtdHrTrabalhoDia(Float.valueOf(funcionarioDTO.getQtdHrTrabalhoDia()));
		funcionario.setSenha(funcionarioDTO.getSenha());
		funcionario.setValorHora(new BigDecimal(funcionarioDTO.getValorHora()));
		funcionario.setPerfil(PerfilEnum.getByCodigo(Integer.valueOf(funcionarioDTO.getPerfil())));

		return funcionario;
	}

}
