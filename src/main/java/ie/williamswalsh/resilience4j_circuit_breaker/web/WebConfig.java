package ie.williamswalsh.resilience4j_circuit_breaker.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

    @Bean
    RestTemplate RestTemplate() {
        return new RestTemplate();
    }


    @Bean
    BoredApiClient BoredApiClient(RestTemplate restTemplate) {
        return new BoredApiClient(restTemplate);
    }
}
