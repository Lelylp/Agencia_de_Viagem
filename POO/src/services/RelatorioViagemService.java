package services;

import java.util.List;

import controller.RelatorioViagemController;
import entities.RelatorioViagem;
import exceptions.RelatorioValidationException;

public class RelatorioViagemService {

	public List<RelatorioViagem> get(){
		return RelatorioViagemController.getInstance().listarRelatorioViagem();
	}
	
	public RelatorioViagem post(RelatorioViagem d) throws RelatorioValidationException  {
		RelatorioViagem	relatorioInserido = RelatorioViagemController.getInstance().inserirRelatorioViagem(d);
		return relatorioInserido;
	}
	
	public RelatorioViagem put(RelatorioViagem d) throws RelatorioValidationException  {
		RelatorioViagem original = RelatorioViagemController.getInstance().alterarRelatorioViagem(d);
			return original;
	}
	
	public RelatorioViagem  delete(RelatorioViagem  d) throws RelatorioValidationException {
		return RelatorioViagemController.getInstance().excluirRelatorioViagem(d);
	}
	
	public List<RelatorioViagem> consultar(RelatorioViagem d)throws RelatorioValidationException {
		 return RelatorioViagemController.getInstance().consultar(d);
	}
}
