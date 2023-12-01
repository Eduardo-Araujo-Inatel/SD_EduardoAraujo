package br.c216.labs;

import br.c216.labs.model.dto.ProdutoDTO;
import java.util.ArrayList;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class WebClientGetFlux {
	
  public static void main(String[] args) {
    ArrayList<ProdutoDTO> listaProduto = new ArrayList<ProdutoDTO>();

    Flux<ProdutoDTO> fluxProduto = WebClient
      .create(Constants.BASE_URL)
      .get()
      .uri("/produto")
      .retrieve()
      .bodyToFlux(ProdutoDTO.class);

    fluxProduto.subscribe(p -> listaProduto.add(p));

    fluxProduto.blockLast();

    System.out.println("Lista de produtos:");
    System.out.println(listaProduto);
  }
}
