package com.lucas.sistema.entrega.view.menu.pedido;

import com.lucas.sistema.entrega.modules.pedido.application.dto.PedidoAdicionarRequest;
import com.lucas.sistema.entrega.modules.pedido.domain.enumerator.PedidoStatus;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.menu.MenuGeral;
import com.lucas.sistema.entrega.view.port.PedidoController;

import java.time.LocalDateTime;

public class MenuAdicionarPedido extends Menu {

    private final PedidoController pedidoController;

    protected MenuAdicionarPedido(Leitor leitor, PedidoController pedidoController) {
        super(leitor);
        this.pedidoController = pedidoController;
    }

    @Override
    public void executarMenu() {
        var pedido = chamarMenu();

        if(pedido == null) {
            setProximoMenu(new MenuGeral(getLeitor()));
            return;
        }

        var pedidoResponse = pedidoController.adicionar(pedido);

        System.out.println(pedidoResponse.exibirDados());

        System.out.println(" Pedido adicionado com sucesso");

        setProximoMenu(new MenuGeral(getLeitor()));

    }

    private PedidoAdicionarRequest chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                               MENU PEDIDO                                    ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(" 0- Sair");

        System.out.println(" Digite o id do cliente: ");
        long clienteId = getLeitor().nextLong();

        if(clienteId == 0) return null;

        System.out.println(" Digite o volume em m³: ");
        double volumeM3 = getLeitor().nextDouble();

        System.out.println(" Digite o peso em kg: ");
        double pesoKg = getLeitor().nextDouble();

        System.out.println(" Selecione o status do pedido: ");
        PedidoStatus.exibirValores();

        int entrada = getLeitor().nextInt();
        var pedidoStatus = PedidoStatus.pegarValor(entrada);

        return new PedidoAdicionarRequest(clienteId, LocalDateTime.now(), volumeM3, pesoKg, pedidoStatus);
    }
}
