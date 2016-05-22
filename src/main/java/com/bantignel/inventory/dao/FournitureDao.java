package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Fourniture;
@Repository
public class FournitureDao implements IFournitureDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Fourniture Fourniture) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(Fourniture);
		tx.commit();
		session.close();
	}

	public Fourniture findById(long id) {
		Session session = sessionFactory.openSession();
		Fourniture Fourniture = (Fourniture) session.get(Fourniture.class,id);
        session.close();
        return Fourniture;
	}

	public Fourniture findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Fourniture> list = (ArrayList<Fourniture>) session.createQuery("from Fourniture a where reference =:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Fourniture Fourniture) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(Fourniture);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Fourniture Fourniture = (Fourniture) session.get(Fourniture.class,id);;
        session.delete(Fourniture);
        tx.commit();
        session.close();
		
	}

	public List<Fourniture> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Fourniture> list = session.createQuery("from Fourniture").list();
        session.close();
        return list;
	}

}
