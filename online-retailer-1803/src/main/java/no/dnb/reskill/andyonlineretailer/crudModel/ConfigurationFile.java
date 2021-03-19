package no.dnb.reskill.andyonlineretailer.crudModel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationFile {

    @Bean (name = "vatSpec")
    public VatBean myVatBean(){
        VatBean vatBean = new VatBean();
        return vatBean;
    }



}
