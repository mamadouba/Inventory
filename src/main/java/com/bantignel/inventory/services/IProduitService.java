package com.bantignel.inventory.services;

import java.util.List;

import com.bantignel.inventory.modeles.Produit;

public interface IProduitService {
	public void create(Produit Produit);
	public Produit findById(long id);
	public Produit findByName(String name);
	public void update(Produit Produit);
	public void delete(long id);
	public List<Produit> listAll();
}
