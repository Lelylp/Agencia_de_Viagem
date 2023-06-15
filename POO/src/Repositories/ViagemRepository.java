package Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entities.Viagem;

public class ViagemRepository implements GenericRepository<Viagem>{
    
    private static ViagemRepository instance;
	private HashMap<Integer, Viagem> viagens = null;
	private static Integer id = 1;
	
	private ViagemRepository() {
		viagens = new HashMap<Integer, Viagem>();
	}
	
	public static ViagemRepository getInstance() {
		if (instance == null) {
			instance = new ViagemRepository();
		}
		return instance;
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
	        if (autentico != null) {
	            autentico.setValor(viagem.getValor());
	            return autentico;
	        } else {
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
	public List<Viagem> listar() {
		List<Viagem> lista = new ArrayList<Viagem>();
		for (Viagem v: viagens.values()) {
			lista.add(v);
		}
		return lista;
	}

	public List<Viagem> consultar(Viagem viagemConsulta) {
	    List<Viagem> resultado = new ArrayList<>();

	    for (Viagem viagem : viagens.values()) {
	        if (viagem.getLugar().equals(viagemConsulta.getLugar()) &&
	            viagem.getValor() == viagemConsulta.getValor() &&
	            viagem.getData().equals(viagemConsulta.getData())) {
	            resultado.add(viagem);
	        }
	    }

	    return resultado;
	}

}

//CRUD OK 