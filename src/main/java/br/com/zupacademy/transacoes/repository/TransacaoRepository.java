package br.com.zupacademy.transacoes.repository;

import br.com.zupacademy.transacoes.model.Cartao;
import br.com.zupacademy.transacoes.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findAllByCartao(Cartao cartao);
}
