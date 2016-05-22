package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.IPaiementDao;
import com.bantignel.inventory.modeles.Paiement;
@Service
@Transactional
public class PaiementService implements IPaiementService{
	
	@Autowired
	private IPaiementDao dao;
	
	public IPaiementDao getDao() {
		return dao;
	}

	public void setDao(IPaiementDao dao) {
		this.dao = dao;
	}

	public void create(Paiement paiement) {
		dao.create(paiement);
	}

	public Paiement findById(long id) {
		return dao.findById(id);
	}

	public Paiement findByName(String name) {
		return dao.findByName(name);
	}

	public void update(Paiement paiement) {
		dao.update(paiement);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Paiement> listAll() {
		return dao.listAll();
	}

}
