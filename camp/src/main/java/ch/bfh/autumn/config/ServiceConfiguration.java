package ch.bfh.autumn.config;

import ch.bfh.autumn.service.HeroService;
import ch.bfh.autumn.service.PartyService;
import ch.bfh.autumn.service.impl.DefaultHeroService;
import ch.bfh.autumn.service.impl.DefaultPartyService;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
//@EnableJpaRepositories(basePackages = "ch.bfh.autumn.repository")
@EnableMongoRepositories(basePackages = "ch.bfh.autumn.repository")
public class ServiceConfiguration {

    @Bean
    public HeroService heroService() {
        return new DefaultHeroService();
    }

    @Bean
    public PartyService partyService() {
        return new DefaultPartyService();
    }

    /*@Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2).build();
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setDatabase(Database.H2);
        bean.setGenerateDdl(true);
        return bean;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
        DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean bean =
            new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setJpaVendorAdapter(jpaVendorAdapter);
        bean.setPackagesToScan("ch.bfh.autumn.model");
        return bean;
    }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }*/

    @Bean
    @DependsOn("mongo")
    public MongoClient mongoClient() {
        return new MongoClient("localhost");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "heroes");
    }

    @Bean(destroyMethod="close")
    public Mongo mongo() throws IOException {
        return new EmbeddedMongoBuilder()
            .version("3.4.17") //Even when no version is specified (PRODUCTION version) the embedded database doesn't shut down gracefully
            .bindIp("localhost")
            .port(27017)
            .build();
    }
}