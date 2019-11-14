package esprit.miniprojet;


import java.io.Serializable;

import lombok.Data;

enum Category{
	Ventilateur,
	Processeur,
	Carte_Mere
}
enum Mark{
	Hp,
	Lenovo,
	Asus,
	Apple
}

@Data
public class Product implements Serializable {
	private static final long serialVersionUID = 6711457437559348052L;
	
	private int id;
	private String nom,reference;
	private Category category;
	private float prix;
	private Mark mark;
	
	public Mark getMark() {
		return mark;
	}
	public void setMark(Mark mark) {
		this.mark = mark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}

