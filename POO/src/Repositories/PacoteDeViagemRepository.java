package Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import entities.Viagem;

public class PacoteDeViagemRepository implements GenericRepository<Viagem>{
    private List<Viagem> Viagem;
    
    private static PacoteDeViagemRepository instance;
	private HashMap<Integer, Viagem> viagens = null;
	private static Integer id = 1;
	
	private PacoteDeViagemRepository() {
		viagens = new HashMap<Integer, Viagem>();
	}
	
	public static PacoteDeViagemRepository getInstance() {
		if (instance == null) {
			instance = new PacoteDeViagemRepository();
		}
		return instance;
	}

    public void adicionarPacoteDeViagem(Viagem pacoteDeViagem) {
    	Viagem.add(pacoteDeViagem);
    }

    public List<Viagem> obterTodosOsPacotesDeViagem() {
        return Viagem;
    }

    public List<Viagem> buscarPorDestino(String destino) {
        List<Viagem> pacotesEncontrados = new ArrayList<>();
        for (Viagem pacote : Viagem) {
            if (pacote.getDetalhes().equals(destino)) {
                pacotesEncontrados.add(pacote);
            }
        }
        return pacotesEncontrados;
    }

    public List<Viagem> buscarPorPrecoMaximo(double precoMaximo) {
        List<Viagem> pacotesEncontrados = new ArrayList<>();
        for (Viagem pacote : Viagem) {
            if (pacote.getValor() <= precoMaximo) {
                pacotesEncontrados.add(pacote);
            }
        }
        return pacotesEncontrados;
    }

	@Override
	public Viagem inserir(Viagem viagem) {
		viagem.setId(id++);
		try {
			viagens.put(viagem.getId(), viagem);
			return viagem;
		}catch (Exception E) {
			return null;
		}		
	}

	@Override
	public Viagem alterar(Viagem viagem) {
		Viagem autentico = viagens.get(viagem.getId());
		try {
			viagens.put(viagem.getId(), viagem);
			return autentico;
		}catch (Exception E) {
			return null;
		}
	}

	@Override
	public Viagem excluir(Viagem viagem) {
		Viagem autentico = viagens.get(viagem.getId());
		try {
			viagens.remove(viagem.getId());
			return autentico;
		}catch (Exception E) {
			return null;
		}
	}

	@Override
	public List<Viagem> consultar(Viagem viagem) {
		List<Viagem> lista = new ArrayList<Viagem>();
		lista.add(viagens.get(viagem.getId()));
		return lista;
	}
}
