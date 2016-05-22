package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.IRayonDao;
import com.bantignel.inventory.modeles.Rayon;
@Service
@Transactional
public class RayonService implements IRayonService{
	
	@Autowired
	private IRayonDao dao;
	
	public IRayonDao getDao() {
		return dao;
	}

	public void setDao(IRayonDao dao) {
		this.dao = dao;
	}

	public void create(Rayon rayon) {
		dao.create(rayon);
	}

	public Rayon findById(long id) {
		return dao.findById(id);
	}

	public Rayon findByName(String name) {
		return dao.findByName(name);
	}

	public void update(Rayon rayon) {
		dao.update(rayon);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Rayon> listAll() {
		return dao.listAll();
	}

}
