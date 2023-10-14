package br.c216.labs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.c216.labs.entity.NotaCompra;

@Repository
public interface NotaCompraRepository extends JpaRepository<NotaCompra, Long> {
}
