package com.lucas.sistema.entrega.infraestrutura.utils;

import java.util.List;

public class ConsoleUtil {

    public static void imprimir(String s){
        System.out.println("-------------------------------");
        System.out.println(s);
        System.out.println("-------------------------------");
    }

    public static void imprimirLista(List<?> lista){
        if(lista.isEmpty()){
            System.out.println("| Lista Vazia");
            return;
        }

        lista.stream().forEach(System.out::println);

    }


}
