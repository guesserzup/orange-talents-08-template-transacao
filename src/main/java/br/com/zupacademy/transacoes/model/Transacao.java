package br.com.zupacademy.transacoes.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private LocalDateTime efetivadaEm;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cartao_id")
    private Cartao cartao;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String idMensagem, BigDecimal valor, LocalDateTime efetivadaEm, Estabelecimento estabelecimento, Cartao cartao) {
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public Estabelecimento getEstabelecimento() { return estabelecimento; }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() { return valor; }
}
