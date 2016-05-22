package com.bantignel.inventory.services;

import java.util.List;

import com.bantignel.inventory.modeles.Commande;

public interface ICommandeService {
	public void create(Commande Commande);
	public Commande findById(long id);
	public Commande findByName(String name);
	public void update(Commande Commande);
	public void delete(long id);
	public List<Commande> listAll();
}
