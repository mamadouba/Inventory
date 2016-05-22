package com.bantignel.inventory.services;

import java.util.List;

import com.bantignel.inventory.modeles.Ligne;

public interface ILigneService {
	public void create(Ligne Ligne);
	public Ligne findById(long id);
	public Ligne findByName(String name);
	public void update(Ligne Ligne);
	public void delete(long id);
	public List<Ligne> listAll();
}
