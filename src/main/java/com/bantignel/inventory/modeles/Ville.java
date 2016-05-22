package com.bantignel.inventory.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="VILLE")
public class Ville {
	@TableGenerator(name = "VIL", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", initialValue=6200)
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "VIL")
	private long idVille;
	private String nom;
	private long boitePostale;
	public Ville() {
	}
	public Ville(String nom, long boitePostale) {
		super();
		this.nom = nom;
		this.boitePostale = boitePostale;
	}
	public long getIdVille() {
		return idVille;
	}
	public void setIdVille(long idVille) {
		this.idVille = idVille;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public long getBoitePostale() {
		return boitePostale;
	}
	public void setBoitePostale(long boitePostale) {
		this.boitePostale = boitePostale;
	}
	
}
