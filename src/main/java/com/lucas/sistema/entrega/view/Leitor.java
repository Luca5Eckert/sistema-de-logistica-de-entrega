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
            return scanner.nextInt();
        } catch (RuntimeException e) {
            throw new RuntimeException(imprimirMensagemErro());
        }
    }

    public double nextDouble(){
        try{
            return scanner.nextDouble();
        } catch (RuntimeException e) {
            throw new RuntimeException(imprimirMensagemErro());
        }
    }

    public long nextLong() {
        try{
            return scanner.nextLong();
        } catch (RuntimeException e) {
            throw new RuntimeException(imprimirMensagemErro());
        }
    }

    private String imprimirMensagemErro() {
        scanner.nextLine();
        return "Input invalido";
    }
}
