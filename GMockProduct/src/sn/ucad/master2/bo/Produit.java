package sn.ucad.master2.bo;

import java.io.Serializable;

public class Produit implements Serializable{
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
		public String getReference() {
			return reference;
		}
		public void setReference(String reference) {
			this.reference = reference;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public double getPrix() {
			return prix;
		}
		public void setPrix(double prix) {
			this.prix = prix;
		}
		public int getQuantite() {
			return quantite;
		}
		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((designation == null) ? 0 : designation.hashCode());
			long temp;
			temp = Double.doubleToLongBits(prix);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + quantite;
			result = prime * result
					+ ((reference == null) ? 0 : reference.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Produit other = (Produit) obj;
			if (designation == null) {
				if (other.designation != null)
					return false;
			} else if (!designation.equals(other.designation))
				return false;
			if (Double.doubleToLongBits(prix) != Double
					.doubleToLongBits(other.prix))
				return false;
			if (quantite != other.quantite)
				return false;
			if (reference == null) {
				if (other.reference != null)
					return false;
			} else if (!reference.equals(other.reference))
				return false;
			return true;
		}
		
		

}
