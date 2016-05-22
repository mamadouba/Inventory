package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Famille;

public interface IFamilleDao {
	public void create(Famille famille);
	public Famille findById(long id);
	public Famille findByName(String name);
	public void update(Famille famille);
	public void delete(long id);
	public List<Famille> listAll();
}
