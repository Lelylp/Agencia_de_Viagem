package controller;

import java.util.List;

import Repositories.RelatorioViagemRepository;
import entities.RelatorioViagem;

public class RelatorioViagemController {

	private static RelatorioViagemController instance;
	private RelatorioViagemRepository repositorio;
	
	private RelatorioViagemController() {
		repositorio = RelatorioViagemRepository.getInstance();	
	}
	
	public static RelatorioViagemController getInstance() {
		if (instance == null) {
			instance = new RelatorioViagemController();
		}
		return instance;
	}
	
	public RelatorioViagem inserirRelatorioViagem(RelatorioViagem relatorioViagem) {
		if (relatorioViagem.getMes() < 1 && relatorioViagem.getMes() > 13 ) {
			System.out.println("Falha: Mes invalido");
			//throw new CargaHorariaException("Falha: carga horária não pode exceder 120 horas "+relatorioViagem);
		}
		if (relatorioViagem.getDestino() == null) {			
			System.out.println(relatorioViagem+" já cadastrada");
			//throw new DisciplinaJaCadastradaException(relatorioViagem+" já cadastrada");
		}
		RelatorioViagem d = repositorio.inserir(relatorioViagem);
		System.out.println(d+" adicionada");
		return d;
	}
	
	public RelatorioViagem alterarRelatorioViagem(RelatorioViagem relatorioViagem) {
		RelatorioViagem relatorioViagemConsulta = (RelatorioViagem) this.consultar(relatorioViagem);
		//mudar essa merda
		if (relatorioViagemConsulta!= null) {
			if (relatorioViagem.getMes() < 1 && relatorioViagem.getMes() > 13 ) {
				System.out.println("Falha: Mes invalido");
				//throw new CargaHorariaException("Falha: carga horária não pode exceder 120 horas "+relatorioViagem);
			}
			if (relatorioViagem.getDestino() == null) {			
				System.out.println(relatorioViagem+" já cadastrada");
				//throw new DisciplinaJaCadastradaException(relatorioViagem+" já cadastrada");
			}
				repositorio.alterar(relatorioViagem);
				RelatorioViagemController.getInstance().alterarRelatorioViagem(relatorioViagem);
				System.out.println(relatorioViagemConsulta + " alterado para " + relatorioViagem);
				return relatorioViagemConsulta;
		}else {
			System.out.println(relatorioViagem+" não encontrado");
			return null;
		}
		
	}
	public RelatorioViagem excluirRelatorioViagem(RelatorioViagem relatorioViagem) {
		RelatorioViagem excluida = repositorio.excluir(relatorioViagem);
		if (excluida!= null) {
			System.out.println(excluida+" excluída");
			return excluida;
		}else {
			System.out.println(excluida+" não encontrada");
			return null;
		}
		
	}
	public List<RelatorioViagem> listarRelatorioViagem(RelatorioViagem relatorioViagem) {
		return repositorio.listar(relatorioViagem);	
	}
	
	public List<RelatorioViagem> consultar(RelatorioViagem relatorioViagem){
		List<RelatorioViagem> RelatorioViagens = repositorio.consultarPorMes(relatorioViagem.getMes());
		if (RelatorioViagens.size() > 0 && RelatorioViagens.get(0) != null) {
			return RelatorioViagens;
		} else {
			return null;
			//throw new DisciplinaNotFoundException("Nenhuma disciplina encontrada para o id: " + id);
		}

	}

}
