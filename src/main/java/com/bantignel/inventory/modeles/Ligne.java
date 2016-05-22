package com.bantignel.inventory.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="LIGNE")
public class Ligne {
	@TableGenerator(name = "LIG", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", initialValue=3200)
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "LIG")
	private long idLigne;
	private int quantite;
	@OneToOne
	private Commande commande;
	@OneToOne
	private Facture facture;
	@OneToOne
	private Fourniture fourniture;
	@OneToOne
	private Produit produit;
	
	public Ligne() {
	}

	public Ligne(int quantite) {
		this.quantite = quantite;
	}

	public long getIdLigne() {
		return idLigne;
	}

	public void setIdLigne(long idLigne) {
		this.idLigne = idLigne;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Fourniture getFourniture() {
		return fourniture;
	}

	public void setFourniture(Fourniture fourniture) {
		this.fourniture = fourniture;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	
}
