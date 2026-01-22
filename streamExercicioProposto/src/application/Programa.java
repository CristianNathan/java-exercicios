package application;

import entities.fucionarios;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o endereço do arquivo: ");
        String arquivo = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            List<fucionarios> lista = new ArrayList<>();

            String linha = br.readLine();
            while (linha != null) {
                String[] sep = linha.split(",");
                lista.add(new fucionarios(sep[0],sep[1],Double.parseDouble(sep[2])));
                linha = br.readLine();
            }
            System.out.println("Digite um salario: ");
            double slr = sc.nextDouble();
            System.out.println("Emails de pessoas que tem o salario maior que "+slr);
            List<String> emails = lista.stream().filter(f->f.getSalario()>slr).map(f->f.getEmail()).sorted().collect(Collectors.toList());
            emails.forEach(System.out::println);

            double soma = 0.0;
            for (fucionarios f : lista) {
                if(f.getNome().charAt(0)=='M'){
                    soma = soma + f.getSalario();
                }
            }
            System.out.println("A soma dos salarios das pessoas que começam com a letra 'M' : "+soma );
        }
        catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());

        }

    }

}
