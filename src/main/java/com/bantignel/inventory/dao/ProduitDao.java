package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Produit;

@Repository
public class ProduitDao implements IProduitDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Produit produit) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(produit);
		tx.commit();
		session.close();
	}

	public Produit findById(long id) {
		Session session = sessionFactory.openSession();
		Produit Produit = (Produit) session.get(Produit.class,id);
        session.close();
        return Produit;
	}

	public Produit findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Produit> list = (ArrayList<Produit>) session.createQuery("from Produit p where p.reference =:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Produit produit) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(produit);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Produit Produit = (Produit) session.get(Produit.class,id);;
        session.delete(Produit);
        tx.commit();
        session.close();
		
	}

	public List<Produit> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Produit> list = session.createQuery("from Produit").list();
        session.close();
        return list;
	}

}
