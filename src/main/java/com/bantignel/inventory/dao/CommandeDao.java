package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Commande;
@Repository
public class CommandeDao implements ICommandeDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Commande Commande) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(Commande);
		tx.commit();
		session.close();
	}

	public Commande findById(long id) {
		Session session = sessionFactory.openSession();
		Commande Commande = (Commande) session.get(Commande.class,id);
        session.close();
        return Commande;
	}

	public Commande findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Commande> list = (ArrayList<Commande>) session.createQuery("from Commande a where reference =:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Commande Commande) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(Commande);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Commande Commande = (Commande) session.get(Commande.class,id);;
        session.delete(Commande);
        tx.commit();
        session.close();
		
	}

	public List<Commande> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Commande> list = session.createQuery("from Commande").list();
        session.close();
        return list;
	}

}
