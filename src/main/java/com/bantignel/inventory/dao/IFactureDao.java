package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Facture;

public interface IFactureDao {
	public void create(Facture facture);
	public Facture findById(long id);
	public Facture findByName(String name);
	public void update(Facture facture);
	public void delete(long id);
	public List<Facture> listAll();
}
