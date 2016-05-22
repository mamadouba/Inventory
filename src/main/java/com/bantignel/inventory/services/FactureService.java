package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.IFactureDao;
import com.bantignel.inventory.modeles.Facture;
@Service
@Transactional
public class FactureService implements IFactureService{
	
	@Autowired
	private IFactureDao dao;
	
	public IFactureDao getDao() {
		return dao;
	}

	public void setDao(IFactureDao dao) {
		this.dao = dao;
	}

	public void create(Facture facture) {
		dao.create(facture);
	}

	public Facture findById(long id) {
		return dao.findById(id);
	}

	public Facture findByName(String name) {
		return dao.findByName(name);
	}

	public void update(Facture facture) {
		dao.update(facture);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Facture> listAll() {
		return dao.listAll();
	}

}
