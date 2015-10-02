package br.com.ebdes.desafiolecom.dao;

import java.util.List;

public interface DAOBase<T> {

	public List<T> list(int offset, int max);
	
	public List<T> listAll();
	
	public void persistir(T objeto);
	
	public void excluir(T objeto);
	
	public T get(Long id);
}
