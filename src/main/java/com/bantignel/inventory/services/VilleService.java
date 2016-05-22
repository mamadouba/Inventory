package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.IVilleDao;
import com.bantignel.inventory.modeles.Ville;
@Service
@Transactional
public class VilleService implements IVilleService{
	
	@Autowired
	private IVilleDao dao;
	
	public IVilleDao getDao() {
		return dao;
	}

	public void setDao(IVilleDao dao) {
		this.dao = dao;
	}

	public void create(Ville ville) {
		dao.create(ville);
	}

	public Ville findById(long id) {
		return dao.findById(id);
	}

	public Ville findByName(String name) {
		return dao.findByName(name);
	}

	public void update(Ville ville) {
		dao.update(ville);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Ville> listAll() {
		return dao.listAll();
	}

}
