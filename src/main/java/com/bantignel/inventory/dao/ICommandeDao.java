package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Commande;

public interface ICommandeDao {
	public void create(Commande commande);
	public Commande findById(long id);
	public Commande findByName(String name);
	public void update(Commande commande);
	public void delete(long id);
	public List<Commande> listAll();
}
