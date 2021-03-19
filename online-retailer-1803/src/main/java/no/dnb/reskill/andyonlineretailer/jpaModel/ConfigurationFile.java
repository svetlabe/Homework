package no.dnb.reskill.andyonlineretailer.jpaModel;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationFile {

    @Bean (name = "vatSpec")
    public VatBean myVatBean(){
        VatBean vatBean = new VatBean();
        return vatBean;
    }



    @Bean(name = "myServiceDB")
    public ProductService myProductService() {
        return new ProductService(myProductRepositoryDatabase(), myVatBean());
    }

    @Bean(name = "repositoryDB")
    public ProductRepositoryDatabase myProductRepositoryDatabase() {
        return new ProductRepositoryDatabase();
    }


}
