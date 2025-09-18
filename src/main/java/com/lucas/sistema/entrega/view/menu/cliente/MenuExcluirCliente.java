package com.lucas.sistema.entrega.view.menu.cliente;

import com.lucas.sistema.entrega.modulo.cliente.application.dto.ClienteExcluirRequest;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.ClienteController;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimir;

public class MenuExcluirCliente extends Menu {

    private final ClienteController clienteController;

    protected MenuExcluirCliente(Leitor leitor, ClienteController clienteController) {
        super(leitor);
        this.clienteController = clienteController;
    }

    @Override
    public void executarMenu() {

        long input = chamarMenu();

        if (input == -1) {
            System.out.println(" Exclusão cancelada com sucesso");
            setProximoMenu(new MenuCliente(getLeitor()));
            return;
        }

        clienteController.excluir(new ClienteExcluirRequest(input));

        System.out.println("| Cliente deletado com sucesso");

        setProximoMenu(new MenuCliente(getLeitor()));
    }

    private long chamarMenu() {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                               EXCLUIR CLIENTE                                ");
        System.out.println("------------------------------------------------------------------------------");

        System.out.println("| Digite o ID do cliente que deseja excluir: ( 0 para cancelar )");
        long id = getLeitor().nextLong();

        if(id == 0) return -1;

        var cliente = clienteController.buscarPeloID(id);

        imprimir(cliente.exibirDados());

        System.out.println("| Confirma exclusão desse cliente ? ");
        System.out.println("| 1- Sim \n| 2- Não");
        String input = getLeitor().nextLine();

        if(input.equalsIgnoreCase("2")) id = -1;

        System.out.println("------------------------------------------------------------------------------");

        return id;


    }
}
