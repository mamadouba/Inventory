package com.bantignel.inventory.services;

import java.util.List;

import com.bantignel.inventory.modeles.Rayon;

public interface IRayonService {
	public void create(Rayon Rayon);
	public Rayon findById(long id);
	public Rayon findByName(String name);
	public void update(Rayon Rayon);
	public void delete(long id);
	public List<Rayon> listAll();
}
