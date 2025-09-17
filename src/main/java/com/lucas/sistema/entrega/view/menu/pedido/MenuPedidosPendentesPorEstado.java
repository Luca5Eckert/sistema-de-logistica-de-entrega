package com.lucas.sistema.entrega.view.menu.pedido;

import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.PedidoController;

import java.util.Map;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimir;

public class MenuPedidosPendentesPorEstado extends Menu {

    private final PedidoController pedidoController;

    public MenuPedidosPendentesPorEstado(Leitor leitor, PedidoController pedidoController) {
        super(leitor);
        this.pedidoController = pedidoController;
    }

    @Override
    public void executarMenu() {
        var pedidosPorEstado = pedidoController.pegarQuantidadePedidosPendentesPorEstado();

        chamarMenu(pedidosPorEstado);

        setProximoMenu(new MenuPedido(getLeitor()));
    }

    private void chamarMenu( Map<String, Long> pedidosPorEstado) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                   PEDIDOS PENDENTES POR ESTADO                               ");
        System.out.println("------------------------------------------------------------------------------");


        if (pedidosPorEstado.isEmpty()) {
            imprimir("| Não há pedidos pendentes no momento.");
        } else {
            pedidosPorEstado.forEach((estado, quantidade) ->
                    imprimir("| " + estado + ": " + quantidade + " pedido(s) pendente(s)")
            );
        }

        System.out.println("------------------------------------------------------------------------------");
    }
}