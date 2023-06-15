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
	
	public Passagem put(Passagem d) throws PassagemValidationException  {
		Passagem original = PassagemController.getInstance().alterarPassagemViagem(d);
			return original;
	}
	
	public Passagem delete(String s)  {
		Passagem passagem = PassagemController.getInstance().excluirPassagemDaViagem(new Passagem(s));
		return passagem;
	}
}
