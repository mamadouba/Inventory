package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Produit;

public interface IProduitDao {
	public void create(Produit produit);
	public Produit findById(long id);
	public Produit findByName(String name);
	public void update(Produit produit);
	public void delete(long id);
	public List<Produit> listAll();
}
