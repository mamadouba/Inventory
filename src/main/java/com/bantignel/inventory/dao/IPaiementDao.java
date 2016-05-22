package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Paiement;

public interface IPaiementDao {
	public void create(Paiement paiement);
	public Paiement findById(long id);
	public Paiement findByName(String name);
	public void update(Paiement paiement);
	public void delete(long id);
	public List<Paiement> listAll();
}
