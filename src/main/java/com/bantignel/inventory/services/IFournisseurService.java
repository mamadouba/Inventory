package com.bantignel.inventory.services;

import java.util.List;

import com.bantignel.inventory.modeles.Fournisseur;

public interface IFournisseurService {
	public void create(Fournisseur Fournisseur);
	public Fournisseur findById(long id);
	public Fournisseur findByName(String name);
	public void update(Fournisseur Fournisseur);
	public void delete(long id);
	public List<Fournisseur> listAll();
}
