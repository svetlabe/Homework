package no.dnb.reskill.andyonlineretailer.jpaModel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        ProductService service = ctx.getBean("myServiceDB", ProductService.class);
        service.doService();


    }

}
