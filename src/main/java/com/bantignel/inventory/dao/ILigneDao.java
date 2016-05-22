package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Ligne;

public interface ILigneDao {
	public void create(Ligne ligne);
	public Ligne findById(long id);
	public Ligne findByName(String name);
	public void update(Ligne ligne);
	public void delete(long id);
	public List<Ligne> listAll();
}
