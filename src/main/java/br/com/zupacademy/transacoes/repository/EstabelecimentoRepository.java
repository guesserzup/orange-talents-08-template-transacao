package br.com.zupacademy.transacoes.repository;

import br.com.zupacademy.transacoes.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
}
