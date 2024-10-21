package objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaHospedes {
	
	static List<Hospedes> listaHospedes;
	static Scanner scan = new Scanner(System.in);

	public ListaHospedes() {
		listaHospedes = new ArrayList<Hospedes>();
	}
	
	public void adicionarHospede() {
		System.out.println("Digite o nome do hospede:");
		String nome = scan.nextLine();
		Hospedes hospede = new Hospedes(nome);
		listaHospedes.add(hospede);
		System.out.println("Novo hospede cadastrado com sucesso!\n");
		return;
	}
	
	public void removerHospede() {
		if(listaHospedes.isEmpty()) {
			System.out.println("Nao ha hospedes cadastrados.\n");
		} else {
			System.out.println("Digite o nome do hospede:");
			String buscaHospede = scan.nextLine();
			for(Hospedes hospede : listaHospedes) {
				if(buscaHospede.equalsIgnoreCase(hospede.getNome())) {
					listaHospedes.remove(hospede);
					System.out.println("Hospede removido com sucesso!\n");
					return;
				}
			}
		}
		return;
	}
	
	public void listarHospedes() {
		if(listaHospedes.isEmpty()) {
			System.out.println("Nao ha hospedes cadastrados.\n");
		} else {
			for(Hospedes hospede : listaHospedes) {
				System.out.println(hospede.toString());
			}
		}
		return;
	}
	
	public static Hospedes buscarHospede(String buscaHospede) {
		if(listaHospedes.isEmpty()) {
			System.out.println("Nao ha hospedes cadastrados.\n");
		} else {
			for(Hospedes hospede : listaHospedes) {
				if(buscaHospede.equalsIgnoreCase(hospede.getNome())) {
					return hospede;
				}
			}
		}
		return null;
	}
	
	public void informacoes1() {
		String nome = "Joao da Silva";
		Hospedes hospede = new Hospedes(nome);
		listaHospedes.add(hospede);
		return;
	}
	
	public void informacoes2() {
		String nome = "Joaquim dos Santos";
		Hospedes hospede = new Hospedes(nome);
		listaHospedes.add(hospede);
		return;
	}
	
}