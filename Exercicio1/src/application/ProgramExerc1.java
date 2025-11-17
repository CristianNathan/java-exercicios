package application;

import entities.Cliente;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class ProgramExerc1 {
	public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite os dados do Cliente: ");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.next();
        System.out.println("Data de Nascimento (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        Cliente cliente = new Cliente(nome,email, birthDate);

        System.out.println("Digite os dados do cliente: ");
        System.out.println("Status:");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        Order order = new Order(new Date(),status,cliente);
        System.out.println("Quantos item o pedido vai ter? ");
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            System.out.println("Dados do #"+(i+1)+" item:");
            System.out.println("Nome do produto:");
            String productNome = sc.next();
            System.out.println("Preço do produto: ");
            double productPreco = sc.nextDouble();
            System.out.println("Quantos item o pedido vai ter? ");
            int quantity = sc.nextInt();
            Product product = new Product(productNome, productPreco);

            OrderItem it = new OrderItem(quantity,productPreco,product);
            order.addItem(it);


        }
        System.out.println();
        System.out.println(order);

    }
}
