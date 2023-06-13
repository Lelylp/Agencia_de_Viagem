package controller;

import java.util.List;

import Repositories.PassagemRepository;
import entities.Passagem;

public class PassagemController {

	private static PassagemController instance;
	private PassagemRepository repositorio;
	
	private PassagemController() {
		repositorio = PassagemRepository.getInstance();	
	}
	
	public static PassagemController getInstance() {
		if (instance == null) {
			instance = new PassagemController();
		}
		return instance;
	}
	
	public Passagem inserirPassagemDaViagem(Passagem passagem) {
        if (passagem != null) {
            if (passagem.getDestino() == null || passagem.getDestino().trim().isEmpty()){
                //throw new PassagemValidationException("A passagem não possui uma valor válido");
            }
            if (passagem.getData() == null || passagem.getData().trim().isEmpty()) {
                //throw new PassagemValidationException("A passagem não possui uma data válida");
            }
            if (passagem.getHorario() == null || passagem.getLocalEmbarque().trim().isEmpty()) {
                //throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
            if (passagem.getValor() <= 0 || passagem.getLocalEmbarque().trim().isEmpty()) {
                //throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
            if (passagem.getOrigem() == null || passagem.getLocalEmbarque().trim().isEmpty()) {
                //throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
            if (passagem.getLocalEmbarque() == null || passagem.getLocalEmbarque().trim().isEmpty()) {
                //throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
            if (passagem.getTipoPassagem() == null || passagem.getLocalEmbarque().trim().isEmpty()) {
                //throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
            if (passagem.getEmpresa() == null || passagem.getLocalEmbarque().trim().isEmpty()) {
                //throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
            if (passagem.getAssento() == null || passagem.getLocalEmbarque().trim().isEmpty()) {
                //throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
        	}
        	repositorio.inserir(passagem);
        	return passagem;
	}
	
	public Passagem alterarPassagemViagem(Passagem passagem) {
		Passagem consultaSeJaExiste = (Passagem) this.consultarAssentoPassagemDaViagem(passagem.getAssento());
		if (consultaSeJaExiste != null) {
			if (passagem.getAssento().equals(repositorio.consultar(passagem))) {
				System.out.println("Assentos invalido "+passagem);
				return null;
			} else {
				repositorio.alterar(passagem)
				//ViagemController.getInstance().atualizarDetalhe(objDDViagem);
				//alguma coisa
				return consultaSeJaExiste;
			}
		}else {
			System.out.println(passagem+" n�o encontrada");
			return null;
		}
	}
	public Passagem excluirPassagemDaViagem(Passagem passagem) {
		Passagem exluirPassagem = repositorio.excluir(passagem);
		if (exluirPassagem!= null) {
			System.out.println(exluirPassagem+" exclu�da");
			return exluirPassagem;
		}else {
			System.out.println(exluirPassagem+" n�o encontrada");
			return null;
		}
	}
	public List<Passagem> consultarAssentoPassagemDaViagem(String assento) {
		List<Passagem> passagens = repositorio.consultar(new Passagem(assento));
	
		if (passagens.size() > 0 && passagens.get(0) != null) {
			return passagens;
		} else {
			return null;
			//throw new DisciplinaNotFoundException("Nenhuma disciplina encontrada para o id: " + id);
		}
	}
}
