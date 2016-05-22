package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.IAgentDao;
import com.bantignel.inventory.modeles.Agent;
@Service
@Transactional
public class AgentService implements IAgentService{
	
	@Autowired
	private IAgentDao dao;
	
	public IAgentDao getDao() {
		return dao;
	}

	public void setDao(IAgentDao dao) {
		this.dao = dao;
	}

	public void create(Agent agent) {
		dao.create(agent);
	}

	public Agent findById(long id) {
		return dao.findById(id);
	}

	public Agent findByName(String name) {
		return dao.findByName(name);
	}

	public void update(Agent agent) {
		dao.update(agent);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Agent> listAll() {
		return dao.listAll();
	}

}
