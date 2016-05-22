package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.IFamilleDao;
import com.bantignel.inventory.modeles.Famille;
@Service
@Transactional 
public class FamilleService implements IFamilleService{
	
	@Autowired
	private IFamilleDao dao;
	
	public IFamilleDao getDao() {
		return dao;
	}

	public void setDao(IFamilleDao dao) {
		this.dao = dao;
	}

	public void create(Famille famille) {
		dao.create(famille);
	}

	public Famille findById(long id) {
		return dao.findById(id);
	}

	public Famille findByName(String name) {
		return dao.findByName(name);
	}

	public void update(Famille famille) {
		dao.update(famille);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Famille> listAll() {
		return dao.listAll();
	}

}
