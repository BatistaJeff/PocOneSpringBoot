package com.demo.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dtos.LancamentoDTO;
import com.demo.entity.Funcionario;
import com.demo.entity.Lancamento;
import com.demo.enums.TipoEnum;
import com.demo.repositories.IFuncionarioRepository;
import com.demo.repositories.ILancamentoRepository;
import com.demo.services.interfaces.IService;
import com.demo.utils.DemoUtils;

@Service
public class LancamentoService implements IService<Lancamento>, Serializable {

	private static final long serialVersionUID = -4657224560124684430L;

	@Autowired
	private ILancamentoRepository lancamentoRepository;
	@Autowired
	private IFuncionarioRepository funcionarioRepository;

	@Override
	public Lancamento cadastrar(Lancamento lancamento) {
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public Lancamento atualizar(Lancamento lancamento) throws Exception {
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void apagar(Long id) throws Exception {
		this.lancamentoRepository.deleteById(id);
	}

	@Override
	public Lancamento buscar(Long id) throws Exception {
		return this.lancamentoRepository.findById(id).get();
	}

	@Override
	public List<Lancamento> listaTodos() throws Exception {
		return this.lancamentoRepository.findAll();
	}

	@Override
	public Lancamento cadastrarDTO(Object entity) throws Exception {
		
		LancamentoDTO lancamentoDTO = (LancamentoDTO) entity;
		
		Lancamento lancamento = montarObjeto(lancamentoDTO);
		
		lancamento = this.cadastrar(lancamento);

		return lancamento;
	}

	private Lancamento montarObjeto(LancamentoDTO lancamentoDTO) throws Exception {
		
		Lancamento lancamento = new Lancamento();
		lancamento.setData(DemoUtils.formatadaData(lancamentoDTO.getData()));
		lancamento.setDescricao(lancamentoDTO.getDescricao());
		lancamento.setLocalizacao(lancamentoDTO.getLocalizacao());
		lancamento.setTipo(TipoEnum.getByCodigo(Integer.valueOf(lancamentoDTO.getTipo())));
		Funcionario funcionario = this.funcionarioRepository.findOneByCpf(lancamentoDTO.getCpfFuncionario());
		if(funcionario == null)
			throw new Exception("Funcionario não localizado");
		lancamento.setFuncionario(funcionario);
		
		return lancamento;
	}

	@Override
	public Lancamento atualizarDTO(Object entity) throws Exception {
		return null;
	}
	
}
