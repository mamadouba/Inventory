package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Client;

public interface IClientDao {
	public void create(Client client);
	public Client findById(long id);
	public Client findByName(String name);
	public void update(Client client);
	public void delete(long id);
	public List<Client> listAll();
}
