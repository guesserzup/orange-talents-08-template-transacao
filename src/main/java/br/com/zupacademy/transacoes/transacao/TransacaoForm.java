package br.com.zupacademy.transacoes.transacao;

import br.com.zupacademy.transacoes.cartao.Cartao;
import br.com.zupacademy.transacoes.cartao.CartaoForm;
import br.com.zupacademy.transacoes.estabelecimento.Estabelecimento;
import br.com.zupacademy.transacoes.estabelecimento.EstabelecimentoForm;
import br.com.zupacademy.transacoes.cartao.CartaoRepository;
import br.com.zupacademy.transacoes.estabelecimento.EstabelecimentoRepository;

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
