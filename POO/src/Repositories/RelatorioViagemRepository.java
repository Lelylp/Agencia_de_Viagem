package Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	public List<RelatorioViagem> consultar(RelatorioViagem relatorioViagem) {
		List<RelatorioViagem> lista = new ArrayList<RelatorioViagem>();
		lista.add(this.relatorioViagem.get(relatorioViagem.getId()));
		return lista;
	}
}
//CRUD OK