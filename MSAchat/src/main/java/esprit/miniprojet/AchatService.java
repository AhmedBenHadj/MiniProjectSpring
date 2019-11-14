package esprit.miniprojet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AchatService {
	@Autowired
	private AchatRepository achatRepository;
	 
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	public Achat AddAchat(int idUser,int idProduct) {
		if(idUser !=0 && idProduct !=0) {
			//Product existingProduct = restTemplate.getForObject("http://localhost:8082/products/" + achat.getProduct().getId(), Product.class);
			//User existingUser = restTemplate.getForObject("http://localhost:8081/users/" + achat.getUser().getId(), User.class);
			Product existingProduct = webClientBuilder.build()
					.get()
					.uri("http://localhost:8082/products/" + idUser)
					.retrieve()
					.bodyToMono(Product.class)
					.block();
			User existingUser = webClientBuilder.build()
					.get()
					.uri("http://localhost:8081/users/" + idProduct)
					.retrieve()
					.bodyToMono(User.class)
					.block();
			if(existingProduct != null && existingUser != null) {
				Achat achat = new Achat();
				achat.setIdProduct(idProduct);
				achat.setIdUser(idUser);
				return achatRepository.save(achat);
			}
		}
		return null;
	}
}
