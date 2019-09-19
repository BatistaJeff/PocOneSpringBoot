package com.demo.services.interfaces;

import java.util.List;

public interface IService<T> {	
	
	public T cadastrar(T entity) throws Exception;
	
	public T atualizar(T entity) throws Exception;
	
	public void apagar(Long id) throws Exception;
	
	public T buscar(Long id) throws Exception;
	
	public List<T> listaTodos() throws Exception;
	
	public T cadastrarDTO(Object entity) throws Exception;
	
	public T atualizarDTO(Object entity) throws Exception;

}
