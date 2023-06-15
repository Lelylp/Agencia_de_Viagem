package Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entities.DetalheDaViagem;

public class DetalheDaViagemRepository implements GenericRepository<DetalheDaViagem> {

	private static DetalheDaViagemRepository instance = null;
	private HashMap<Integer, DetalheDaViagem> detalheDaViagem = null;
	private static Integer idDoPacote = 1;
	
	private DetalheDaViagemRepository() {
		detalheDaViagem = new HashMap<Integer, DetalheDaViagem>();
	}
	
	public static DetalheDaViagemRepository getInstance() {
		
		if (instance == null) {
			instance = new DetalheDaViagemRepository();
		}			
		return instance;
	}

	@Override
	public DetalheDaViagem inserir(DetalheDaViagem objDDViagem) {
		objDDViagem.setId(idDoPacote++);
		try {
			detalheDaViagem.put(objDDViagem.getId(), objDDViagem);
			return objDDViagem;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public DetalheDaViagem alterar(DetalheDaViagem objDDViagem) {
		DetalheDaViagem autentico = detalheDaViagem.get(objDDViagem.getId());		
		try {
			detalheDaViagem.put(objDDViagem.getId(), objDDViagem);
			return autentico;
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public DetalheDaViagem excluir(DetalheDaViagem objDDViagem) {
		DetalheDaViagem autentico = detalheDaViagem.get(objDDViagem.getId()).clone();		
		try {
			detalheDaViagem.remove(objDDViagem.getId());
			return autentico;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<DetalheDaViagem> listar() {
		List<DetalheDaViagem> listaDosDetalhesDaViagem = new ArrayList<DetalheDaViagem>();
		for (DetalheDaViagem d: detalheDaViagem.values()) {
			listaDosDetalhesDaViagem.add(d);
		}
		return listaDosDetalhesDaViagem;
	}
	
	public List<DetalheDaViagem> consultar(DetalheDaViagem t) {
		List<DetalheDaViagem> lista = new ArrayList<DetalheDaViagem>();
		lista.add(detalheDaViagem.get(t.getId()));
		return lista;
	}
	
	public List<DetalheDaViagem> verSeExiste(DetalheDaViagem objDDViagem) {
		List<DetalheDaViagem> listaDosDetalhesDaViagem = new ArrayList<DetalheDaViagem>();
		listaDosDetalhesDaViagem.add(detalheDaViagem.get(objDDViagem.getId()));
		return listaDosDetalhesDaViagem;
	}

}