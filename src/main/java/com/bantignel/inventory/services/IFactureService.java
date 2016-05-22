package com.bantignel.inventory.services;

import java.util.List;

import com.bantignel.inventory.modeles.Facture;

public interface IFactureService {
	public void create(Facture Facture);
	public Facture findById(long id);
	public Facture findByName(String name);
	public void update(Facture Facture);
	public void delete(long id);
	public List<Facture> listAll();
}
