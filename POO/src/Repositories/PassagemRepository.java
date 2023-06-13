package Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entities.Passagem;

public class PassagemRepository implements GenericRepository<Passagem> {
	
	private static PassagemRepository instance = null;
	private HashMap<Integer, Passagem> passagens = null;
	private static Integer sequence = 1;
	
	private PassagemRepository() {
		passagens = new HashMap<Integer, Passagem>();
	}
	
	public static PassagemRepository getInstance() {
		
		if (instance == null) {
			instance = new PassagemRepository();
		}			
		return instance;
	}
	

	@Override
	public Passagem inserir(Passagem passagem) {
		passagem.setId(sequence++);
		try {
			passagens.put(passagem.getId(), passagem);
			return passagem;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Passagem alterar(Passagem passagem) {
		Passagem autentico = passagens.get(passagem.getId());		
		try {
			passagens.put(passagem.getId(), passagem);
			return autentico;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Passagem excluir(Passagem passagem) {
		Passagem autentico = passagens.get(passagem.getId());		
		try {
			passagens.remove(passagem.getId());
			return autentico;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Passagem> consultar(Passagem passagem) {
		List<Passagem> lista = new ArrayList<Passagem>();
		lista.add(passagens.get(passagem.getId()));
		return lista;
	}

}
//CRUD OK