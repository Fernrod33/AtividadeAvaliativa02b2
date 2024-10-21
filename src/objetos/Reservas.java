package objetos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservas {
	
	private Hospedes hospede;
	private LocalDate dataReserva;
	private List<Quartos> quartos;
	private int tempo;
	private double valor;
	private LocalDate dataSaida;
	private boolean ativo;
	
	public Reservas() {
		
	}

	public Reservas(Hospedes hospede, LocalDate dataReserva, List<Quartos> quartos, int tempo, double valor, LocalDate dataSaida, boolean ativo) {
		this.hospede = hospede;
		this.dataReserva = dataReserva;
		this.quartos = quartos != null ? quartos : new ArrayList<>();
		this.tempo = tempo;
		this.valor = valor;
		this.dataSaida = dataSaida;
		this.ativo = ativo;
	}

	public Hospedes getHospede() {
		return hospede;
	}

	public void setHospede(Hospedes hospede) {
		this.hospede = hospede;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public List<Quartos> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quartos> quartos) {
		this.quartos = quartos;
	}
	
	public void adicionarQuarto(Quartos quarto) {
		this.quartos.add(quarto);
	}
	
	public int getTempo() {
		return tempo;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public LocalDate getDataSaida() {
		return dataSaida;
	}
	
	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		if(ativo) {
			return	"Reservas [Hospede:" + hospede + 
					"\nData: " + dataReserva +
					"\nQuartos:\n" + quartos.toString() +
					"\nTempo: " + tempo + " dias\nValor: R$ " + valor + "]";
		} else {
			return	"Reservas [Hospede:" + hospede + 
					"\nData: " + dataReserva +
					"\nCheckout: " + dataSaida +
					"\nQuartos:\n" + quartos.toString() +
					"\nTempo: " + tempo + " dias\nValor: R$ " + valor + "]";
		}
	}
	
}