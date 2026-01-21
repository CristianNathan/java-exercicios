package application;

import entities.Usuario;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Usuario> set = new HashSet<Usuario>();
        System.out.println("Quantos estudantes fazem parte do curso A?");
        int nA = sc.nextInt();
        for (int i = 1; i <= nA; i++) {
            int id = sc.nextInt();
            set.add(new Usuario(id));
        }
            System.out.println("Quantos estudantes fazem parte do curso B?");
        int nB = sc.nextInt();
        for (int i = 1; i <= nB; i++) {
            int id = sc.nextInt();
            set.add(new Usuario(id));

        }
            System.out.println("Quantos estudantes fazem parte do curso C?");
        int nC = sc.nextInt();
        for (int i = 1; i <= nC; i++) {
            int id = sc.nextInt();
            set.add(new Usuario(id));

        }
        System.out.println("Total de estudantes: "+ set.size());

    }
}
