package br.c216.labs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.c216.labs.repository.ProdutoRepository;
import br.c216.labs.entity.Produto;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto p) {
        return produtoRepository.save(p);
    }

    public Optional<Produto> buscarPeloId(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public void remove(Produto p) {
        produtoRepository.delete(p);
    }

}