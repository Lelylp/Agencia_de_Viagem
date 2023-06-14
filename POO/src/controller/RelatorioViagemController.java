package controller;

import java.util.List;

import Repositories.RelatorioViagemRepository;
import entities.RelatorioViagem;
import exceptions.RelatorioValidationException;

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
	
	  public RelatorioViagem inserirRelatorioViagem(RelatorioViagem relatorioViagem) throws RelatorioValidationException {
	        if (relatorioViagem.getMes() < 1 || relatorioViagem.getMes() > 12) {
	            throw new RelatorioValidationException("Mês inválido: " + relatorioViagem.getMes());
	        }
	        if (relatorioViagem.getDestino() == null) {
	            throw new RelatorioValidationException("Destino não informado");
	        }
	        RelatorioViagem d = repositorio.inserir(relatorioViagem);
	        System.out.println(d + " adicionada");
	        return d;
	    }
	
	  public RelatorioViagem alterarRelatorioViagem(RelatorioViagem relatorioViagem) throws RelatorioValidationException {
		    RelatorioViagem relatorioViagemConsulta = (RelatorioViagem) this.consultar(relatorioViagem);
		    if (relatorioViagemConsulta != null) {
		        if (relatorioViagem.getMes() < 1 || relatorioViagem.getMes() > 12) {
		            throw new RelatorioValidationException("Mês inválido: " + relatorioViagem.getMes());
		        }
		        if (relatorioViagem.getDestino() == null) {
		            throw new RelatorioValidationException("Destino não informado");
		        }
		        repositorio.alterar(relatorioViagem);
		        RelatorioViagemController.getInstance().alterarRelatorioViagem(relatorioViagem);
		        System.out.println(relatorioViagemConsulta + " alterado para " + relatorioViagem);
		        return relatorioViagemConsulta;
		    } else {
		        System.out.println(relatorioViagem + " não encontrado");
		        return null;
		    }
		}

	  public RelatorioViagem excluirRelatorioViagem(RelatorioViagem relatorioViagem) throws RelatorioValidationException {
		    RelatorioViagem excluida = repositorio.excluir(relatorioViagem);
		    if (excluida != null) {
		        System.out.println(excluida + " excluída");
		        return excluida;
		    } else {
		        throw new RelatorioValidationException("Relatório de viagem não encontrado: " + relatorioViagem);
		    }
		}

	public List<RelatorioViagem> listarRelatorioViagem(RelatorioViagem relatorioViagem) {
		return repositorio.listar(relatorioViagem);	
	}
	
	public List<RelatorioViagem> consultar(RelatorioViagem relatorioViagem) throws RelatorioValidationException {
	    List<RelatorioViagem> relatorioViagens = repositorio.consultarPorMes(relatorioViagem.getMes());
	    if (relatorioViagens.size() > 0 && relatorioViagens.get(0) != null) {
	        return relatorioViagens;
	    } else {
	        throw new RelatorioValidationException("Nenhum relatório de viagem encontrado para o mês: " + relatorioViagem.getMes());
	    }
	}

}
