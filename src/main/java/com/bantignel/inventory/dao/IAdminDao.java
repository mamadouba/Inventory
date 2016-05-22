package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Admin;

public interface IAdminDao {
	public void create(Admin admin);
	public Admin findById(long id);
	public Admin findByName(String name);
	public void update(Admin admin);
	public void delete(long id);
	public List<Admin> listAll();
}
