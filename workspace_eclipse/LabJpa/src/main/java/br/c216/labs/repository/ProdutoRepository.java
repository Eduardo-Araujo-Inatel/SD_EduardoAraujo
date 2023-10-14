package br.c216.labs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.c216.labs.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
