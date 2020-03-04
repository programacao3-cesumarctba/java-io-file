package com.github.mayconmoraesdm.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileIO {

    public static void writer(List<Pessoa> pessoas, String nomeArquivo) throws IOException {
        // BufferedWritter (escreve) --> FileWritter (aponta para o arquivo no hd)
        FileWriter fileWriter = new FileWriter(nomeArquivo);
        // try with resources
        try (BufferedWriter writer = new BufferedWriter(fileWriter)){
            // forma uma lista de string linha a linha para salvar no arquivo
            List<String> dados = pessoas.stream().map(pessoa -> String.format("%s;%s\n", pessoa.getNome(), pessoa.getEmail())).collect(Collectors.toList());
            // intera linha a linha
            for (String linha : dados) {
                writer.write(linha);
            }
        }
    }

    public static ArrayList<Pessoa> reader(String nomeArquivo) throws IOException {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        FileReader fileReader = new FileReader(nomeArquivo);
        try (BufferedReader reader = new BufferedReader(fileReader)){
            String dado = "";
            while ((dado = reader.readLine()) != null) {
                String[] linha = dado.split(";");
                Pessoa p = new Pessoa(linha[0], linha[1]);
                pessoas.add(p);
            }
        }
        return pessoas;
    }
}
