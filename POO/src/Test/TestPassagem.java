package Test;

import java.util.List;

import Enum.TipoPassagem;
import entities.Passagem;
import services.PassagemService;
import exceptions.PassagemValidationException;
public class TestPassagem{

	public static void main(String[] args) {
		
		PassagemService passagemService = new PassagemService();
		
		try {
		    Passagem primeiraPassagem = new Passagem(1, "destino", "2023-01-01", "10:10", 100.0, "origem", "Embarque",TipoPassagem.ECONOMICA, "GOL", "A1");
		    Passagem segundaPassagem = new Passagem(2, "destino", "2023-01-01", "10:10", 100.0, "origem", "Embarque",TipoPassagem.ECONOMICA, "GOL", "A1");
		    
		    primeiraPassagem = passagemService.post(primeiraPassagem);
		    segundaPassagem = passagemService.post(segundaPassagem);
		    
		    System.out.println(primeiraPassagem);
		    
		} catch (PassagemValidationException e) {
		   
			 System.out.println("Erro ao criar passagem: " + e.getMessage());
			
		}
        try {
        	
            Passagem passagemExcluir = new Passagem();
            passagemExcluir.setId(2);;

            Passagem passagemExcluida = passagemService.delete(passagemExcluir);
            System.out.println("Passagem excluída: " + passagemExcluida);
            
        } catch (PassagemValidationException e) {
        	
            System.out.println("Erro ao excluir passagem: " + e.getMessage());
        }
    
        try {
            Passagem passagemAlterar = new Passagem();
            passagemAlterar.setId(1);
            passagemAlterar.setDestino("Emaculada conceição");
            
            Passagem passagemAlterada = passagemService.put(passagemAlterar);

            if (passagemAlterada != null) {
                System.out.println("Passagem alterada: " + passagemAlterada);
            } else {
                System.out.println("Falha ao alterar a passagem.");
            }
        } catch (PassagemValidationException e) {
            System.out.println("Erro ao alterar passagem: " + e.getMessage());
        }
        
        List<Passagem> passagemListadas = passagemService.get();
        System.out.println("Passagens listadas: " + passagemListadas);
        
	}

}
