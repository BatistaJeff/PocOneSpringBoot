package com.demo.services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dtos.FuncionarioDTO;
import com.demo.entity.Empresa;
import com.demo.entity.Funcionario;
import com.demo.enums.PerfilEnum;
import com.demo.repositories.IEmpresaRepository;
import com.demo.repositories.IFuncionarioRepository;
import com.demo.services.interfaces.IService;

@Service
public class FuncionarioService implements IService<Funcionario>, Serializable {

	private static final long serialVersionUID = 145559084914989468L;

	@Autowired
	private IFuncionarioRepository funcionarioRepository;
	@Autowired
	private IEmpresaRepository empresaRepository;
	
	@Override
	public Funcionario cadastrar(Funcionario funcionario) {
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public Funcionario atualizar(Funcionario funcionario) throws Exception {
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public void apagar(Long id) throws Exception {
		this.funcionarioRepository.deleteById(id);
	}

	@Override
	public Funcionario buscar(Long id) throws Exception {
		return this.funcionarioRepository.findById(id).get();
	}

	@Override
	public List<Funcionario> listaTodos() throws Exception {
		return this.funcionarioRepository.findAll();
	}

	@Override
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

		Empresa empresa = this.empresaRepository.findByCnpj(funcionarioDTO.getCnpjEmpresa());
		if(empresa == null)
			throw new Exception("Empresa não localizada");
		
		funcionario.setEmpresa(empresa);
		
		return funcionario;
	}

	@Override
	public Funcionario atualizarDTO(Object entity) throws Exception {
		return null;
	}

}
