package com.lucas.sistema.entrega.view.menu.cliente;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.view.port.ClienteController;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.ClienteDtoProvider;

public class MenuAdicionarCliente extends Menu<ClienteAdicionarRequest> {

    private final ClienteController clienteController;
    private final ClienteDtoProvider clienteDtoProvider;

    protected MenuAdicionarCliente(Leitor leitor, ClienteController clienteController, ClienteDtoProvider clienteDtoProvider) {
        super(leitor);
        this.clienteController = clienteController;
        this.clienteDtoProvider = clienteDtoProvider;
    }

    @Override
    public void chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                              ADICIONAR CLIENTE                               ");
        System.out.println("------------------------------------------------------------------------------");

        System.out.println(" Nome do cliente: ");
        String nome = getLeitor().nextLine();

        System.out.println(" CPF ou CNPJ: ");
        String cpfCnpj = getLeitor().nextLine();

        System.out.println(" Cidade: ");
        String cidade = getLeitor().nextLine();

        System.out.println(" Estado: ");
        String estado = getLeitor().nextLine();

        System.out.println("------------------------------------------------------------------------------");

        setResposta(clienteDtoProvider.criarDtoCriarCliente(nome, cpfCnpj, cidade, estado));

    }

    @Override
    public void executarMenu() {
        var clienteResponse = clienteController.adicionar(getResposta());
    }

    @Override
    public Menu devolverProximoMenu() {
        return null;
    }
}
