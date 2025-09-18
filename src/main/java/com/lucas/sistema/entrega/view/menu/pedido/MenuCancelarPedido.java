package com.lucas.sistema.entrega.view.menu.pedido;

import com.lucas.sistema.entrega.modulo.pedido.application.dto.PedidoCancelarRequest;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.PedidoController;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimir;

public class MenuCancelarPedido extends Menu {

    private final PedidoController pedidoController;

    protected MenuCancelarPedido(Leitor leitor, PedidoController pedidoController) {
        super(leitor);
        this.pedidoController = pedidoController;
    }

    @Override
    public void executarMenu() {
        long id = chamarMenu();

        if (id == -1) {
            imprimir("| Cancelamento de pedido interrompido.");
            setProximoMenu(new MenuPedido(getLeitor()));
            return;
        }

        pedidoController.cancelarPedido(new PedidoCancelarRequest(id));
        imprimir("| Pedido cancelado com sucesso!");

        setProximoMenu(new MenuPedido(getLeitor()));
    }

    private long chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                              CANCELAR PEDIDO                                 ");
        System.out.println("------------------------------------------------------------------------------");

        imprimir("| Digite o ID do pedido que deseja cancelar: (0 para cancelar)");
        long id = getLeitor().nextLong();

        if(id == 0) return -1;

        var pedido = pedidoController.buscarPeloId(id);

        imprimir(pedido.exibirDados());

        imprimir("| Confirma o cancelamento desse pedido? ");
        imprimir("| 1- Sim \n| 2- Não");
        String inputConfirmacao = getLeitor().nextLine();

        if (!inputConfirmacao.equalsIgnoreCase("1")) return -1;

        return id;
    }
}