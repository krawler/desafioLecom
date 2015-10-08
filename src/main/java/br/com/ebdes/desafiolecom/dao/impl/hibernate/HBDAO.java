package br.com.ebdes.desafiolecom.dao.impl.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ebdes.desafiolecom.dao.DAOBase;

public abstract class HBDAO<T> implements DAOBase<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sf) {sessionFactory = sf;}
	
	protected Session getSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	protected abstract Class getClazz();
	
	@Transactional
	public void persistir(T objeto) {
		getSession().saveOrUpdate(objeto);
	}
	
	@Transactional
	public void excluir(T objeto) {
		getSession().delete(objeto);
	}
	
	@Transactional
	public T get(Long id) {
		return (T) getSession().get(getClazz(), id);
	}
	
	@Transactional
	public List<T> list(int offset, int max) {
		return (List<T>) getSession().createCriteria(getClazz())
						   .setMaxResults(max)
						   .setFirstResult(offset).list();
	}
	
	public List<T> listAll(){
		return (List<T>) getSession().createCriteria(getClazz()).list(); 
	}

	

}
