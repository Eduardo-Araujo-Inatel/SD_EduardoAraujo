package br.c216.labs.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.c216.labs.dto.TotalCompradoPorFornecedorDTO;

@SpringBootTest
public class RelatorioServiceTest {

	@Autowired
	private RelatorioService service;

	@Test
	void test() {
		List<TotalCompradoPorFornecedorDTO> listaDTO = service.pesquisarTotalCompradoPorFornecedor();

		assertFalse(listaDTO.isEmpty());

		System.out.println("FornecedorRazaoSocial : TotalComprada");
		listaDTO.forEach(r -> {
			System.out.print(r.fornecedorRazaoSocial());
			System.out.print(" : ");
			System.out.println(r.totalComprado());
		});
	}
}
