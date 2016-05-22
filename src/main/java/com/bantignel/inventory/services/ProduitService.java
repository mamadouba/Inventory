package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.IProduitDao;
import com.bantignel.inventory.modeles.Produit;
@Service
@Transactional
public class ProduitService implements IProduitService{
	
	@Autowired
	private IProduitDao dao;
	
	public IProduitDao getDao() {
		return dao;
	}

	public void setDao(IProduitDao dao) {
		this.dao = dao;
	}

	public void create(Produit produit) {
		dao.create(produit);
	}

	public Produit findById(long id) {
		return dao.findById(id);
	}

	public Produit findByName(String name) {
		return dao.findByName(name);
	}

	public void update(Produit produit) {
		dao.update(produit);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Produit> listAll() {
		return dao.listAll();
	}

}
