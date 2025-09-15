package com.lucas.sistema.entrega.modules.cliente.domain.port;

import com.lucas.sistema.entrega.infraestrutura.validador.LocationType;

public interface ValidadorLocalizacao {


    /**
     * Valida se a localização ( estado ou cidade ), é valido segundo
     * alguma API com estados salvos
     *
     * @param tipo que deseja validar
     * @return retorna se a localização é valido
     */
    boolean validarLocalizacao(LocationType tipo, String nome, String estadoOpcional);

}
