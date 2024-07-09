package com.mycompany.exercicioquick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicioquick {

    public static void newswap(List<Integer> largura_parafuso, int i, int j) {
        Integer aux = largura_parafuso.get(i);
        largura_parafuso.set(i, largura_parafuso.get(j));
        largura_parafuso.set(j, aux);
    }
    
    //Trabalho Gustavo, o objetivo do trabalho é ultilizar o método de particionamento que é usado no Método "QuickSort", para encontrar o indíce médio de uma lista, quando encontrado ele retorna a posição média. 
    
    public static int calcula_mediana(List<Integer> largura_parafuso, int index_inicial, int tam_list, int mediana){
        
        //Pega o ultimo elemento da lista, que será o pivô
        Integer pivot = largura_parafuso.get(tam_list);
        
        // O index i sempre começa do Index inicial - 1 , quando vai efetuar a troca o i é inclementado em +1
        int i = index_inicial - 1;
        
        //Aqui o j começa a percorrer elemento por elemento da Lista
        for(int j = index_inicial; j <= tam_list; j++) {
            //Quando o elemento do index j é < que o elemento do pivô, é efetuado a troca, o i é inclementado + 1 e assim é efetuado a troca entre o j com o i.
            if (largura_parafuso.get(j) <= pivot) {
                i++;
                //Aqui é efetuado o Swap que seria a troca de posiçoes.
                newswap(largura_parafuso, i, j);
            }
        }
        
        //Aqui pegamos a posição que o pivô foi parar.
        int posicao_pivot = largura_parafuso.indexOf(pivot);
        
        
        //Aqui verificamos se a posição da lista que o pivô ficou é a posição médiana do vetor, se esta comparação for "true" ele retorna a posição que o pivô está na lista.
        if ( posicao_pivot == mediana) {
            return largura_parafuso.indexOf(pivot);
        }else{   
            //Aqui ele verifica se a posição do pivô é > "maior" que a médiana, se for ele descarta toda a lista direita do index do pivô em diante.
            if(posicao_pivot > mediana){
                return calcula_mediana(largura_parafuso, 0, largura_parafuso.indexOf(pivot) - 1, mediana);
                
             //Se a comparação de cima for "false" ele faz o inverso do de cima, ele descarta tudo a esquerda a partir do index da lista em diante.
            }else{
                return calcula_mediana(largura_parafuso, largura_parafuso.indexOf(pivot) + 1, largura_parafuso.size() - 1, mediana);
            }
        }
    }

    //Método partição é ultilizado para fazer o particionamento da lista, ele é usado no método QuickSort
    
    public static int partition(List<Integer> largura_parafuso, int index_inicial, int tam_list) {
        
        Integer pivot = largura_parafuso.get(tam_list);
        
        int i = index_inicial - 1;
        
        for (int j = index_inicial; j < tam_list; j++) {
            if (largura_parafuso.get(j) <= pivot) {
                i++;
                newswap(largura_parafuso, i, j);
            }
        }
        
        
        //Aqui ele sai fora do for e da o SWAP, e neste SWAP está trocando o pivot de lugar.
        
        newswap(largura_parafuso, i + 1, tam_list);
        return i + 1;
    }
    
    //Ordenar a lista ultilizando o método "QuickSort.  "NÃO ESTÁ NA MAIN"
    
    public static void quicksort(List<Integer> largura_parafuso, int index_inicial, int tam_list){
        
        //Verifica se o index_inicial foi passado corretamente.
        if (index_inicial < tam_list) {
            int pivot = partition(largura_parafuso, index_inicial, tam_list);
            
            //Direita menores que o pivot
            quicksort(largura_parafuso, index_inicial, pivot - 1);
            
            //Esquerda maiores que o pivot
            quicksort(largura_parafuso, pivot + 1, tam_list);
        }
    }

    public static void main(String[] args) {
        
        //Listas de Exemplos
        Integer[] listPar = {26, 3, 8, 19, 12, 7, 20, 15, 1, 23, 5, 16, 4, 11, 21, 2, 25, 9, 18, 10, 24, 6, 17, 13, 14, 22};
        Integer[] listImpar = {15, 10, 25, 30, 5, 20, 35, 40, 50, 55, 45, 60, 65};
        List<Integer> largura_parafuso = Arrays.asList(listImpar);
        
        
        
        //Método de ordenação "QuickSort"
        //quicksort(largura_parafuso, 0, largura_parafuso.size() - 1);

        int mediana = 0;
        int mediana_calculada = 0;

        //Aqui verifica se o numero de elementos da lista é impar ou par, pois se for impar deve acrescentar + 1 ao valor e dividir por 2, se for par apenas dividir por 2 que é encontrado o valor da mediana.
        if (largura_parafuso.size() % 2 == 0) {
           mediana = largura_parafuso.size()/2; 
           mediana_calculada = calcula_mediana(largura_parafuso, 0, largura_parafuso.size() - 1, mediana - 1);
           System.out.println(largura_parafuso.get(mediana_calculada));
        }
        else{
            mediana  = (largura_parafuso.size() + 1)/2;
            mediana_calculada = calcula_mediana(largura_parafuso, 0, largura_parafuso.size() - 1, mediana - 1);
            System.out.println(largura_parafuso.get(mediana_calculada));
        }
    }
}