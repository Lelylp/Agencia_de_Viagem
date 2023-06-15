package services;

import java.util.List;

import controller.ViagemController;
import entities.Viagem;
import exceptions.ViagemValidationException;

public class ViagemService {
	
	public List<Viagem> get(){
		return ViagemController.getInstance().listar();
	}
	
	public Viagem post(Viagem d) throws ViagemValidationException  {
		Viagem ViagemInserida = ViagemController.getInstance().criarViagem(d);
		return ViagemInserida;
	}

	public Viagem put(Viagem d) throws ViagemValidationException {
        Viagem original = ViagemController.getInstance().alterarViagem(d);
        return original;
    }
	
	
	public Viagem delete(Viagem Viagem) throws ViagemValidationException {
		return ViagemController.getInstance().excluirViagem(Viagem);
	}

	public List<Viagem> consultarViagens(Viagem viagem) throws ViagemValidationException {
		return ViagemController.getInstance().consultarViagens(viagem);
	}
	
}
