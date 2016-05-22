package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Rayon;

public interface IRayonDao {
	public void create(Rayon rayon);
	public Rayon findById(long id);
	public Rayon findByName(String name);
	public void update(Rayon rayon);
	public void delete(long id);
	public List<Rayon> listAll();
}
