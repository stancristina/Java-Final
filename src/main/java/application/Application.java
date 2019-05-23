package application;

import application.model.Company;
import application.repository.impl.CompanyRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


   /* public static void main(String[] args) {
        //CompanyRepositoryImpl companyRepository = new CompanyRepositoryImpl();
        //Company company = new Company();
        //company.setName("Adobe");
        //company.setAddress("Lujerului");
        //companyRepository.save(company);

    }
}
*/