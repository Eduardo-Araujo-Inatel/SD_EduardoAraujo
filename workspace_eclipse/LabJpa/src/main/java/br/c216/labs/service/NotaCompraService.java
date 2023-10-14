package br.c216.labs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.c216.labs.repository.NotaCompraItemRepository;
import br.c216.labs.repository.NotaCompraRepository;
import br.c216.labs.entity.NotaCompra;
import br.c216.labs.entity.NotaCompraItem;

@Service
@Transactional
public class NotaCompraService {

    @Autowired
    private NotaCompraRepository ncRepository;

    @Autowired
    private NotaCompraItemRepository nciRepository;

    public NotaCompra salvarNotaCompra(NotaCompra nc) {
        return ncRepository.save(nc);
    }

    public Optional<NotaCompra> buscarNotaCompraPeloId(Long id) {
        return ncRepository.findById(id);
    }

    public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
        Optional<NotaCompra> opNotaCompra = ncRepository.findById(id);
        if (opNotaCompra.isPresent()) {
            NotaCompra notaCompra = opNotaCompra.get();
            notaCompra.getListaNotaCompraItem().size();
            return notaCompra;
        } else {
            throw new RuntimeException("Nenhuma nota compra encontrada");
        }
    }

    public List<NotaCompra> listarNotaCompra() {
        return ncRepository.findAll();
    }

    public NotaCompraItem salvar(NotaCompraItem item) {
        return nciRepository.save(item);
    }

    public Optional<NotaCompraItem> buscarNotaCompraItemPeloId(Long id) {
        return nciRepository.findById(id);
    }

    public List<NotaCompraItem> listaNotaCompraItem() {
        return nciRepository.findAll();
    }
}
