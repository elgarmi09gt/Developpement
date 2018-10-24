package sn.ucad.master2.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {
		private String reference,  designation;
		private double prix; 
		private int quantite;
		public Produit(){
			
		}
		
		public Produit(String reference, String designation, double prix,
				int quantite) {
			super();
			this.reference = reference;
			this.designation = designation;
			this.prix = prix;
			this.quantite = quantite;
		}
		
		@Id
		@Column(name = "REF_PROD", nullable= false, length = 10)
		public String getReference() {
			return reference;
		}
		public void setReference(String reference) {
			this.reference = reference;
		}
		
		@Column(name = "DESIGNATION")
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		@Column(name = "PRIX")
		public double getPrix() {
			return prix;
		}
		public void setPrix(double prix) {
			this.prix = prix;
		}
		@Column(name = "QUANTITE")
		public int getQuantite() {
			return quantite;
		}
		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}
		
		

}
