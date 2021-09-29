package br.com.zupacademy.transacoes.model;

import org.hibernate.id.UUIDGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(generator = UUIDGenerator.UUID_GEN_STRATEGY)
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
}
