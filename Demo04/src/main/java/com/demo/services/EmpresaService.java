package com.demo.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dtos.EmpresaDTO;
import com.demo.entity.Empresa;
import com.demo.repositories.IEmpresaRepository;
import com.demo.services.interfaces.IService;

@Service
public class EmpresaService implements IService<Empresa>, Serializable {

	private static final long serialVersionUID = -2031861817891974590L;

	@Autowired
	private IEmpresaRepository repository;
	
	@Override
	public Empresa cadastrar(Empresa empresa) {
		return this.repository.save(empresa);
	}

	@Override
	public Empresa atualizar(Empresa empresa) throws Exception {
		return this.repository.save(empresa);
	}

	@Override
	public void apagar(Long id) throws Exception {
		this.repository.deleteById(id);
	}

	@Override
	public Empresa buscar(Long id) throws Exception {
		return this.repository.findById(id).get();
	}

	@Override
	public List<Empresa> listaTodos() throws Exception {
		return this.repository.findAll();
	}

	@Override
	public Empresa cadastrarDTO(Object entity) throws Exception {
		
		EmpresaDTO empresaDTO = (EmpresaDTO) entity; 
		
		Empresa empresa = motarObjeto(empresaDTO);
		
		empresa = this.cadastrar(empresa);
		
		return empresa;
	}

	private Empresa motarObjeto(EmpresaDTO empresaDTO) {
		Empresa empresa = new Empresa();
		empresa.setCnpj(empresaDTO.getCnpj());
		empresa.setRazaoSocial(empresaDTO.getRazaoSocial());
		return empresa;
	}

	@Override
	public Empresa atualizarDTO(Object entity) throws Exception {
		return null;
	}

}
