package br.c216.labs;

import br.c216.labs.model.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

public class WebClientGetMonoById {

  public static void main(String[] args) {
    try {
      Mono<ProdutoDTO> monoProduto = WebClient
        .create(Constants.BASE_URL)
        .get()
        .uri("/produto/1")
        .retrieve()
        .bodyToMono(ProdutoDTO.class);

      monoProduto.subscribe();

      ProdutoDTO produtoRetornado = monoProduto.block();

      System.out.println("Produto encontrado");
      System.out.println(produtoRetornado);
    } catch (WebClientResponseException e) {
      System.out.println("Status code: " + e.getStatusCode());
      System.out.println("Message: " + e.getMessage());
    }
  }
}
