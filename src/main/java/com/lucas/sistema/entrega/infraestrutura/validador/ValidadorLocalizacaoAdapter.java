package com.lucas.sistema.entrega.infraestrutura.validador;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucas.sistema.entrega.infraestrutura.conexao.exception.ConexaoApiException;
import com.lucas.sistema.entrega.modulo.cliente.domain.port.ValidadorLocalizacao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.StreamSupport;

public class ValidadorLocalizacaoAdapter implements ValidadorLocalizacao {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private static final String BASE_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/";

    public ValidadorLocalizacaoAdapter() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }


    /**
     * Valida um estado ou uma cidade.
     * Importante: Para validar uma CIDADE, a sigla do estado é obrigatória.
     *
     * @param tipo Tipo de localização a ser validada (ESTADO ou CIDADE).
     * @param nome Nome do estado ou cidade.
     * @param estadoOpcional A sigla do estado, necessária apenas para validar uma CIDADE.
     * @return true se a localização for válida, false caso contrário.
     */
    @Override
    public boolean validarLocalizacao(LocationType tipo, String nome, String estadoOpcional) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }

        try {
            switch (tipo) {
                case ESTADO:
                    return isValidState(nome);
                case CIDADE:
                    if (estadoOpcional == null || estadoOpcional.trim().isEmpty()) {
                        return false;
                    }
                    return isValidCity(nome, estadoOpcional);
                default:
                    return false;
            }
        } catch (IOException | InterruptedException e) {
            throw new ConexaoApiException("Erro ao se conectar com a API");
        }
    }

    private boolean isValidState(String nomeEstado) throws IOException, InterruptedException {
        String nomeNormalizado = nomeEstado.trim().toUpperCase();
        String url = BASE_URL + "estados";

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            return false;
        }

        JsonNode rootNode = objectMapper.readTree(response.body());

        return StreamSupport.stream(rootNode.spliterator(), false)
                .anyMatch(node -> node.has("sigla") && node.get("sigla").asText().equals(nomeNormalizado));
    }

    private boolean isValidCity(String nomeCidade, String siglaEstado) throws IOException, InterruptedException {
        String nomeNormalizado = nomeCidade.trim();
        String estadoNormalizado = siglaEstado.trim().toUpperCase();

        String url = BASE_URL + "estados/" + estadoNormalizado + "/municipios";

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            return false;
        }

        JsonNode rootNode = objectMapper.readTree(response.body());

        return StreamSupport.stream(rootNode.spliterator(), false)
                .anyMatch(node -> node.has("nome") && node.get("nome").asText().equalsIgnoreCase(nomeNormalizado));
    }



}