package Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import entities.RelatorioViagem;

public class RelatorioViagemRepository implements GenericRepository<RelatorioViagem> {

	private static RelatorioViagemRepository instance = null;
	private HashMap<Integer, RelatorioViagem> relatorioViagem = null;
	private static Integer idDoRelatorio = 1;
	
	private RelatorioViagemRepository() {
		relatorioViagem = new HashMap<Integer, RelatorioViagem>();
	}
	
	public static RelatorioViagemRepository getInstance() {
		
		if (instance == null) {
			instance = new RelatorioViagemRepository();
		}			
		return instance;
	}

	
	@Override
	public RelatorioViagem inserir(RelatorioViagem relatorioViagem) {
		relatorioViagem.setId(idDoRelatorio++);
		try {
			this.relatorioViagem.put(relatorioViagem.getId(), relatorioViagem);
			return relatorioViagem;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public RelatorioViagem alterar(RelatorioViagem relatorioViagem) {
		RelatorioViagem autentico = this.relatorioViagem.get(relatorioViagem.getId());		
		try {
			this.relatorioViagem.put(relatorioViagem.getId(), relatorioViagem);
			return autentico;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public RelatorioViagem excluir(RelatorioViagem relatorioViagem) {
		RelatorioViagem original = this.relatorioViagem.get(relatorioViagem.getId());		
		try {
			this.relatorioViagem.remove(relatorioViagem.getId());
			return original;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<RelatorioViagem> listar() {
		List<RelatorioViagem> lista = new ArrayList<RelatorioViagem>();
		for (RelatorioViagem r: relatorioViagem.values()) {
			lista.add(r);
		}
		return lista;
	}

	public List<RelatorioViagem> consultarPorMes(int mes) {
		List<RelatorioViagem> listaComMeses = relatorioViagem
				.values()
				.stream()
				.filter(d-> d.getMes() == mes)
				.collect(Collectors.toList());
   
		return listaComMeses;
	}

}
//CRUD OK