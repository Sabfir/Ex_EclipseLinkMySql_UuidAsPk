package com.opinta.dao;

import com.opinta.model.Person_Id_generated_auto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonDAOImpl_id_generated_auto {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void save(Person_Id_generated_auto p) {
		em.persist(p);
	}

	@SuppressWarnings("unchecked")
	public List<Person_Id_generated_auto> list() {
		return em.createQuery("select p from Person_Id_generated_auto p").getResultList();
	}

//	@Transactional(readOnly = true)
	public Person_Id_generated_auto getOne(int id) {
		return em.getReference(Person_Id_generated_auto.class, id);
	}
}
