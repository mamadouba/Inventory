package com.bantignel.inventory.dao;

import java.util.List;

import com.bantignel.inventory.modeles.Fourniture;

public interface IFournitureDao {
	public void create(Fourniture fourniture);
	public Fourniture findById(long id);
	public Fourniture findByName(String name);
	public void update(Fourniture fourniture);
	public void delete(long id);
	public List<Fourniture> listAll();
}
