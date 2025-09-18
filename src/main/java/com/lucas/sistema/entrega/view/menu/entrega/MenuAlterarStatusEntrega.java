package com.lucas.sistema.entrega.view.menu.entrega;

import com.lucas.sistema.entrega.infraestrutura.utils.beans.EntregaBeansUtil;
import com.lucas.sistema.entrega.modulo.entrega.application.dto.EntregaAtualizarStatusRequest;
import com.lucas.sistema.entrega.modulo.entrega.domain.enumerator.EntregaStatus;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.EntregaController;

public class MenuAlterarStatusEntrega extends Menu {

    private final EntregaController entregaController;

    public MenuAlterarStatusEntrega(Leitor leitor, EntregaController entregaController) {
        super(leitor);
        this.entregaController = entregaController;
    }

    @Override
    public void executarMenu() {

        var atualizarEntregaRequest = chamarMenu();

        if(atualizarEntregaRequest == null){
            System.out.println("| Atualização cancelada");
            setProximoMenu(new MenuEntrega(getLeitor()));
            return;
        }

        entregaController.atualizarStatus(atualizarEntregaRequest);

        System.out.println("| Alterado com sucesso ");

        setProximoMenu(new MenuEntrega(getLeitor()));

    }

    private EntregaAtualizarStatusRequest chamarMenu() {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                       ATUALIZAR STATUS ENTREGA                               ");
        System.out.println("------------------------------------------------------------------------------");

        System.out.println(" 0 - Sair");

        System.out.println("| Digite o id da entrega: ");
        long idEntrega = getLeitor().nextLong();

        if(idEntrega == 0) return null;

        var entregaResponse = entregaController.pegarEntrega(idEntrega);

        System.out.println("------------------");
        System.out.println("| Status atual: ");
        System.out.println("| " + entregaResponse.entregaStatus().getEscrito());

        System.out.println(" Selecione o novo status: ");
        EntregaStatus.exibirValores();

        int selecao = getLeitor().nextInt();
        EntregaStatus novoStatus = EntregaStatus.pegarValor(selecao);

        return new EntregaAtualizarStatusRequest(idEntrega, novoStatus);

    }

    public static void main(String[] args) {
        MenuAlterarStatusEntrega m = new MenuAlterarStatusEntrega(new Leitor(), EntregaBeansUtil.toInstanceController());

        m.executarMenu();
    }

}
