package ch.bfh.autumn.promoter.client.impl;

import ch.bfh.autumn.promoter.client.ArenaClient;
import ch.bfh.autumn.promoter.model.Party;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DefaultArenaClient implements ArenaClient {

    @Override
    public String battle(List<Party> challengers) {
        ResponseEntity<String> response =  new RestTemplate().exchange(
                "http://localhost:8081/battle",
                HttpMethod.POST,
                new HttpEntity<>(challengers),
                String.class);
        return response.getBody();
    }
}
