package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.IClientDao;
import com.bantignel.inventory.modeles.Client;
@Service
@Transactional
public class ClientService implements IClientService{
	
	@Autowired
	private IClientDao dao;
	
	public IClientDao getDao() {
		return dao;
	}

	public void setDao(IClientDao dao) {
		this.dao = dao;
	}

	public void create(Client client) {
		dao.create(client);
	}

	public Client findById(long id) {
		return dao.findById(id);
	}

	public Client findByName(String name) {
		return dao.findByName(name);
	}

	public void update(Client client) {
		dao.update(client);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Client> listAll() {
		return dao.listAll();
	}

}
