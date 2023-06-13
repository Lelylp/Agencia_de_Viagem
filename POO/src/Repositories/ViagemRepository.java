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
//CRUD OK