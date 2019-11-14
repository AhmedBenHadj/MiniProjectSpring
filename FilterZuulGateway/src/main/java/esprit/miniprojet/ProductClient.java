package esprit.miniprojet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.hateoas.Resources;

@FeignClient("product-service")
public interface ProductClient {
	
	@GetMapping("/products")
	public Resources<Product> readProducts();
}
