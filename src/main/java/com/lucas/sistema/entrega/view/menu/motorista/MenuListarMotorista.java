package com.lucas.sistema.entrega.view.menu.motorista;

import com.lucas.sistema.entrega.modulo.motorista.application.dto.MotoristaResponse;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.MotoristaController;

import java.util.List;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimirLista;

public class MenuListarMotorista extends Menu {

    private final MotoristaController motoristaController;

    public MenuListarMotorista(Leitor leitor, MotoristaController motoristaController){
        super(leitor);
        this.motoristaController = motoristaController;
    }


    @Override
    public void executarMenu() {
        var motoristas = motoristaController.pegarMotoristas();

        chamarMenu(motoristas);

        setProximoMenu(new MenuMotorista(getLeitor()));
    }

    private void chamarMenu(List<MotoristaResponse> motoristas) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                            LISTAR MOTORISTA                                  ");
        System.out.println("------------------------------------------------------------------------------");

        imprimirLista(motoristas);

        System.out.println("------------------------------------------------------------------------------");


    }

}
