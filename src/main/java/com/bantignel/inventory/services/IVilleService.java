package com.bantignel.inventory.services;

import java.util.List;

import com.bantignel.inventory.modeles.Ville;

public interface IVilleService {
	public void create(Ville Ville);
	public Ville findById(long id);
	public Ville findByName(String name);
	public void update(Ville Ville);
	public void delete(long id);
	public List<Ville> listAll();
}
