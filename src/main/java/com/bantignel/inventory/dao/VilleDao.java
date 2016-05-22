package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Ville;
@Repository
public class VilleDao implements IVilleDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Ville Ville) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(Ville);
		tx.commit();
		session.close();
	}

	public Ville findById(long id) {
		Session session = sessionFactory.openSession();
		Ville Ville = (Ville) session.get(Ville.class,id);
        session.close();
        return Ville;
	}

	public Ville findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Ville> list = (ArrayList<Ville>) session.createQuery("from Ville a where nom =:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Ville Ville) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(Ville);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Ville Ville = (Ville) session.get(Ville.class,id);;
        session.delete(Ville);
        tx.commit();
        session.close();
		
	}

	public List<Ville> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Ville> list = session.createQuery("from Ville").list();
        session.close();
        return list;
	}

}
