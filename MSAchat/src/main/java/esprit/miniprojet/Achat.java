package esprit.miniprojet;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Achat implements Serializable{
	private static final long serialVersionUID = 671145743755934805L;
	
	@Id
	@GeneratedValue
	private int id;
	private int idUser;
	private int idProduct;
	
	public int getId() {
		return id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Achat() {
		super();
	}
	
}
