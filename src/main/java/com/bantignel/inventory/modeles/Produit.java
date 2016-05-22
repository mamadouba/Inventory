package com.bantignel.inventory.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="PRODUIT")
public class Produit {
	@TableGenerator(name = "PRD", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", initialValue=5000)
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "PRD")
	private long idProduit;
	private String reference;
	private double prixUnitaire;
	private int quantiteEnStock;
	private int quantiteAlerte;
	@OneToOne
	private Rayon rayon;
	@OneToOne
	private Famille famille;
	public Produit() {
	}
	public Produit(String reference,double prixUnitaire, int quantiteEnStock, int quantiteAlerte) {
		this.reference = reference;
		this.prixUnitaire = prixUnitaire;
		this.quantiteEnStock = quantiteEnStock;
		this.quantiteAlerte = quantiteAlerte;
	}
	public long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public String getDesignation() {
		return reference;
	}
	public void setDesignation(String reference) {
		this.reference = reference;
	}
	public int getQuantiteEnStock() {
		return quantiteEnStock;
	}
	public void setQuantiteEnStock(int quantiteEnStock) {
		this.quantiteEnStock = quantiteEnStock;
	}
	public int getQuantiteAlerte() {
		return quantiteAlerte;
	}
	public void setQuantiteAlerte(int quantiteAlerte) {
		this.quantiteAlerte = quantiteAlerte;
	}
	public Rayon getRayon() {
		return rayon;
	}
	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}
	public Famille getFamille() {
		return famille;
	}
	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	
	
	
	
}
