package esprit.miniprojet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RestAPI {

	private final ProductClient productClient;
	
	public RestAPI(ProductClient productClient) {
		this.productClient = productClient;
	}
	
	public Collection<Product> fallback(){
		return new ArrayList<>();
	}
	
	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping("/Hp-Mark")
	public Collection<Product> hpMarkProducts(){
		return productClient.readProducts()
				.getContent()
				.stream()
				.filter(this::isHp)
				.collect(Collectors.toList());
	}
	
	private boolean isHp(Product product) {
		if(product.getMark().equals(Mark.Hp))
			return true;
		return false;
	}
}
