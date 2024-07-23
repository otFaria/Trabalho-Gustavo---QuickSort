package com.mycompany.trabalho4;
import java.util.Scanner;

public class Trabalho4 {

    // Função que calcula a raiz quadrada de y no intervalo [a, b]
    public static double encontraRaiz(double a, double b, double y) {
        double meio = (a + b) / 2.0;
        double Meio2 = meio * meio;

        // Condição de parada
        //MAth.abs é para calcular a raiz
        if (Math.abs(Meio2 - y) < 0.0001) {
            return meio;
        }

        // Busca recursiva no intervalo inferior
        if (Meio2 > y) {
            return encontraRaiz(a, meio, y);
        }else{
            // Busca recursiva no intervalo superior
            return encontraRaiz(meio, b, y);
        }
    }

    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        double resultado = 0.0;
        double a = 0.0;
        double b = 0.0;
        double y = 0.0;
        
        System.out.println("Calculo de raiz em um intervalo definido.");
        
        System.out.print("Digite o valor inicial do intervalo A: ");
        a = f.nextDouble();
        System.out.print("Digite o valor final do intervalo B: ");
        b = f.nextDouble();
        System.out.print("Digite o valor que seja verificar se a raiz quadrada: ");
        y = f.nextDouble();
        
        //Verifica se y é < 0
        if (y < 0){
            System.out.println("Impossivel calcular a raiz quadrada de um número negativo.");
        }else{
            // Verificando intervalo valido
            if (y < a * a || y > b * b){
                System.out.println("O valor y não foi encontrada na busca, pois não está no intervalo de " + a + " e " + b + ".");
            } else {
                resultado = encontraRaiz(a, b, y);
                System.out.println("A raiz quadrada aproximada de " + y + " é: " + resultado);
            }
        }
    }
}