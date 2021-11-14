package br.com.cwi.reset.projeto1;

import java.util.Scanner;

public class LeitorTeclado {

    public Double lerDouble(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextDouble();
    }
}
