package controller;

import java.util.List;

import Repositories.PassagemRepository;
import entities.Passagem;
import exceptions.PassagemValidationException;

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
	
	public Passagem inserirPassagemDaViagem(Passagem passagem) throws PassagemValidationException {
        if (passagem != null) {
            if (passagem.getDestino() == null || passagem.getDestino().trim().isEmpty()){
                throw new PassagemValidationException("A passagem não possui uma valor válido");
            }
            if (passagem.getData() == null || passagem.getData().trim().isEmpty()) {
                throw new PassagemValidationException("A passagem não possui uma data válida");
            }
            if (passagem.getHorario() == null || passagem.getLocalEmbarque().trim().isEmpty()) {
                throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
            if (passagem.getValor() <= 0 || passagem.getLocalEmbarque().trim().isEmpty()) {
                throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
            if (passagem.getOrigem() == null || passagem.getLocalEmbarque().trim().isEmpty()) {
                throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
            if (passagem.getLocalEmbarque() == null || passagem.getLocalEmbarque().trim().isEmpty()) {
                throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
            if (passagem.getTipoPassagem() == null || passagem.getLocalEmbarque().trim().isEmpty()) {
                throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
            if (passagem.getEmpresa() == null || passagem.getLocalEmbarque().trim().isEmpty()) {
                throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
            if (passagem.getAssento() == null || passagem.getLocalEmbarque().trim().isEmpty()) {
                throw new PassagemValidationException("O local de embarque não pode estar vazio");
            }
        	}
        	repositorio.inserir(passagem);
        	return passagem;
	}
	
	 public Passagem alterarDestino(Passagem passagem) throws PassagemValidationException {
	        if (passagem == null) {
	            throw new PassagemValidationException("A viagem não pode ser nula.");
	        }
	        
	        if (passagem.getId() == null) {
	            throw new PassagemValidationException("Não é possível alterar uma viagem sem ID.");
	        }
	        
	        repositorio.alterar(passagem);
	        return passagem;
	 }
	 
	public Passagem excluirPassagem(Passagem passagem) throws PassagemValidationException {
        if (passagem == null) {
            throw new PassagemValidationException("A passagem não pode ser nula.");
        }

        if (passagem.getId() == null) {
            throw new PassagemValidationException("Não é possível excluir uma passagem sem ID.");
        }

        return repositorio.excluir(passagem);
    }

	public Passagem consultarAssentoPassagemDaViagem(Passagem passagem) throws PassagemValidationException {
	    if (repositorio.consultarCadeira(passagem)) {
	        return passagem;
	    } else {
	        throw new PassagemValidationException("Passagem não encontrada para o assento: " + passagem.getAssento());
	    }
	}
	
	public List<Passagem> listar() {
		return repositorio.listar();	
	}
}
