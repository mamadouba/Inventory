package com.bantignel.inventory.services;

import java.util.List;

import com.bantignel.inventory.modeles.Paiement;

public interface IPaiementService {
	public void create(Paiement Paiement);
	public Paiement findById(long id);
	public Paiement findByName(String name);
	public void update(Paiement Paiement);
	public void delete(long id);
	public List<Paiement> listAll();
}
