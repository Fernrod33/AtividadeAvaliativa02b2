package sistema;

import java.util.Scanner;

import objetos.ListaHospedes;
import objetos.ListaQuartos;
import objetos.ListaReservas;

public class Hotel {
	
	static Scanner scan = new Scanner(System.in);
	static ListaHospedes novaListaHospedes = new ListaHospedes();
	static ListaQuartos novaListaQuartos = new ListaQuartos();
	static ListaReservas novaListaReservas = new ListaReservas();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bem vindo ao sistema!");
		novaListaHospedes.informacoes1();
		novaListaHospedes.informacoes2();
		novaListaQuartos.informacoes1();
		novaListaQuartos.informacoes2();
		executar();
	}
	
	static void executar() {
		boolean continuar = true;
		while(continuar ) {
			exibirMenuPrincipal();
			int escolha = scan.nextInt();
			switch(escolha) {
				case 1: {
					exibirMenuHospedes();
					escolha = scan.nextInt();
					if(escolha == 1) {
						novaListaHospedes.adicionarHospede();
						break;
					} else if(escolha == 2)	{
						novaListaHospedes.removerHospede();
						break;
					} else if(escolha == 3) {
						novaListaHospedes.listarHospedes();
						break;
					} else {
						System.out.println("Escolha incorreta.");
						break;
					}
				}
				case 2: {
					exibirMenuQuartos();
					escolha = scan.nextInt();
					if(escolha == 1) {
						novaListaQuartos.adicionarQuarto();
						break;
					} else if(escolha == 2) {
						novaListaQuartos.removerQuarto();
						break;
					} else if(escolha == 3) {
						novaListaQuartos.listarQuartos();
						break;
					}	else {
						System.out.println("Escolha incorreta.");
						break;
					}
				}
				case 3: {
					exibirMenuReservas();
					escolha = scan.nextInt();
					if(escolha == 1) {
						novaListaReservas.adicionarReserva();
						break;
					} else if(escolha == 2) {
						novaListaReservas.removerReserva();
						break;
					} else if(escolha == 3) {
						novaListaReservas.buscarReserva();
						break;
					} else if(escolha == 4) {
						novaListaReservas.checkOut();
						break;
					} else {
						System.out.println("Escolha incorreta.");
						break;
					}
				}
				case 4: {
					continuar = false;
					break;
				}
				default: {
					System.out.println("Opcao incorreta, tente novamente.");
					break;
				}
			}
		}
	}
	
	static void exibirMenuPrincipal() {
		System.out.println("Escolha uma das opcoes:");
		System.out.println("1 - Cadastro de hospedes");
		System.out.println("2 - Cadastro de quartos");
		System.out.println("3 - Cadastro de reservas");
		System.out.println("4 - Sair do sistema");
	}
	
	static void exibirMenuHospedes() {
		System.out.println("Escolha uma das opcoes:");
		System.out.println("1 - Cadastrar hospede");
		System.out.println("2 - Remover hospede");
		System.out.println("3 - Listar hospedes");
	}
	
	static void exibirMenuQuartos() {
		System.out.println("Escolha uma das opcoes:");
		System.out.println("1 - Cadastrar quarto");
		System.out.println("2 - Remover quarto");
		System.out.println("3 - Listar quartos");
	}
	
	static void exibirMenuReservas() {
		System.out.println("Escolha uma das opcoes:");
		System.out.println("1 - Cadastrar reserva");
		System.out.println("2 - Remover reserva");
		System.out.println("3 - Buscar reservas");
		System.out.println("4 - Fazer checkout");
	}
	
}