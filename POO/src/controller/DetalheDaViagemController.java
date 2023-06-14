package controller;


import java.util.List;

import Repositories.DetalheDaViagemRepository;
import entities.DetalheDaViagem;
import exceptions.DetalhesValidationException;

public class DetalheDaViagemController {

	private static DetalheDaViagemController instance;
	private DetalheDaViagemRepository repositorio;
	
	private DetalheDaViagemController() {
		repositorio = DetalheDaViagemRepository.getInstance();	
	}
	
	public static DetalheDaViagemController getInstance() {
		if (instance == null) {
			instance = new DetalheDaViagemController();
		}
		return instance;
	}
	
	 public DetalheDaViagem inserirDetalheDaViagem(DetalheDaViagem objDDViagem) throws DetalhesValidationException {
	        if (!objDDViagem.isDisponivel() && !objDDViagem.getDestino().equals(objDDViagem.getOrigem())) {
	            System.out.println("Infelizmente estamos sem esse pacote no momento " + objDDViagem);
	            throw new DetalhesValidationException("Detalhes inválidos: " + objDDViagem);
	        } else {
	            DetalheDaViagem aux = repositorio.inserir(objDDViagem);
	            System.out.println(aux + " adicionada");
	            return aux;
	        }
	    }
	
	 public DetalheDaViagem alterarDetalheDaViagem(DetalheDaViagem objDDViagem) throws DetalhesValidationException {
		    DetalheDaViagem consultaSeJaExiste = (DetalheDaViagem) this.consultarDetalhes(objDDViagem);
		    if (consultaSeJaExiste != null) {
		        if (objDDViagem.isDisponivel() == false) {
		            throw new DetalhesValidationException("Infelizmente estamos sem esse pacote no momento" + objDDViagem);
		        } else {
		            repositorio.alterar(objDDViagem);
		            //ViagemController.atualizarDetalhe(objDDViagem);
		            System.out.println(consultaSeJaExiste + " alterado para " + objDDViagem);
		            return consultaSeJaExiste;
		        }
		    } else {
		    	 throw new DetalhesValidationException("Não encontrada" + objDDViagem);
		    }
		}

	 public DetalheDaViagem excluirDetalheDaViagem(DetalheDaViagem objDDViagem) throws DetalhesValidationException {
		    DetalheDaViagem detalheDaViagem = repositorio.excluir(objDDViagem);
		    if (detalheDaViagem != null) {
		        System.out.println(detalheDaViagem + " excluída");
		        return detalheDaViagem;
		    } else {
		        throw new DetalhesValidationException(detalheDaViagem + " não encontrada");
		    }
		}

	 public List<DetalheDaViagem> consultarDetalhes(DetalheDaViagem detalheDaViagem) throws DetalhesValidationException {
		    List<DetalheDaViagem> detalheDaViagens = repositorio.listar(detalheDaViagem);
		    if (detalheDaViagens.size() > 0 && detalheDaViagens.get(0) != null) {
		        return detalheDaViagens;
		    } else {
		        throw new DetalhesValidationException("Nenhum detalhe encontrado para " + detalheDaViagem);
		    }
		}
 }
