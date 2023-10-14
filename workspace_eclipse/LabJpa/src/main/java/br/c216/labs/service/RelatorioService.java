package br.c216.labs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.c216.labs.repository.RelatorioRepository;
import br.c216.labs.dto.TotalCompradoPorFornecedorDTO;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository repository;

    public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor() {
        return repository.pesquisarTotalCompradoPorFornecedor();
    }
}
