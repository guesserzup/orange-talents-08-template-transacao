package br.com.zupacademy.transacoes.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String numeroCartao;

    @Email
    private String email;


    @Deprecated
    public Cartao() {
    }

    public Cartao(String id, String email) {
        this.numeroCartao = id;
        this.email = email;
    }

    public Long getId() { return id; }

    public String getNumeroCartao() { return numeroCartao; }

    public String getEmail() { return email; }
}
