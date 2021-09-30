package br.com.zupacademy.transacoes.transacao;

import br.com.zupacademy.transacoes.estabelecimento.Estabelecimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {

    private Long id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private Estabelecimento estabelecimento;

    @Deprecated
    public TransacaoDto() {
    }

    public TransacaoDto(Long id, BigDecimal valor, LocalDateTime efetivadaEm, Estabelecimento estabelecimento) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
    }

    public TransacaoDto(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.estabelecimento = transacao.getEstabelecimento();
    }

    public Long getId() { return id; }

    public BigDecimal getValor() { return valor; }

    public LocalDateTime getEfetivadaEm() { return efetivadaEm; }

    public Estabelecimento getEstabelecimentos() { return estabelecimento; }
}
