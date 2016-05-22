package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.IFournitureDao;
import com.bantignel.inventory.modeles.Fourniture;
@Service
@Transactional
public class FournitureService implements IFournitureService{
	
	@Autowired
	private IFournitureDao dao;
	
	public IFournitureDao getDao() {
		return dao;
	}

	public void setDao(IFournitureDao dao) {
		this.dao = dao;
	}

	public void create(Fourniture fourniture) {
		dao.create(fourniture);
	}

	public Fourniture findById(long id) {
		return dao.findById(id);
	}

	public Fourniture findByName(String name) {
		return dao.findByName(name);
	}

	public void update(Fourniture fourniture) {
		dao.update(fourniture);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Fourniture> listAll() {
		return dao.listAll();
	}

}
