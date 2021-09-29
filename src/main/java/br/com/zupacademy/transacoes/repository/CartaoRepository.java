package br.com.zupacademy.transacoes.repository;

import br.com.zupacademy.transacoes.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    Optional<Cartao> findByNumeroCartao(String id);
}
