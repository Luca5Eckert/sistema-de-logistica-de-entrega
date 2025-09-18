package com.lucas.sistema.entrega.view.menu.motorista;

import com.lucas.sistema.entrega.modulo.motorista.application.controller.MotoristaControllerAdapter;
import com.lucas.sistema.entrega.modulo.motorista.application.dto.MotoristaAdicionarRequest;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimir;

public class MenuCadastrarMotorista extends Menu {

    private final MotoristaControllerAdapter motoristaController;

    protected MenuCadastrarMotorista(Leitor leitor, MotoristaControllerAdapter motoristaController) {
        super(leitor);
        this.motoristaController = motoristaController;
    }

    @Override
    public void executarMenu() {
        var motorista = chamarMenu();

        if(motorista == null) {
            setProximoMenu(new MenuMotorista(getLeitor()));
            return;
        }

        var motoristaResponse = motoristaController.cadastrar(motorista);

        System.out.println("Motorista Adicionado com sucesso");

        imprimir(motoristaResponse.exibirDados());

        setProximoMenu(new MenuMotorista(getLeitor()));
    }

    private MotoristaAdicionarRequest chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                              ADICIONAR MOTORISTA                             ");
        System.out.println("------------------------------------------------------------------------------");

        System.out.println(" S- Sair");

        System.out.println(" Nome do motorista: ");
        String nome = getLeitor().nextLine();

        if(nome.equalsIgnoreCase("S")) return null;

        System.out.println(" CNH: ");
        String cnh = getLeitor().nextLine();

        System.out.println(" Placa do veiculo: ");
        String veiculo = getLeitor().nextLine();

        System.out.println(" Cidade base: ");
        String cidade = getLeitor().nextLine();

        System.out.println("------------------------------------------------------------------------------");

        return new MotoristaAdicionarRequest(nome, cnh, veiculo, cidade);
    }

}
