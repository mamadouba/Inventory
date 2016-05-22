package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Fournisseur;

public interface IFournisseurDao {
	public void create(Fournisseur fournisseur);
	public Fournisseur findById(long id);
	public Fournisseur findByName(String name);
	public void update(Fournisseur fournisseur);
	public void delete(long id);
	public List<Fournisseur> listAll();
}
