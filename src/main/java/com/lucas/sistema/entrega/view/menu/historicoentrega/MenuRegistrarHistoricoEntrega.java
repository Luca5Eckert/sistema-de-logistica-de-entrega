package com.lucas.sistema.entrega.view.menu.historicoentrega;

import com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil;
import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.HistoricoEntregaAdicionarRequest;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.menu.entrega.MenuEntrega;
import com.lucas.sistema.entrega.view.port.HistoricoEntregaController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MenuRegistrarHistoricoEntrega extends Menu {

    private final HistoricoEntregaController historicoEntregaController;

    protected MenuRegistrarHistoricoEntrega(Leitor leitor, HistoricoEntregaController historicoEntregaController) {
        super(leitor);
        this.historicoEntregaController = historicoEntregaController;
    }

    @Override
    public void executarMenu() {
        var historicoEntrega = chamarMenu();

        var historicoEntregaResponse = historicoEntregaController.adicionar(historicoEntrega);

        ConsoleUtil.imprimir("Evento adicionada com sucesso");

        ConsoleUtil.imprimir(historicoEntregaResponse.exibirDados());

        setProximoMenu(new MenuHistoricoEntrega(getLeitor()));
    }

    private HistoricoEntregaAdicionarRequest chamarMenu() {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                            REGISTRAR EVENTO                                  ");
        System.out.println("------------------------------------------------------------------------------");

        System.out.println(" Id entrega: ");
        var idEntrega = getLeitor().nextLong();

        System.out.println(" Descrição: ");
        var descricao = getLeitor().nextLine();

        var data = lerDataSaida();

        return new HistoricoEntregaAdicionarRequest(idEntrega, data, descricao);

    }

    private LocalDateTime lerDataSaida() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {

            System.out.println("Digite o dia do evento (ex: yyyy-MM-dd): ");
            String diaSaida = getLeitor().nextLine();
            return LocalDate.parse(diaSaida, formatter).atStartOfDay();

        } catch (Exception e) {
            throw new RuntimeException("Data mal formatada, tente novamente");
        }

    }


}
