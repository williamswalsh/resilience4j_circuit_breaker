package ie.williamswalsh.resilience4j_circuit_breaker.svc;

import ie.williamswalsh.resilience4j_circuit_breaker.web.BoredApiClient;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    BoredApiClient client;

    public ActivityService(BoredApiClient client) {
        this.client = client;
    }

    public String getActivity() {
        return client.getActivity();
    }
}
