package com.opinta.dao;

import java.util.List;

import com.opinta.model.Person_UUID_generated_uuid2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonDAOImpl_UUID_generated_uuid2 {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void save(Person_UUID_generated_uuid2 p) {
		em.persist(p);
	}

	@SuppressWarnings("unchecked")
	public List<Person_UUID_generated_uuid2> list() {
		return em.createQuery("select p from Person_UUID_generated_uuid2 p").getResultList();
	}

//	@Transactional(readOnly = true)
	public Person_UUID_generated_uuid2 getOne(String id) {
		return em.getReference(Person_UUID_generated_uuid2.class, id);
	}
}
