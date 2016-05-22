package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.IFournisseurDao;
import com.bantignel.inventory.modeles.Fournisseur;
@Service
@Transactional
public class FournisseurService implements IFournisseurService{
	
	@Autowired
	private IFournisseurDao dao;
	
	public IFournisseurDao getDao() {
		return dao;
	}

	public void setDao(IFournisseurDao dao) {
		this.dao = dao;
	}

	public void create(Fournisseur fournisseur) {
		dao.create(fournisseur);
	}

	public Fournisseur findById(long id) {
		return dao.findById(id);
	}

	public Fournisseur findByName(String name) {
		return dao.findByName(name);
	}

	public void update(Fournisseur fournisseur) {
		dao.update(fournisseur);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Fournisseur> listAll() {
		return dao.listAll();
	}

}
