package objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaQuartos {
	
	static List<Quartos> listaQuartos;
	static Scanner scan = new Scanner(System.in);
	
	public ListaQuartos() {
		listaQuartos = new ArrayList<Quartos>();
	}
	
	public void adicionarQuarto() {
		System.out.println("Digite o numero do quarto:");
		int numeroQuarto = scan.nextInt();
		System.out.println("Digite o tipo do quarto:");
		String tipoQuarto = scan.next();
		System.out.println("Digite o preco do quarto:");
		double preco = scan.nextDouble();
		boolean disponibilidade = true;
		Quartos quarto = new Quartos(numeroQuarto, tipoQuarto, preco, disponibilidade);
		listaQuartos.add(quarto);
		System.out.println("Quarto adicionado com sucesso!\n");
		return;
	}
	
	public void removerQuarto() {
		if(listaQuartos.isEmpty()) {
			System.out.println("Nao ha quartos cadastrados.");
		} else {
			System.out.println("Digite o numero do quarto:");
			int buscaQuarto = scan.nextInt();
			for(Quartos quarto : listaQuartos) {
				if(buscaQuarto == quarto.getNumeroQuarto()) {
					listaQuartos.remove(quarto);
					System.out.println("Quarto removido com sucesso!\n");
					return;
				}
			}
		}
		return;
	}
	
	public void listarQuartos() {
		if(listaQuartos.isEmpty()) {
			System.out.println("Nao ha quartos cadastrados.");
		} else {
			for(Quartos quarto : listaQuartos) {
				System.out.println(quarto.toString());
			}
		}
		return;
	}
	
	public static Quartos buscarQuarto(int buscaQuarto) {
		if(listaQuartos.isEmpty()) {
			System.out.println("Nao ha quartos cadastrados.\n");
		} else {
			for(Quartos quarto : listaQuartos) {
				if(buscaQuarto == (quarto.getNumeroQuarto())) {
					return quarto;
				}
			}
		}
		return null;
	}
	
	public void informacoes1() {
		int numeroQuarto = 100;
		String tipoQuarto = "Simples";
		double preco = 150.00;
		boolean disponibilidade = true;
		Quartos quarto = new Quartos(numeroQuarto, tipoQuarto, preco, disponibilidade);
		listaQuartos.add(quarto);
		return;
	}
	
	public void informacoes2() {
		int numeroQuarto = 200;
		String tipoQuarto = "Duplo";
		double preco = 250.00;
		boolean disponibilidade = true;
		Quartos quarto = new Quartos(numeroQuarto, tipoQuarto, preco, disponibilidade);
		listaQuartos.add(quarto);
		return;
	}
	
}