package fr.greta91.coursSpring.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {
	private int id;
	
	@NotNull
    @Size(min = 13, max = 13)
	private String isbn;
	
	@NotBlank(message = "Nom ne peut pas être vide !")
	@NotNull(message = "Nom ne peut pas être vide !")
	private String nom;
	
	@NotBlank(message = "Designation ne peut pas être vide !")
	@NotNull(message = "Designation ne peut pas être vide !")
	private String designation;
	
	@Min(value = 0, message = "Prix Hors-Taxes doit être supérieur ou égal à 0")
	private double prixHT;
	
	@Min(value = 0, message = "Stock doit être supérieur ou égal à 0")
	private int stock;
	
	@NotBlank(message = "Categorie ne peut pas être vide !")
	@NotNull(message = "Categorie ne peut pas être vide !")
	private String categorie;

	public Product() {
	}
	
	public Product(
			String isbn,
			String nom,
			String designation,
			double prixHT,
			int stock,
			String categorie) {
		this.isbn = isbn;
		this.nom = nom;
		this.designation = designation;
		this.prixHT = prixHT;
		this.stock = stock;
		this.categorie = categorie;
	}
	
	public Product(int id, 
			String isbn,
			String nom,
			String designation,
			double prixHT,
			int stock,
			String categorie) {
		this.id = id;
		this.isbn = isbn;
		this.nom = nom;
		this.designation = designation;
		this.prixHT = prixHT;
		this.stock = stock;
		this.categorie = categorie;
	}

	public boolean validate() {
		boolean isValid = true;
		
		if(this.isbn.trim().isEmpty() || this.isbn.length() != 13) {
			isValid = false;
		}
		if(this.nom.trim().isEmpty()) {
			isValid = false;
		}
		if(this.designation.trim().isEmpty()) {
			isValid = false;
		}
		if(this.prixHT<=0) {
			isValid = false;
		}
		if(this.stock <=0) {
			isValid = false;
		}
		if(this.categorie.trim().isEmpty()) {
			isValid = false;
		}
		
		return isValid;
	}
	
	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getIsbn() {
		return isbn;
	}

	public final void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public final String getNom() {
		return nom;
	}

	public final void setNom(String nom) {
		this.nom = nom;
	}

	public final String getDesignation() {
		return designation;
	}

	public final void setDesignation(String designation) {
		this.designation = designation;
	}

	public final double getPrixHT() {
		return prixHT;
	}

	public final void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public final int getStock() {
		return stock;
	}

	public final void setStock(int stock) {
		this.stock = stock;
	}

	public final String getCategorie() {
		return categorie;
	}

	public final void setCategorie(String categorie) {
		this.categorie = categorie;
	}
}
