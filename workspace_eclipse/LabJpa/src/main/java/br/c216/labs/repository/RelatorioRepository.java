package br.c216.labs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.c216.labs.dto.TotalCompradoPorFornecedorDTO;
import br.c216.labs.entity.NotaCompraItem;

@Repository
public interface RelatorioRepository extends JpaRepository<NotaCompraItem, Long> {

	@Query("""
			select new br.c216.labs.dto.TotalCompradoPorFornecedorDTO
					( f.razaoSocial, sum(i.quantidade * i.valorCompraProduto))
				from NotaCompraItem i
					join i.notaCompra n
					join n.fornecedor f
				group by f.razaoSocial
			""")
	public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor();
}
