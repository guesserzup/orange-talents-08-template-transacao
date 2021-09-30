package br.com.zupacademy.transacoes.estabelecimento;

public class EstabelecimentoForm {

    private String id;

    private String nome;

    private String cidade;

    private String endereco;

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }

    public String getId() { return id; }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
