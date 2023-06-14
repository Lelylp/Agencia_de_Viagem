package Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
	public List<Passagem> listar(Passagem passagem) {
		List<Passagem> lista = new ArrayList<Passagem>();
		lista.add(passagens.get(passagem.getId()));
		return lista;
		}

	public boolean consultarCadeira(Passagem passagem) {
		Optional<Passagem> op = passagens
				.values()
				.stream()
				.filter(d-> d.getAssento().equals(passagem.getAssento())
						&& d.getEmpresa().equals(passagem.getEmpresa())
						&& d.getDestino().equals(passagem.getDestino()))
				.findFirst();
		if (op.isPresent()) {
			return true;
		}		   
		return false;
	}
}
//CRUD OK