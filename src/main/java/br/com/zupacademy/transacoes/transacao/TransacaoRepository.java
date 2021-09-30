package br.com.zupacademy.transacoes.transacao;

import br.com.zupacademy.transacoes.cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findTop10ByCartao(Cartao cartao);
}
