package com.bantignel.inventory.services;

import java.util.List;

import com.bantignel.inventory.modeles.Admin;

public interface IAdminService {
	public void create(Admin Admin);
	public Admin findById(long id);
	public Admin findByName(String name);
	public void update(Admin Admin);
	public void delete(long id);
	public List<Admin> listAll();
}
