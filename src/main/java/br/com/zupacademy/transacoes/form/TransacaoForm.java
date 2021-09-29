package br.com.zupacademy.transacoes.form;

import br.com.zupacademy.transacoes.model.Cartao;
import br.com.zupacademy.transacoes.model.Estabelecimento;
import br.com.zupacademy.transacoes.model.Transacao;
import br.com.zupacademy.transacoes.repository.CartaoRepository;
import br.com.zupacademy.transacoes.repository.EstabelecimentoRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoForm {

    private String id;

    private BigDecimal valor;

    private CartaoForm cartao;

    private LocalDateTime efetivadaEm;

    private EstabelecimentoForm estabelecimento;

    public Transacao toModel(CartaoRepository cartaoRepository, EstabelecimentoRepository estabelecimentoRepository) {

        Cartao cartao = cartaoRepository.findByNumeroCartao(this.cartao.getId()).orElse(this.cartao.toModel());
        cartaoRepository.save(cartao);

        Estabelecimento estabelecimento = this.estabelecimento.toModel();
        estabelecimentoRepository.save(estabelecimento);

        return new Transacao(id, valor, efetivadaEm, estabelecimento, cartao);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoForm getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoForm getCartao() {
        return cartao;
    }
}
