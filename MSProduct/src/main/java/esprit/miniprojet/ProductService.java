package esprit.miniprojet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Product AddProduct(Product product){
		return productRepository.save(product);
	}
	
	public Product UpdateProduct(int id,Product newProduct) {
		if(productRepository.findById(id).isPresent()) {
			Product existingProduct = productRepository.findById(id).get();
			existingProduct.setCategory(newProduct.getCategory());
			existingProduct.setNom(newProduct.getNom());
			existingProduct.setPrix(newProduct.getPrix());
			existingProduct.setReference(newProduct.getReference());
			existingProduct.setMark(newProduct.getMark());
			
			return productRepository.save(existingProduct);
		}else {
			return null;
		}
	}
	
	public String DeleteProduct(int id) {
		if (productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
			return "Product deleted";
		} else
			return "Product not deleted, something went wrong...";
	}
}
