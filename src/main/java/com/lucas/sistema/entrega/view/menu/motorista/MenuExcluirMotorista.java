package com.lucas.sistema.entrega.view.menu.motorista;

import com.lucas.sistema.entrega.modules.motorista.application.dto.MotoristaDeletarRequest;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.MotoristaController;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimir;

public class MenuExcluirMotorista extends Menu {

    private final MotoristaController motoristaController;

    protected MenuExcluirMotorista(Leitor leitor, MotoristaController motoristaController) {
        super(leitor);
        this.motoristaController = motoristaController;
    }

    @Override
    public void executarMenu() {
        long id = chamarMenu();

        if (id == -1) {
            System.out.println(" Exclusão cancelada com sucesso");
            setProximoMenu(new MenuMotorista(getLeitor()));
            return;
        }

        motoristaController.excluir(new MotoristaDeletarRequest(id));
        System.out.println("| Motorista deletado com sucesso");

        setProximoMenu(new MenuMotorista(getLeitor()));
    }

    private long chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                               EXCLUIR MOTORISTA                              ");
        System.out.println("------------------------------------------------------------------------------");

        System.out.println("| Digite o ID do motorista que deseja excluir: (0 para cancelar)");
        long id = getLeitor().nextLong();

        if(id == 0) return -1;

        var motorista = motoristaController.buscarPeloID(id);

        imprimir(motorista.exibirDados());

        System.out.println("| Confirma exclusão desse motorista ? ");
        System.out.println("| 1- Sim \n| 2- Não");
        String inputConfirmacao = getLeitor().nextLine();

        System.out.println("------------------------------------------------------------------------------");

        if (!inputConfirmacao.equalsIgnoreCase("1")) return -1;

        return id;

    }

}