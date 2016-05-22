package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Ligne;
@Repository
public class LigneDao implements ILigneDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Ligne Ligne) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(Ligne);
		tx.commit();
		session.close();
	}

	public Ligne findById(long id) {
		Session session = sessionFactory.openSession();
		Ligne Ligne = (Ligne) session.get(Ligne.class,id);
        session.close();
        return Ligne;
	}

	public Ligne findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Ligne> list = (ArrayList<Ligne>) session.createQuery("from Ligne a where reference =:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Ligne Ligne) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(Ligne);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Ligne Ligne = (Ligne) session.get(Ligne.class,id);;
        session.delete(Ligne);
        tx.commit();
        session.close();
		
	}

	public List<Ligne> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Ligne> list = session.createQuery("from Ligne").list();
        session.close();
        return list;
	}

}
