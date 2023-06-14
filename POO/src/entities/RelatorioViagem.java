package entities;

public class RelatorioViagem {
	private Integer id;
	private int mes;
    private String destino;
    private int numeroViagens;

    public RelatorioViagem(int mes, String destino, int numeroViagens) {
		this.id = 0;
		this.mes = mes;
		this.destino = destino;
		this.numeroViagens = numeroViagens;
	}

	public RelatorioViagem(int mes) {
		this.mes = mes;
	}

	public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getNumeroViagens() {
        return numeroViagens;
    }

    public void setNumeroViagens(int numeroViagens) {
        this.numeroViagens = numeroViagens;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
}
//fazer super para relatorio de usuario/empresa