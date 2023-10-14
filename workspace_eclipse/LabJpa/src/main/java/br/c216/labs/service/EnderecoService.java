package br.c216.labs.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.c216.labs.entity.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class EnderecoService {

    @PersistenceContext
    private EntityManager em;

    public Endereco salvar(Endereco e) {
        return em.merge(e);
    }
}
