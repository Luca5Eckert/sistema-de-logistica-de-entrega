package com.lucas.sistema.entrega.view;


import java.util.Scanner;

public class Leitor {
    private final Scanner scanner = new Scanner(System.in);

    public String nextLine(){
        try{
            return scanner.nextLine();
        } catch (RuntimeException e) {
            throw new RuntimeException(imprimirMensagemErro());
        }
    }

    public int nextInt(){
        try{
            int valor = scanner.nextInt();
            nextLine();
            return valor;
        } catch (RuntimeException e) {
            throw new RuntimeException(imprimirMensagemErro());
        }
    }

    public double nextDouble(){
        try{
            double valor = scanner.nextDouble();
            nextLine();
            return valor;
        } catch (RuntimeException e) {
            throw new RuntimeException(imprimirMensagemErro());
        }
    }

    public long nextLong() {
        try{
            long valor = scanner.nextLong();
            nextLine();
            return valor;
        } catch (RuntimeException e) {
            throw new RuntimeException(imprimirMensagemErro());
        }
    }

    private String imprimirMensagemErro() {
        scanner.nextLine();
        return "Input invalido";
    }
}
