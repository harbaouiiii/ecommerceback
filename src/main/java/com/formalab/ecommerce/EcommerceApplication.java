package com.formalab.ecommerce;

import com.formalab.ecommerce.dao.RoleRepository;
import com.formalab.ecommerce.model.Role;
import com.formalab.ecommerce.model.RoleName;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EcommerceApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(EcommerceApplication.class, args);

		/*RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);

		roleRepository.save(new Role(RoleName.ROLE_ADMIN));
		roleRepository.save(new Role(RoleName.ROLE_PM));
		roleRepository.save(new Role(RoleName.ROLE_USER));*/

	}

}
