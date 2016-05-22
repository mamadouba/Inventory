package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Ville;

public interface IVilleDao {
	public void create(Ville Ville);
	public Ville findById(long id);
	public Ville findByName(String name);
	public void update(Ville Ville);
	public void delete(long id);
	public List<Ville> listAll();
}
