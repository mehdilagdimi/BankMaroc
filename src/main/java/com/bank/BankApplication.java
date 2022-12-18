package com.bank;

import com.bank.model.Agent;
import com.bank.model.Client;
import com.bank.model.UserRole;
import com.bank.service.AgentService;
import com.bank.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return  new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(AgentService agentService, ClientService clientService){
		return args -> {
			//	agentService.saveAgent(new Agent("agent", "agent@gmail.com", "12345678", UserRole.AGENT));
			//	clientService.saveClient(new Client("client", "client@gmail.com", "12345678", UserRole.CLIENT, "AA123456", "012344544"));
			//	clientService.saveClient(new Client("Newclient", "newclient2@gmail.com", "12345678", UserRole.CLIENT, "ED123456", "0332211488"));
		};
	}

}
