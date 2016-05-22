package com.bantignel.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.inventory.dao.IAdminDao;
import com.bantignel.inventory.modeles.Admin;
@Service
@Transactional
public class AdminService implements IAdminService{
	
	@Autowired
	private IAdminDao dao;
	
	public IAdminDao getDao() {
		return dao;
	}

	public void setDao(IAdminDao dao) {
		this.dao = dao;
	}

	public void create(Admin admin) {
		dao.create(admin);
	}

	public Admin findById(long id) {
		return dao.findById(id);
	}

	public Admin findByName(String name) {
		return dao.findByName(name);
	}

	public void update(Admin admin) {
		dao.update(admin);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public List<Admin> listAll() {
		return dao.listAll();
	}

}
