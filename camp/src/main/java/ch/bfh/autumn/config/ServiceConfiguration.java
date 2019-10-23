package ch.bfh.autumn.config;

import ch.bfh.autumn.service.HeroService;
import ch.bfh.autumn.service.PartyService;
import ch.bfh.autumn.service.impl.DefaultHeroService;
import ch.bfh.autumn.service.impl.DefaultPartyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public HeroService heroService() {
        return new DefaultHeroService();
    }

    @Bean
    public PartyService partyService() {
        return new DefaultPartyService();
    }
}