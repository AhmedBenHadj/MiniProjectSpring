package esprit.miniprojet;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
@Entity
public class Product implements Serializable {
	@Override
	public String toString() {
		return "Product [id=" + id + ", nom=" + nom + ", reference=" + reference + ", category=" + category + ", prix="
				+ prix + ", mark=" + mark + "]";
	}
	private static final long serialVersionUID = 6711457437559348052L;
	
	public Product() {
		super();
	}
	@Id
	@GeneratedValue
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
