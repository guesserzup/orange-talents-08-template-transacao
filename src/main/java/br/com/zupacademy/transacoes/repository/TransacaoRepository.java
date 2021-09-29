package br.com.zupacademy.transacoes.repository;

import br.com.zupacademy.transacoes.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
