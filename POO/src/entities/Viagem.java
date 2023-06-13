package entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Enum.Lugar;

public class Viagem {
	private LocalDate data;
    private double valor;
    private Lugar lugar;
    private Integer id;
    private List<DetalheDaViagem> detalhes;
    
    public Viagem(double valor, Lugar lugar, LocalDate data) {
    	this.id = 0;
		this.setData(data);
		this.valor = valor;
		this.lugar = lugar;
		this.setDetalhes(new ArrayList<DetalheDaViagem>());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
		this.data = data;
	}

	public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public List<DetalheDaViagem> getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(List<DetalheDaViagem> detalhes) {
		this.detalhes = detalhes;
	}
	//falta coisas
}
