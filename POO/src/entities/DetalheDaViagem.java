package entities;
import java.util.Objects;

public class DetalheDaViagem {
	private Integer id;
	private int quantPessoas;
	private boolean seguro;
	private String destino;
	private String origem;
	private boolean disponivel;
	
	public DetalheDaViagem() {
		
	}
	
	public DetalheDaViagem(Integer id) {
		this.id = id;
		this.quantPessoas = 0;
		this.seguro = false;
		this.destino = null;
		this.origem = null;
		this.disponivel = false;
	}
	
	public DetalheDaViagem(Integer id, int quantPessoas, boolean seguro, String destino, String origem, boolean disponivel) {
		this.id = id;
		this.quantPessoas = quantPessoas;
		this.seguro = seguro;
		this.destino = destino;
		this.origem = origem;
		this.disponivel = disponivel;
	}
	
	public Integer getId() {
		return id;
	}

	public DetalheDaViagem setId(Integer id) {
		this.id = id;
		return this;
	}

	public int getQuantPessoas() {
		return quantPessoas;
	}

	public void setQuantPessoas(int quantPessoas) {
		this.quantPessoas = quantPessoas;
	}

	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalheDaViagem other = (DetalheDaViagem) obj;
		return Objects.equals(id, other.id);
	}
	
	public DetalheDaViagem clone() {
		DetalheDaViagem detalheDaViagem = new DetalheDaViagem();
		detalheDaViagem.setId(this.getId());
		detalheDaViagem.setDestino(this.getDestino());
		detalheDaViagem.setDisponivel(this.isDisponivel());
		detalheDaViagem.setOrigem(this.getOrigem());
		detalheDaViagem.setQuantPessoas(this.getQuantPessoas());
		detalheDaViagem.setSeguro(this.isSeguro());
		return detalheDaViagem;
	}

	public String toString() {
		return "DetalheDaViagem ID: " 
				+ id 
				+ ", Quantidade de Pessoas: " 
				+ quantPessoas 
				+ ", Seguro: " 
				+ seguro 
				+ ", Destino: "
				+ destino
				+ ", Origem: " 
				+ origem 
				+ ", Disponibilidade: " 
				+ disponivel;
	}
	
	}
