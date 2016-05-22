package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Rayon;
@Repository
public class RayonDao implements IRayonDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Rayon Rayon) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(Rayon);
		tx.commit();
		session.close();
	}

	public Rayon findById(long id) {
		Session session = sessionFactory.openSession();
		Rayon Rayon = (Rayon) session.get(Rayon.class,id);
        session.close();
        return Rayon;
	}

	public Rayon findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Rayon> list = (ArrayList<Rayon>) session.createQuery("from Rayon a where reference =:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Rayon Rayon) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(Rayon);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Rayon Rayon = (Rayon) session.get(Rayon.class,id);;
        session.delete(Rayon);
        tx.commit();
        session.close();
		
	}

	public List<Rayon> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Rayon> list = session.createQuery("from Rayon").list();
        session.close();
        return list;
	}

}
