/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author silvestre
 */
public class Arquivo {
    public static void main(String[] args){
        escreverArquivo();
        lerArquivo();
    }
    public static void escreverArquivo(){
        String conteudo = "Hello, World!";
        Path caminho = Path.of("arquivo.txt");
       try {
           Files.writeString(caminho, conteudo);
           System.out.println("Arquivo criado com sucesso!");
       }
       catch (IOException e){
           System.err.println("Erro ao escrever no arqivo: " + e.getMessage());
       }
    }

    public static void lerArquivo(){
        String nomeArquivo = "arquivo.txt";
        LinkedList<String> linhasDoArquivo = new LinkedList<>();

        System.out.println("Conteudo do arquivo lido na Linha");

        for (String linha : linhasDoArquivo){
            System.out.println(linha);
        }

        System.out.println("Total de linhas: " + linhasDoArquivo.size());

        try{
            List<String> linhasLidas = Files.readAllLines(Paths.get(nomeArquivo));
            linhasDoArquivo.addAll(linhasLidas);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
