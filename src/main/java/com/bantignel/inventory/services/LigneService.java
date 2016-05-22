package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.ILigneDao;
import com.bantignel.inventory.modeles.Ligne;
@Service
@Transactional
public class LigneService implements ILigneService{
	
	@Autowired
	private ILigneDao dao;
	
	public ILigneDao getDao() {
		return dao;
	}

	public void setDao(ILigneDao dao) {
		this.dao = dao;
	}

	public void create(Ligne ligne) {
		dao.create(ligne);
	}

	public Ligne findById(long id) {
		return dao.findById(id);
	}

	public Ligne findByName(String name) {
		return dao.findByName(name);
	}

	public void update(Ligne ligne) {
		dao.update(ligne);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Ligne> listAll() {
		return dao.listAll();
	}

}
