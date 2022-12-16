package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Informe o nome do departamento: ");
		String departamento = scan.nextLine();
		System.out.println("\nDados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = scan.nextLine();
		System.out.print("Nível do trabalhador: ");
		String nivelTrabalhador = scan.nextLine();
		System.out.print("Informe o salário-base do trabalhador: R$ ");
		double salarioBase = scan.nextDouble();
		
		//Instanciando a classe Trabalhador
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, salarioBase, NivelTrabalhador.valueOf(nivelTrabalhador), new Departamento(departamento));
		
		System.out.println();
		System.out.print("Quantos contratos do trabalhador? ");
		int n = scan.nextInt();
		
		for(int i =1; i <= n; i++) {
			System.out.println("\nDados do " + i + "º contrato: ");
			System.out.print("Informe a data no formato dd/MM/yyyy: ");
			Date dataContrato = sdf.parse(scan.next());
			System.out.print("Valor por hora: R$ ");
			double valorHora = scan.nextDouble();
			System.out.print("Duração: ");
			int horas = scan.nextInt();
			
			HoraContrato contrato = new HoraContrato(dataContrato, valorHora , horas);
			trabalhador.adicionarContrato(contrato);
		}
		System.out.println();
		System.out.print("Informe o mês e ano para calcular os ganhos MM/yyyy: ");
		String mesAno = scan.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Ganhos para " + mesAno + ": " + String.format("%.2f", trabalhador.ganhos(ano, mes)));
		
		scan.close();
	}

}
