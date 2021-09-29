package br.com.zupacademy.transacoes.form;

import br.com.zupacademy.transacoes.model.Cartao;

public class CartaoForm {

    private String id;

    private String email;

    public Cartao toModel() {
        return new Cartao(id, email);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
