package com.bantignel.inventory.services;

import java.util.List;

import com.bantignel.inventory.modeles.Client;

public interface IClientService {
	public void create(Client Client);
	public Client findById(long id);
	public Client findByName(String name);
	public void update(Client Client);
	public void delete(long id);
	public List<Client> listAll();
}
