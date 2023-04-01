package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavamavenhibernate.HibernateUtil;

public class DaoGeneric<E> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void salvar(E entidade) {
		EntityTransaction transation = entityManager.getTransaction();
		transation.begin();

		entityManager.persist(entidade);

		transation.commit();
	}

	public E updateMerge(E entidade) {
		EntityTransaction transation = entityManager.getTransaction();
		transation.begin();

		E entidadeSalva = entityManager.merge(entidade);

		transation.commit();
		return entidadeSalva;
	}

	public E pesquisar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);

		@SuppressWarnings("unchecked")
		E e = (E) entityManager.find(entidade.getClass(), id);

		return e;
	}

	public void deletar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);

		EntityTransaction transation = entityManager.getTransaction();
		transation.begin();

		entityManager.createNativeQuery("delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where id = " + id).executeUpdate();

		transation.commit();
	}

	public List<E> pesquisarLista(Class<E> entidade) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		@SuppressWarnings("unchecked")
		List<E> registros = entityManager.createQuery("from " + entidade.getName()).getResultList();
		transaction.commit();

		return registros;
	}

}
