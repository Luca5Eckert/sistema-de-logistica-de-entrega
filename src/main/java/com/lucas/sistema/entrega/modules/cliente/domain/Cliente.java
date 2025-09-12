package com.lucas.sistema.entrega.modules.cliente.domain;

public class Cliente {

    private final long id;

    private String nome;

    private String cpfCnpj;

    private String endereco;

    private String cidade;

    private String estado;

    public Cliente(long id) {
        this.id = id;
        this.nome = null;
        this.cpfCnpj = null;
        this.endereco = null;
        this.cidade = null;
        this.estado = null;
    }

    public long getId() {
        return id;
    }

    public Cliente(long id, String nome, String cpfCnpj, String endereco, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Cliente(String nome, String cpfCnpj, String endereco, String cidade, String estado) {
        this.id = -1;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
