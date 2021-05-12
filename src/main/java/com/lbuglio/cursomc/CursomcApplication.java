package com.lbuglio.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lbuglio.cursomc.domain.Categoria;
import com.lbuglio.cursomc.domain.Cidade;
import com.lbuglio.cursomc.domain.Cliente;
import com.lbuglio.cursomc.domain.Endereco;
import com.lbuglio.cursomc.domain.Estado;
import com.lbuglio.cursomc.domain.Produto;
import com.lbuglio.cursomc.domain.enums.TipoCliente;
import com.lbuglio.cursomc.repositories.CategoriaRepository;
import com.lbuglio.cursomc.repositories.CidadeRepository;
import com.lbuglio.cursomc.repositories.ClienteRepository;
import com.lbuglio.cursomc.repositories.EnderecoRepository;
import com.lbuglio.cursomc.repositories.EstadoRepository;
import com.lbuglio.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoryRepository;
	@Autowired
	private ProdutoRepository productRepository;
	@Autowired
	private EstadoRepository stateRepository;
	@Autowired
	private CidadeRepository cityRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "TI");
		Categoria cat2 = new Categoria(null, "Office");
		
		Produto p1 = new Produto(null, "PC", 200.00);
		Produto p2 = new Produto(null, "Printer", 80.00);
		Produto p3 = new Produto(null, "Mouse", 9.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Lucas", "lucas@gmail.com", "83827873800", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27364323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}
}

