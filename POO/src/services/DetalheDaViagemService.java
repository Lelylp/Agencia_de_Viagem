package services;

import java.util.List;

import controller.DetalheDaViagemController;
import entities.DetalheDaViagem;
import exceptions.DetalhesValidationException;

public class DetalheDaViagemService {
	
	public List<DetalheDaViagem> get(){
		return DetalheDaViagemController.getInstance().listar();
	}
	
	public DetalheDaViagem post(DetalheDaViagem d) throws DetalhesValidationException {
		DetalheDaViagem	detalheInserido = DetalheDaViagemController.getInstance().inserirDetalheDaViagem(d);
		return detalheInserido;
	}
	
	public DetalheDaViagem put(DetalheDaViagem d) throws DetalhesValidationException {
			DetalheDaViagem original = DetalheDaViagemController.getInstance().alterarDetalheDaViagem(d);
			return original;
	}
	
	public DetalheDaViagem delete( DetalheDaViagem d) throws DetalhesValidationException {
		return DetalheDaViagemController.getInstance().excluirDetalheDaViagem(d);
	}
	
	 public List<DetalheDaViagem> consultarDetalhes(Integer id) throws DetalhesValidationException{
		 return	DetalheDaViagemController.getInstance().consultarDetalhes(id);
	 }
}
