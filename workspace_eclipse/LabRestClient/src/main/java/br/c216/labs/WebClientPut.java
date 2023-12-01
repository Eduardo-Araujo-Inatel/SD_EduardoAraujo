package br.c216.labs;

import br.c216.labs.model.dto.ProdutoDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientPut {

  public static void main(String[] args) {
    ProdutoDTO produtoExistente = new ProdutoDTO();
    produtoExistente.setId(1L);
    produtoExistente.setDescricao("Furadeira a bateria");

    ResponseEntity<Void> responseEntity = WebClient
      .create(Constants.BASE_URL)
      .put()
      .uri("/produto")
      .bodyValue(produtoExistente)
      .retrieve()
      .toBodilessEntity()
      .block();

    HttpStatusCode statusCode = responseEntity.getStatusCode();

    System.out.println("Produto atualizado:");
    System.out.println("Status da resposta: " + statusCode);
  }
}
