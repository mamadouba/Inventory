package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.ICommandeDao;
import com.bantignel.inventory.modeles.Commande;
@Service
@Transactional
public class CommandeService implements ICommandeService{
	
	@Autowired
	private ICommandeDao dao;
	
	public ICommandeDao getDao() {
		return dao;
	}

	public void setDao(ICommandeDao dao) {
		this.dao = dao;
	}

	public void create(Commande commande) {
		dao.create(commande);
	}

	public Commande findById(long id) {
		return dao.findById(id);
	}

	public Commande findByName(String reference) {
		return dao.findByName(reference);
	}

	public void update(Commande commande) {
		dao.update(commande);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Commande> listAll() {
		return dao.listAll();
	}

}
