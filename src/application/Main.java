package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.TaxPayer;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos contribuentes voce vai digitar ? ");
		int n = sc.nextInt();

		List<TaxPayer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.println("Digite os dados do " + (i + 1) + "o contribuinte: ");
			System.out.print("Renda anual com salario: ");
			double salario = sc.nextDouble();
			System.out.print("Renda anual com prestacao de servicos: ");
			double servicos = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capital = sc.nextDouble();
			System.out.print("Gastos medicos: ");
			double gMedicos = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double gEducacionais = sc.nextDouble();
			list.add(new TaxPayer(salario, servicos, capital, gMedicos, gEducacionais));
			System.out.println();
		}

		for (TaxPayer x : list) {
				System.out.println("Resumo do " + (list.indexOf(x) + 1) + "o contribuinte: ");
				System.out.printf("Imposto bruto total: " + String.format("%.2f %n", x.grossTax()));
				System.out.printf("Abatimento: " + String.format("%.2f %n", x.taxRebate()));
				System.out.printf("Imposto devido: " + String.format("%.2f %n", x.netTax()));
				System.out.println();
		}

		sc.close();
	}
}