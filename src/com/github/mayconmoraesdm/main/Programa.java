package com.github.mayconmoraesdm.main;

import com.github.mayconmoraesdm.classes.FileIO;
import com.github.mayconmoraesdm.classes.Pessoa;

import java.io.IOException;
import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {
//        Pessoa p1 = new Pessoa("maycon", "maycon@email.com");
//        Pessoa p2 = new Pessoa("joao", "joao@email.com");
//        Pessoa p3 = new Pessoa("maria", "maria@email.com");
//
//        ArrayList<Pessoa> listPessoas = new ArrayList<>();
//        listPessoas.add(p1);
//        listPessoas.add(p2);
//        listPessoas.add(p3);
//
//        try {
//            FileIO.writer(listPessoas, "teste.csv");
//            System.out.println("Arquivo gerado com sucesso!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {
            ArrayList<Pessoa> pessoas = FileIO.reader("teste.csv");
            pessoas.forEach(pessoa -> {
                System.out.println(String.format("Nome: %s e Email: %s \n", pessoa.getNome(), pessoa.getEmail()));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
