package esprit.miniprojet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsAchatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAchatApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
	   return new RestTemplate();
	}
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

}
