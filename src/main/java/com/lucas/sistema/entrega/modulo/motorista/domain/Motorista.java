package com.lucas.sistema.entrega.modulo.motorista.domain;

public class Motorista {

    private final long id;

    private String nome;

    private String cnh;

    private String veiculo;

    private String cidadeBase;

    public Motorista(long id, String nome, String cnh, String veiculo, String cidadeBase) {
        this.id = id;
        this.nome = nome;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.cidadeBase = cidadeBase;
    }

    public Motorista(String nome, String cnh, String veiculo, String cidadeBase) {
        this.id = -1;
        this.nome = nome;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.cidadeBase = cidadeBase;
    }
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getCidadeBase() {
        return cidadeBase;
    }

    public void setCidadeBase(String cidadeBase) {
        this.cidadeBase = cidadeBase;
    }
}
