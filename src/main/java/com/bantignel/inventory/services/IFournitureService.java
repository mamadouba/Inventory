package com.bantignel.inventory.services;

import java.util.List;

import com.bantignel.inventory.modeles.Fourniture;

public interface IFournitureService {
	public void create(Fourniture Fourniture);
	public Fourniture findById(long id);
	public Fourniture findByName(String name);
	public void update(Fourniture Fourniture);
	public void delete(long id);
	public List<Fourniture> listAll();
}
