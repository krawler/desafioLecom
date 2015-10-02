package br.com.ebdes.desafiolecom.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ebdes.desafiolecom.dao.DAOBase;

@Transactional(propagation = Propagation.SUPPORTS)
public abstract class EMDAO<T> implements DAOBase<T> {
	
	@Autowired
	private EntityManagerFactory emf;
	
	protected EntityManager getEntityManager(){
		return getEntityManagerFactory().createEntityManager();
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	public void setSessionFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	protected abstract Class getClazz();
	

	public void persistir(T objeto) {
		getEntityManager().merge(objeto);
	}

	public void excluir(T objeto) {
		getEntityManager().remove(objeto);
	}
	
	public List<T> list(int offset, int max){
		List<T> result = (List<T>) getEntityManager()
				 .createQuery("from "+getClazz().getName(), getClazz())
				 .setFirstResult(offset)
				 .setMaxResults(max)
				 .getResultList();
		
		return (result != null ? result : new ArrayList<T>());
	}
	
	public List<T> listAll(){
		return (List<T>) getEntityManager()
							.createQuery("from "+getClass().getName())
							.getResultList(); 
	}

	public T get(Long id) {
		return (T) getEntityManager().getReference(getClazz(), id);
	}	
}

