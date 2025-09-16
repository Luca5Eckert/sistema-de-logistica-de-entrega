package com.lucas.sistema.entrega.view.menu.entrega;

import com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil;
import com.lucas.sistema.entrega.modules.entrega.application.controller.EntregaController;
import com.lucas.sistema.entrega.modules.entrega.application.dto.EntregaAdicionarRequest;
import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MenuAdicionarEntrega extends Menu {

    private final EntregaController entregaController;

    protected MenuAdicionarEntrega(Leitor leitor, EntregaController entregaController) {
        super(leitor);
        this.entregaController = entregaController;
    }

    @Override
    public void executarMenu() {
        var entrega = chamarMenu();
        var entregaResponse = entregaController.adicionar(entrega);

        ConsoleUtil.imprimir("Entrega adicionada com sucesso");
        ConsoleUtil.imprimir(entregaResponse.exibirDados());

        setProximoMenu(new MenuEntrega(getLeitor()));
    }

    private EntregaAdicionarRequest chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                            ADICIONAR ENTREGA                                 ");
        System.out.println("------------------------------------------------------------------------------");

        long idPedido = lerId("pedido");
        long idMotorista = lerId("motorista");
        EntregaStatus status = lerStatus();
        LocalDateTime dataSaida = lerDataSaida();

        return new EntregaAdicionarRequest(idPedido, idMotorista, dataSaida, status);
    }

    private long lerId(String tipo) {
        System.out.printf("Digite o id do %s: %n", tipo);
        return getLeitor().nextLong();
    }

    private EntregaStatus lerStatus() {
        System.out.println("Digite o Status da entrega: ");
        EntregaStatus.exibirValores();
        return EntregaStatus.pegarValor(getLeitor().nextInt());
    }

    private LocalDateTime lerDataSaida() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {

            System.out.println("Digite o dia da saída (ex: yyyy-MM-dd): ");
            String diaSaida = getLeitor().nextLine();
            return LocalDate.parse(diaSaida, formatter).atStartOfDay();

        } catch (Exception e) {
            throw new RuntimeException("Data mal formatada, tente novamente: ");
        }

    }


}
