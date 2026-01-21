package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();

        System.out.println("Coloque o endereço do arquivo: ");
        String endereco = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(endereco))) {

            String linha = br.readLine();
            while (linha != null) {
                String[] fields = linha.split(",");
                String nome = fields[0];
                Integer voto= Integer.valueOf(fields[1]);
                map.put(nome, map.getOrDefault(nome, 0) + voto);
                linha = br.readLine();
            }
            System.out.println("O endereço do arquivo foi: " + endereco);
            for(String nome: map.keySet()) {
                System.out.println(nome + ": " + map.get(nome));

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
