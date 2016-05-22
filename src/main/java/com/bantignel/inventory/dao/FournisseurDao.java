package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Fournisseur;
@Repository
public class FournisseurDao implements IFournisseurDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Fournisseur Fournisseur) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(Fournisseur);
		tx.commit();
		session.close();
	}

	public Fournisseur findById(long id) {
		Session session = sessionFactory.openSession();
		Fournisseur Fournisseur = (Fournisseur) session.get(Fournisseur.class,id);
        session.close();
        return Fournisseur;
	}

	public Fournisseur findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Fournisseur> list = (ArrayList<Fournisseur>) session.createQuery("from Fournisseur a where nom =:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Fournisseur Fournisseur) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(Fournisseur);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Fournisseur Fournisseur = (Fournisseur) session.get(Fournisseur.class,id);;
        session.delete(Fournisseur);
        tx.commit();
        session.close();
		
	}

	public List<Fournisseur> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Fournisseur> list = session.createQuery("from Fournisseur").list();
        session.close();
        return list;
	}

}
