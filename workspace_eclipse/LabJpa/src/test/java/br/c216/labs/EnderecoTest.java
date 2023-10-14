package br.c216.labs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.c216.labs.entity.Endereco;
import br.c216.labs.service.EnderecoService;

@SpringBootTest
public class EnderecoTest {

	@Autowired
	private EnderecoService service;

	@Test
	public void testarUUIDGeradoPeloJPAListener() {

		Endereco e = new Endereco();
		e.setRua("Av. Teste123");
		e.setNumero("123");
		e.setCidade("Cidade dos Testes");
		e.setUf("TS");

		e = service.salvar(e);

		System.out.println(e);
	}

}
