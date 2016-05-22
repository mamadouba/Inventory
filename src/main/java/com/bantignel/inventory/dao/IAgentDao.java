package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Agent;

public interface IAgentDao {
	public void create(Agent agent);
	public Agent findById(long id);
	public Agent findByName(String name);
	public void update(Agent agent);
	public void delete(long id);
	public List<Agent> listAll();
}
