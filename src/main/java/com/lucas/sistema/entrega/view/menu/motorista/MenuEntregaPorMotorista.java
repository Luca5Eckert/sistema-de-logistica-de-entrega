package com.lucas.sistema.entrega.view.menu.motorista;

import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.EntregaController;
import com.lucas.sistema.entrega.view.port.MotoristaController;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimir;

public class MenuEntregaPorMotorista extends Menu {
    
    private final EntregaController entregaController;

    public MenuEntregaPorMotorista(Leitor leitor, EntregaController entregaController) {
        super(leitor);
        this.entregaController = entregaController;
    }

    @Override
    public void executarMenu() {
        var id = chamarMenu();

        if(id == 0){
            setProximoMenu(new MenuMotorista(getLeitor()));
            return;
        }

        long quantidadeEntrega = entregaController.pegarTotalEntregasPorMotorista(id);

        exibirQuantidadeEntrega(quantidadeEntrega);

        setProximoMenu(new MenuMotorista(getLeitor()));
    }

    private void exibirQuantidadeEntrega(long quantidadeEntrega) {
        if(quantidadeEntrega == -1){
            System.out.println(" Motorista não encontrado ");
            return;
        }
        imprimir("Quantidade entregas: " + quantidadeEntrega);
    }

    private long chamarMenu() {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                      TOTAL DE ENTREGAS POR MOTORISTA                         ");
        System.out.println("------------------------------------------------------------------------------");

        System.out.println("| Digite o id do motorista: ( 0 para sair )");

        return getLeitor().nextLong();

    }
}
