package Test;

import java.util.List;

import entities.DetalheDaViagem;
import exceptions.DetalhesValidationException;
import services.DetalheDaViagemService;

public class Detalhes {

	public static void main(String[] args) {
	
		
		DetalheDaViagemService detalheService = new DetalheDaViagemService();
		
		try {
			DetalheDaViagem primeiroDetalhe = new DetalheDaViagem(1,20, true,"destino", "origem",true);
			DetalheDaViagem segundaDetalhe = new DetalheDaViagem(2,50,true,"destino", "origem",true);
		    
			primeiroDetalhe = detalheService.post(primeiroDetalhe);
			segundaDetalhe = detalheService.post(segundaDetalhe);
		    
		} catch (DetalhesValidationException e) {
		   
			 System.out.println("Erro ao criar detalhe: " + e.getMessage());
	
		}
		
		try {
		        	
			DetalheDaViagem detalheExcluir = new DetalheDaViagem();
            detalheExcluir.setId(1);;

            DetalheDaViagem passagemExcluida = detalheService.delete(detalheExcluir);
            System.out.println("Detalhe excluído: " + passagemExcluida);
		    
		} catch (DetalhesValidationException e) {
			
		    System.out.println("Erro ao excluir detalhe: " + e.getMessage());
		}
		
		
		 List<DetalheDaViagem> detalhesListados = detalheService.get();
	     System.out.println("Detalhes listados: " + detalhesListados);
	}

}
