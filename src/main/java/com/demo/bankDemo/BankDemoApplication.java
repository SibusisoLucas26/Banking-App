package com.demo.bankDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.bankDemo.Model.User;
import com.demo.bankDemo.Repo.UserRepository;

@SpringBootApplication
// @ComponentScan(basePackages = "com.demo")
public class BankDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankDemoApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;


	@Override
	public void run(String... args) throws Exception {

		User user1 = new User("sibusiso","pass",769,456000);
		userRepository.save(user1);

		

		

		// TODO Auto-generated method stub
		// throw new UnsupportedOperationException("Unimplemented method 'run'");
	}

}
