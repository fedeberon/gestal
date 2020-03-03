package com.ideaas.api;

import com.ideaas.services.bean.FileStorageProperties;
import com.ideaas.services.domain.User;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = {"com.ideaas"})
@EnableConfigurationProperties({
        FileStorageProperties.class
})
@EnableScheduling
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	public CommandLineRunner demoData(UsuarioService usuarioService) {
		return args -> {
			String pass = bCryptPasswordEncoder.encode("fede");
			User user = new User("fede", pass, "fede@outlook.com");
			usuarioService.delete(user);
			usuarioService.save(user);
		};
	}
}
