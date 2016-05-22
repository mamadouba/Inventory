package com.bantignel.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bantignel.inventory.modeles.Agent;
@Repository
public class AgentDao implements IAgentDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void create(Agent agent) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(agent);
		tx.commit();
		session.close();
	}

	public Agent findById(long id) {
		Session session = sessionFactory.openSession();
		Agent agent = (Agent) session.get(Agent.class,id);
        session.close();
        return agent;
	}

	public Agent findByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<Agent> list = (ArrayList<Agent>) session.createQuery("from AGENT a where nom =:name").setParameter("name",name).list();
        session.close();
        return list.get(0);
	}

	public void update(Agent agent) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(agent);
		tx.commit();
        session.close();
		
	}

	public void delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Agent agent = (Agent) session.get(Agent.class,id);;
        session.delete(agent);
        tx.commit();
        session.close();
		
	}

	public List<Agent> listAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Agent> list = session.createQuery("from AGENT").list();
        session.close();
        return list;
	}

}
