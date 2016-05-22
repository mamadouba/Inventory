package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Facture;
@Repository
public class FactureDao implements IFactureDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Facture Facture) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(Facture);
		tx.commit();
		session.close();
	}

	public Facture findById(long id) {
		Session session = sessionFactory.openSession();
		Facture Facture = (Facture) session.get(Facture.class,id);
        session.close();
        return Facture;
	}

	public Facture findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Facture> list = (ArrayList<Facture>) session.createQuery("from Facture a where nom =:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Facture Facture) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(Facture);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Facture Facture = (Facture) session.get(Facture.class,id);;
        session.delete(Facture);
        tx.commit();
        session.close();
		
	}

	public List<Facture> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Facture> list = session.createQuery("from Facture").list();
        session.close();
        return list;
	}

}
