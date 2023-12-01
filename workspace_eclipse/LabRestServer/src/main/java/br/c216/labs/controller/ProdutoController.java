package br.c216.labs.controller;

import br.c216.labs.model.Produto;
import br.c216.labs.service.ProdutoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

  @Autowired
  private ProdutoService service;

  @GetMapping
  public List<Produto> getProdutos() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Produto getProdutoId(@PathVariable("id") Long produtoId) {
    Optional<Produto> opProduto = service.findById(produtoId);

    if (opProduto.isEmpty()) {
      String msgError = String.format(
        "Nenhum produto encontrado com o id %s",
        produtoId
      );
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgError);
    }

    return opProduto.get();
    //		if (opProduto.isPresent()) {
    //			return opProduto.get();
    //		}
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Produto postProduto(@RequestBody Produto p) {
    Produto produtoCriado = service.create(p);
    return produtoCriado;
  }

  @PutMapping
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void putProduto(@RequestBody Produto p) {
    service.update(p);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deleteProduto(@PathVariable("id") Long produtoId) {
    Produto produtoEncontrado = this.getProdutoId(produtoId);
    service.remove(produtoEncontrado);
  }
}
