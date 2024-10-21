package objetos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaReservas {
	
	static List<Reservas> listaReservas;
	static Scanner scan = new Scanner(System.in);
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	
	public ListaReservas() {
		listaReservas = new ArrayList<Reservas>();
	}
	
	public void adicionarReserva() {
		System.out.println("Digite o nome do hospede:");
		String buscaHospede = scan.nextLine();
		Hospedes hospede = ListaHospedes.buscarHospede(buscaHospede);
		if(hospede == null) {
			return;
		}
		System.out.println("Digite a data da reserva (dd/mm/aaaa):");
		String stringData = scan.next();
		LocalDate data;
	    try {
	        data = LocalDate.parse(stringData, formato);
	    } catch (DateTimeParseException e) {
	        System.out.println("Data invalida, use o formato correto (dd/mm/aaaa).");
	        return;
	    }
		List<Quartos> quartos = new ArrayList<>();
		System.out.println("Digite o tempo da estadia:");
		int tempo = scan.nextInt();
		double valor = 0;
		boolean selecionarQuarto = true;
		while(selecionarQuarto) {
			System.out.println("Digite o numero do quarto (digite '0' para encerrar):");
			int buscaQuarto = scan.nextInt();
			if(buscaQuarto == 0) {
				selecionarQuarto = false;
			} else {
				Quartos quarto = ListaQuartos.buscarQuarto(buscaQuarto);
				if(quarto == null) {
					System.out.println("Quarto nao localizado.");
				} else if(!quarto.isDisponibilidade()) {
					System.out.println("Quarto indisponivel!");
				} else {
					quarto.setDisponibilidade(false);
					quartos.add(quarto);
					valor += quarto.getPreco() * tempo;
				}
			}
		}
		if (quartos.isEmpty()) {
	        System.out.println("Nenhum quarto foi selecionado. Reserva nao realizada.");
	        return;
	    }
		LocalDate dataSaida = data.plusDays(tempo);
		boolean ativo = true;
		Reservas reserva = new Reservas(hospede, data, quartos, tempo, valor, dataSaida, ativo);
		listaReservas.add(reserva);
		System.out.println("Reserva cadastrada com sucesso!\n");
		return;
	}
	
//	boolean selecionarQuarto = true;
//	while(selecionarQuarto) {
//		System.out.println("Digite o numero do quarto (digite '0' para encerrar):");
//		int buscaQuarto = scan.nextInt();
//		if(buscaQuarto == 0) {
//			selecionarQuarto = false;
//		} else {
//			Quartos quarto = ListaQuartos.buscarQuarto(buscaQuarto);
//			if(quarto == null) {
//				System.out.println("Quarto nao localizado.");
//			} else if(!quarto.isDisponibilidade()) {
//				System.out.println("Quarto indisponivel!");
//			} else {
//				quarto.setDisponibilidade(false);
//				reserva.adicionarQuarto(quarto);
//				reserva.setValor(reserva.getValor() + (quarto.getPreco() * reserva.getTempo()));
//			}
//		}
//	}
	
	public void checkOut() {
		if (listaReservas.isEmpty()) {
			System.out.println("Nao ha reservas cadastradas.");
			return;
		} else {
			System.out.println("Digite o nome do hospede:");
			String buscaHospede = scan.nextLine();
			for (Reservas reserva : listaReservas) {
				if (buscaHospede.equalsIgnoreCase(reserva.getHospede().getNome())) {
					for(Quartos quarto : reserva.getQuartos()) {
						quarto.setDisponibilidade(true);
						reserva.setAtivo(false);
						
					}
					System.out.println("Checkout feito com sucesso!\n");
					return;
				}
			}
			System.out.println("Nao ha reservas cadastradas para o hospede informado.\n");
			return;
		}
	}
	
	public void removerReserva() {
		if (listaReservas.isEmpty()) {
			System.out.println("Nao ha reservas cadastradas.");
			return;
		} else {
			System.out.println("Digite o nome do hospede:");
			String buscaHospede = scan.nextLine();
			for (Reservas reserva : listaReservas) {
				if (buscaHospede.equalsIgnoreCase(reserva.getHospede().getNome())) {
					listaReservas.remove(reserva);
					System.out.println("Reserva removida com sucesso!\n");
					return;
				}
			}
			System.out.println("Nao ha reservas cadastradas para o hospede informado.\n");
			return;
		}
	}
	
	public void buscarReserva( ) {
		if (listaReservas.isEmpty()) {
			System.out.println("Nao ha reservas cadastradas.");
			return;
		} else {
			System.out.println("Digite o nome do hospede:");
			scan.nextLine();
			String buscaHospede = scan.nextLine();
			for (Reservas reserva : listaReservas) {
				if (buscaHospede.equalsIgnoreCase(reserva.getHospede().getNome())) {
					System.out.println(reserva.toString());
					return;
				}
			}
			System.out.println("Nao ha reservas cadastradas para o hospede informado.\n");
			return;
		}
	}
	
}