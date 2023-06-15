package entities;

import Enum.TipoPassagem;

public class Passagem {
	private Integer id;
	private String destino;
	private String data;
	private String horario;
	private double valor;
	private String origem;
    private String localEmbarque;
    private TipoPassagem tipoPassagem;
    private String empresa;
    private String assento;

    public Passagem (String assento) {
    	this.assento = assento;
    }
    
	public Passagem(Integer id, String destino, String data, String horario, double valor, String origem, String localEmbarque,
					TipoPassagem tipoPassagem, String empresa, String assento) {
		this.id = id;
		this.destino = destino;
		this.data = data;
		this.horario = horario;
		this.valor = valor;
		this.origem = origem;
		this.localEmbarque = localEmbarque;
		this.tipoPassagem = tipoPassagem;
		this.empresa = empresa;
		this.assento = assento;
	}
	

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getLocalEmbarque() {
		return localEmbarque;
	}

	public void setLocalEmbarque(String localEmbarque) {
		this.localEmbarque = localEmbarque;
	}

	public TipoPassagem getTipoPassagem() {
		return tipoPassagem;
	}

	public void setTipoPassagem(TipoPassagem tipoPassagem) {
		this.tipoPassagem = tipoPassagem;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getAssento() {
		return assento;
	}

	public void setAssento(String assento) {
		this.assento = assento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
