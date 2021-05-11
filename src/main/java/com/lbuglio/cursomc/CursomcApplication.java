package com.lbuglio.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lbuglio.cursomc.domain.Category;
import com.lbuglio.cursomc.domain.City;
import com.lbuglio.cursomc.domain.Product;
import com.lbuglio.cursomc.domain.State;
import com.lbuglio.cursomc.repositories.CategoryRepository;
import com.lbuglio.cursomc.repositories.CityRepository;
import com.lbuglio.cursomc.repositories.ProductRepository;
import com.lbuglio.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "TI");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "PC", 200.00);
		Product p2 = new Product(null, "Printer", 80.00);
		Product p3 = new Product(null, "Mouse", 9.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State state1 = new State(null, "Minas Gerais");
		State state2 = new State(null, "Sao Paulo");
		
		City c1 = new City(null, "Pocos de Caldas", state1);
		City c2 = new City(null, "Sao Paulo", state2);
		City c3 = new City(null, "Campinas", state2);
		
		state1.getCities().addAll(Arrays.asList(c1));
		state2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}
}

