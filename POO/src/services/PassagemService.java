package services;

import java.util.List;

import controller.PassagemController;
import entities.Passagem;
import exceptions.PassagemValidationException;

public class PassagemService {

	public List<Passagem> get(){
		return PassagemController.getInstance().listar();
	}
	
	public Passagem post(Passagem d) throws PassagemValidationException  {
		Passagem passagemInserida = PassagemController.getInstance().inserirPassagemDaViagem(d);
		return passagemInserida;
	}
	//fixed
	public Passagem put(Passagem d) throws PassagemValidationException  {
		Passagem original = PassagemController.getInstance().alterarDestino(d);
			return original;
	}
	
	public Passagem delete(Passagem passagem) throws PassagemValidationException {
		return PassagemController.getInstance().excluirPassagem(passagem);
		
	}
	
	   public Passagem consultar(Passagem passagem) throws PassagemValidationException {
			PassagemController.getInstance().consultarAssentoPassagemDaViagem(passagem);
			return passagem;
		}
		
		
	
}
