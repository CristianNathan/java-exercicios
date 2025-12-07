package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        System.out.print("Quantos empregados? ");
        int n = sc.nextInt();
        for(int i = 1; i <=n; i++){
            System.out.println("Dados do empregado #"+i);
            System.out.println("Fucionario é tercerizado? (s/n)");
            char ch = sc.next().charAt(0);
            System.out.println("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.println("Quantidade de horas: ");
            int horas = sc.nextInt();
            System.out.println("Valor por hora: ");
            double valorHora = sc.nextDouble();
            if(ch == 's'){
                System.out.println("Adiciona a taxa adicional: ");
                double taxa = sc.nextDouble();
                Employee emp = new OutsourcedEmployee(nome, horas, valorHora, taxa);
                employees.add(emp);
            }else{
                Employee emp = new Employee(nome, horas, valorHora);
                employees.add(emp);
            }
        }
        System.out.println();
        System.out.println("Pagamentos");
        for(Employee emp : employees){
            System.out.println(emp.getNome()+ " -$ "+ String.format("%.2f",emp.payment()));
        }

    }

}

