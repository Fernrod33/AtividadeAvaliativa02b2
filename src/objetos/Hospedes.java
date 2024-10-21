package objetos;

public class Hospedes {
	
	private String nome;
	
	public Hospedes() {
		
	}
	
	public Hospedes(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Hospede [Nome=" + nome + "]";
	}

}