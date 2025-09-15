package com.lucas.sistema.entrega.view.menu.cliente;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.view.menu.MenuGeral;
import com.lucas.sistema.entrega.view.port.ClienteController;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimir;

public class MenuAdicionarCliente extends Menu {

    private final ClienteController clienteController;

    public MenuAdicionarCliente(Leitor leitor, ClienteController clienteController) {
        super(leitor);
        this.clienteController = clienteController;
    }

    @Override
    public void executarMenu() {

        var clienteAdicionarRequest = chamarMenu();

        if(clienteAdicionarRequest == null){
            return;
        }

        var clienteResponse = clienteController.adicionar(clienteAdicionarRequest);

        System.out.println("Cliente Adicionado com sucesso");

        imprimir(clienteResponse.exibirDados());

        setProximoMenu(new MenuCliente(getLeitor()));

    }

    public ClienteAdicionarRequest chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                              ADICIONAR CLIENTE                               ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(" S- Sair");

        System.out.println(" Nome do cliente: ");
        String nome = getLeitor().nextLine();

        if(nome.equalsIgnoreCase("S")){
            setProximoMenu(new MenuCliente(getLeitor()));
            return null;
        }

        System.out.println(" CPF ou CNPJ: ");
        String cpfCnpj = getLeitor().nextLine();

        System.out.println(" Endereço: ");
        String endereco = getLeitor().nextLine();

        System.out.println(" Cidade: ");
        String cidade = getLeitor().nextLine();

        System.out.println(" Estado ( em sigla, ex: São Paulo = SP ): ");
        String estado = getLeitor().nextLine();

        System.out.println("------------------------------------------------------------------------------");

        return new ClienteAdicionarRequest(nome, cpfCnpj, endereco, cidade, estado);

    }

}
