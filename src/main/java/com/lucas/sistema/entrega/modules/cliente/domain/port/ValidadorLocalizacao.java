package com.lucas.sistema.entrega.modules.cliente.domain.port;

public interface ValidadorLocalizacao {


    /**
     * Valida se a localização ( estado ou cidade ), é valido segundo
     * alguma API com estados salvos
     *
     * @param localizacao que deseja validar
     * @return retorna se a localização é valido
     */
    boolean valida(String localizacao);

}
