package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Paiement;
@Repository
public class PaiementDao implements IPaiementDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Paiement Paiement) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(Paiement);
		tx.commit();
		session.close();
	}

	public Paiement findById(long id) {
		Session session = sessionFactory.openSession();
		Paiement Paiement = (Paiement) session.get(Paiement.class,id);
        session.close();
        return Paiement;
	}

	public Paiement findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Paiement> list = (ArrayList<Paiement>) session.createQuery("from Paiement a where reference =:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Paiement Paiement) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(Paiement);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Paiement Paiement = (Paiement) session.get(Paiement.class,id);;
        session.delete(Paiement);
        tx.commit();
        session.close();
		
	}

	public List<Paiement> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Paiement> list = session.createQuery("from Paiement").list();
        session.close();
        return list;
	}

}
