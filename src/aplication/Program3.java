package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Funcionario;

public class Program3 {

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
			
			while(hasId(list,id)) { //EM QUANTO O ID QUE DIGITEI EXISTIR NA LISTA
				//NAO PODE, TEMQ VOLTAR E DEFINIR O ID DENOVO
				//LEMBRANDO Q WHILE FUNCIONA COM TRUE E PARA COM FALSE
				//E A VARIAVEL HASID BOOLEANA RETORNA COM TRUE E COM FALSE
			
			System.out.println("ID JA EXISTE, TENTE NOVAMENTE");
				id = sc.nextInt(); //LE DENOVO O ID
			
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			Funcionario fun = new Funcionario(id, name, salary);
			list.add(fun);

		}

		System.out.println("COLOQUE O ID DO FUNCIONARIO QUE TERA SEU SALARIO AUMENTADO :");
		Integer faumento = sc.nextInt();
		Funcionario fun = list.stream().filter(x -> x.getId() == faumento).findFirst().orElse(null);
		//AQUI USAMOS A LAMBDA, LISTA VIRA STREAM, FILTRA COM GETID EM CIMA DE CADA LISTA
		//E ME TRAZ UM RESULTADO ESPECIFICO CASO SEJA POSITIVO
		System.out.println("ENTER PERCENTAGE:");
		Double sAumento = sc.nextDouble();
		
		if (fun == null) { // O TESTE PARA AUMENTAR CASO EXISTE
		System.out.println("THIS ID DOES NOT EXISTE");
		}
		
		else {
		fun.increaseSalary(sAumento); // CHAMANDO A FUNÇÃO
		}
		
		System.out.println();
		System.out.println("List of employees:");
		
		for (Funcionario e : list) { //PARA CADA ELEMENTO DENTRO DA LISTA  ARMAZENDO NO E

			System.out.println(e.toString());//EXIBA E
		}

		sc.close();

	}
	
	public static boolean hasId(List<Funcionario> list, int fAumento) { //VARIAVEL Q RETORNA APENAS TRUE OR FALSE
		
		
		Funcionario fun = list.stream().filter(x -> x.getId() == fAumento).findFirst().orElse(null); // O TESTE
		return fun != null; //SE FOR DIFERENTE DE NULO ELE RETORNA TRUE, SENAO FALSE DENTRO DE HASID
		
	}

}



	
