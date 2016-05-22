package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Famille;
@Repository
public class FamilleDao implements IFamilleDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Famille Famille) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(Famille);
		tx.commit();
		session.close();
	}

	public Famille findById(long id) {
		Session session = sessionFactory.openSession();
		Famille Famille = (Famille) session.get(Famille.class,id);
        session.close();
        return Famille;
	}

	public Famille findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Famille> list = (ArrayList<Famille>) session.createQuery("from Famille a where reference=:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Famille Famille) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(Famille);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Famille Famille = (Famille) session.get(Famille.class,id);;
        session.delete(Famille);
        tx.commit();
        session.close();
		
	}

	public List<Famille> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Famille> list = session.createQuery("from Famille").list();
        session.close();
        return list;
	}

}
