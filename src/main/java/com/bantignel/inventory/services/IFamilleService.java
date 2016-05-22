package com.bantignel.inventory.services;

import java.util.List;

import com.bantignel.inventory.modeles.Famille;

public interface IFamilleService {
	public void create(Famille Famille);
	public Famille findById(long id);
	public Famille findByName(String name);
	public void update(Famille Famille);
	public void delete(long id);
	public List<Famille> listAll();
}
