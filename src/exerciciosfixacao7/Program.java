package exerciciosfixacao7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Funcionario;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<>();

		System.out.println("Quantos empregados serão registados?");
		int qtdFuncionario = sc.nextInt();

		for (int i = 0; i < qtdFuncionario; i++) {
			System.out.println();
			System.out.println("Employee #" + (i + 1) + ":");
			System.out.print("ID:");
			Integer id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			Funcionario fun = new Funcionario(id, name, salary);
			list.add(fun);

		}

		System.out.println("COLOQUE O ID DO FUNCIONARIO QUE TERA SEU SALARIO AUMENTADO : ");
		Integer sAumento = sc.nextInt();
		Integer pos = position(list, sAumento); //POSITION É DA CLASSE FEITA EMBAIXO DE TODO O PROGRAMA
		

		if (pos == -1) {

			System.out.println("This id does not exist!");

		} else {
			System.out.println("enter the percentage:");
			double percent = sc.nextDouble();
			// TRAZER A LISTA COM O NUMERO Q CONTEM NA VARIAVEL POS 
			// INSTANCIOU AQELA CLASSE INTEIRA E EXECUTAR DENTRO DELA O INCREASY SALARY
			list.get(pos).increaseSalary(percent);

		}

		System.out.println();
		System.out.println("List of employees:");

		for (Funcionario fun : list) { //COMANDO RESPONSAVEL POR LISTAR A LISTA OBVIAMENTE
			System.out.println(fun.toString());
		}

		sc.close();

	}

	// COMO SABER SE EXISTE ALGUEM COM UM CERTO ID APENAS PESQUISANDO COM O ID
	// FIZ UMA CLASSE COM O NOME POSITION, VOU TERQ ENVIAR PARA ELE UMA LISTA
	// DO TIPO FUNCIONARIO QUE VAI SE CHAMAR LIST, E UM INT ID
	public static Integer position(List<Funcionario> list, int id) {
		// RECEBIDO A LISTA E A ID, TEMOS DE FAZER O TESTE PRA VER SE EXISTE:
		for (int i = 0; i < list.size(); i++) {
			// PERCORRE A LISTA COM UM COMANDO DENTRO DO {}

			if (list.get(i).getId() == id) {
				// O COMANDO É QUE LIST.GET É PRA TRAZER ALGO DE DENTRO DA LISTA,
				// OQ FICA ENTRE () É DE QUAL ELEMENTRO DA LISTA E O .getId É OQ ELE VAI TRAZER
				// DESSA LISTA
				// SE FOR IGUAL AO ID Q EU SOLICITEI DESSA CLASSE LA EM CIMA, QUER DIZER Q
				// EXISTE,
				// EAI ELE RETORNA O NUMERO DESSA LISTA

				return i;
			}

		}
		return -1;

	}

}
