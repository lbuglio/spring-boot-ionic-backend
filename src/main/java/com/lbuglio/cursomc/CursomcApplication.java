package com.lbuglio.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lbuglio.cursomc.domain.Category;
import com.lbuglio.cursomc.repositories.CategoryRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "TI");
		Category cat2 = new Category(null, "Office");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
	}
}
