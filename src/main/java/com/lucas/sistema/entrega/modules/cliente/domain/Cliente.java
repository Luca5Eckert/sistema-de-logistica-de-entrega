package com.lucas.sistema.entrega.modules.cliente.domain;

import com.lucas.sistema.entrega.modules.cliente.domain.exceptions.ClienteException;
import org.apache.commons.lang3.math.NumberUtils;

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

    public Cliente(long id, String nome, String cpfCnpj, String endereco, String cidade, String estado) {
        this.id = id;
        setNome(nome);
        setCpfCnpj(cpfCnpj);
        setEndereco(endereco);
        setCidade(cidade);
        setEstado(estado);
    }

    public Cliente(String nome, String cpfCnpj, String endereco, String cidade, String estado) {
        this.id = -1;
        setNome(nome);
        setCpfCnpj(cpfCnpj);
        setEndereco(endereco);
        setCidade(cidade);
        setEstado(estado);
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.isBlank()){
            throw new ClienteException("Nome não pode ser branco");
        }
        if(nome.length() > 20){
            throw new ClienteException("Nome não pode ser maior que 20 letras");
        }
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        if(cpfCnpj.isBlank()){
            throw new ClienteException("CPF/CNPJ não pode ser branco");
        }
        if(cpfCnpj.length() == 11 || cpfCnpj.length() == 14){
            throw new ClienteException("CPF/CNPJ precisa ter 11 ou 14 números");
        }
        if (!NumberUtils.isCreatable(cpfCnpj)) {
            throw new ClienteException("CPF/CNPJ precisa ser apenas digitos");
        }

        this.cpfCnpj = cpfCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if(endereco.isBlank()){
            throw new ClienteException("Endereço não pode ser branco");
        }
        if(endereco.length() > 50){
            throw new ClienteException("Endereço não pode ser maior que 50");
        }
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if(cidade.isBlank()){
            throw new ClienteException("Cidade não pode ser branco");
        }
        if(cidade.length() > 30){
            throw new ClienteException("Cidade não pode ser maior que 30");
        }
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if(estado.isBlank()){
            throw new ClienteException("Estado não pode ser branco");
        }
        if(estado.length() > 30){
            throw new ClienteException("Estado não pode ser maior que 30");
        }
        this.estado = estado;
    }
}
