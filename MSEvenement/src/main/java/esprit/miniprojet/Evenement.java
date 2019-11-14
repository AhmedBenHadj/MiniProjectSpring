package esprit.miniprojet;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Evenement implements Serializable {
	private static final long serialVersionUID = 6711457437559348054L;
	
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private int duration;
	
	public Evenement() {
		super();
	}
	
	@Override
	public String toString() {
		return "Evenement [id=" + id + ", nom=" + nom + ", duration=" + duration + "]";
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
