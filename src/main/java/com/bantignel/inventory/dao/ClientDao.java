package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Client;
@Repository
public class ClientDao implements IClientDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Client Client) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(Client);
		tx.commit();
		session.close();
	}

	public Client findById(long id) {
		Session session = sessionFactory.openSession();
		Client Client = (Client) session.get(Client.class,id);
        session.close();
        return Client;
	}

	public Client findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Client> list = (ArrayList<Client>) session.createQuery("from Client a where nom =:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Client Client) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(Client);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Client Client = (Client) session.get(Client.class,id);;
        session.delete(Client);
        tx.commit();
        session.close();
		
	}

	public List<Client> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Client> list = session.createQuery("from Client").list();
        session.close();
        return list;
	}

}
