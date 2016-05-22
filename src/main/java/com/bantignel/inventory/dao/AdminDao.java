package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Admin;

@Repository
public class AdminDao implements IAdminDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Admin Admin) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(Admin);
		tx.commit();
		session.close();
	}

	public Admin findById(long id) {
		Session session = sessionFactory.openSession();
		Admin Admin = (Admin) session.get(Admin.class,id);
        session.close();
        return Admin;
	}

	public Admin findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Admin> list = (ArrayList<Admin>) session.createQuery("from Admin a where nom =:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Admin Admin) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(Admin);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Admin Admin = (Admin) session.get(Admin.class,id);;
        session.delete(Admin);
        tx.commit();
        session.close();
		
	}

	public List<Admin> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Admin> list = session.createQuery("from Admin").list();
        session.close();
        return list;
	}

}
