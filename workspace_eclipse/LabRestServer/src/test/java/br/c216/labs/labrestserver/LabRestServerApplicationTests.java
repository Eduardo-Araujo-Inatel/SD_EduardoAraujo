package br.c216.labs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LabRestServerApplicationTests {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void deveListarProdutos() {
    webTestClient
      .get()
      .uri("/produto")
      .exchange()
      .expectStatus()
      .isOk()
      .expectBody()
      .returnResult();
  }

  @Test
  void dadoProdutoIdValido_quandoGetProdutoPeloId_entaoRespondeComProdutoValido() {
    Long produtoIdValido = 1L;

    Produto produtoRespondido = webTestClient
      .get()
      .uri("/produto/" + produtoIdValido)
      .exchange()
      .expectStatus()
      .isOk()
      .expectBody(Produto.class)
      .returnResult()
      .getResponseBody();

    assertNotNull(produtoRespondido);
    assertEquals(produtoRespondido.getId(), produtoIdValido);
  }

  @Test
  void dadoProdutoIdValido_quandoGetProdutoPeloId_entaoRespondeComStatusNotFound() {
    Long idInvalido = 99L;

    webTestClient
      .get()
      .uri("/produto/" + idInvalido)
      .exchange()
      .expectStatus()
      .isNotFound();
  }

  @Test
  void dadoNovoProduto_quandoPostProduto_entaoRespondeComStatusCreatedEProdutoValido() {
    Produto novoProduto = new Produto();
    novoProduto.setDescricao("Tupia de Mesa");
    novoProduto.setPreco(new BigDecimal(9000.00));

    Produto produtoRespondido = webTestClient
      .post()
      .uri("/produto")
      .bodyValue(novoProduto)
      .exchange()
      .expectStatus()
      .isCreated()
      .expectBody(Produto.class)
      .returnResult()
      .getResponseBody();

    assertThat(produtoRespondido).isNotNull();
    assertThat(produtoRespondido.getId()).isNotNull();
  }

  @Test
  void dadoProdutoExistente_quandoPutProduto_entaoRespondeComStatusNotContent() {
    Produto produtoExistente = new Produto();
    produtoExistente.setId(1L);
    produtoExistente.setDescricao("Furadeira a bateria");
    produtoExistente.setPreco(new BigDecimal(800.00));

    webTestClient
      .put()
      .uri("/produto")
      .bodyValue(produtoExistente)
      .exchange()
      .expectStatus()
      .isNoContent();
  }

  @Test
  void dadoProdutoIdValido_quandoDeleteProdutoPeloId_entaoRespondeComStatusNotContent() {
    Long produtoIdValido = 2L;

    webTestClient
      .delete()
      .uri("/produto/" + produtoIdValido)
      .exchange()
      .expectStatus()
      .isNoContent();
  }

  @Test
  void dadoProdutoIdValido_quandoDeleteProdutoPeloId_entaoRespondeComStatusNotFound() {
    Long produtoIdValido = 99L;

    webTestClient
      .delete()
      .uri("/produto/" + produtoIdValido)
      .exchange()
      .expectStatus()
      .isNotFound();
  }
}
