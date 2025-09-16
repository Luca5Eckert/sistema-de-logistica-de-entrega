package com.lucas.sistema.entrega.view.menu.entrega;

import com.lucas.sistema.entrega.modules.entrega.application.dto.EntregaExcluirRequest;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.EntregaController;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimir;

public class MenuExcluirEntrega extends Menu {

    private final EntregaController entregaController;

    protected MenuExcluirEntrega(Leitor leitor, EntregaController entregaController) {
        super(leitor);
        this.entregaController = entregaController;
    }

    @Override
    public void executarMenu() {
        long input = chamarMenu();

        if (input == -1) {
            System.out.println(" Exclusão cancelada com sucesso");
            setProximoMenu(new MenuEntrega(getLeitor()));
            return;
        }

        entregaController.excluirEntrega(new EntregaExcluirRequest(input));

        System.out.println("| Entrega deletada com sucesso");

        setProximoMenu(new MenuEntrega(getLeitor()));
    }

    private long chamarMenu() {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                               EXCLUIR ENTREGA                                ");
        System.out.println("------------------------------------------------------------------------------");

        System.out.println("| Digite o ID da entrega que deseja excluir: ( 0 para cancelar )");
        long id = getLeitor().nextLong();

        if(id == 0) return -1;

        var entrega = entregaController.pegarEntrega(id);

        imprimir(entrega.exibirDados());

        System.out.println("| Confirma exclusão dessa entrega ? ");
        System.out.println("| 1- Sim \n| 2- Não");
        String input = getLeitor().nextLine();

        if(input.equalsIgnoreCase("2")) id = -1;

        System.out.println("------------------------------------------------------------------------------");

        return id;
    }

}