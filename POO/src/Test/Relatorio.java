package Test;

import java.util.List;

import entities.RelatorioViagem;
import exceptions.RelatorioValidationException;
import services.RelatorioViagemService;

public class Relatorio {

	public static void main(String[] args) {
		
		
		
		RelatorioViagemService relatorioViagemService = new RelatorioViagemService();
		
		try {
			RelatorioViagem primeiroRelatorio= new RelatorioViagem(12, "rio de janeiro", 2);
			RelatorioViagem segundaRelatorio = new RelatorioViagem(1, "são paulo", 5);
		    
			primeiroRelatorio = relatorioViagemService.post(primeiroRelatorio);
			segundaRelatorio = relatorioViagemService.post(segundaRelatorio);
		    
		} catch (RelatorioValidationException e) {
		   
			 System.out.println("Erro ao criar relatorio: " + e.getMessage());
	
		}
		
		try {
		        	
			RelatorioViagem relatorioExcluir = new RelatorioViagem();
            relatorioExcluir.setId(1);;

            RelatorioViagem relatorioExcluida = relatorioViagemService.delete( relatorioExcluir);
            
            
            System.out.println("relatorio excluído: " + relatorioExcluida);
		    
		} catch (RelatorioValidationException e) {
			
		    System.out.println("Erro ao excluir relatorio: " + e.getMessage());
		}
		
		
		 List<RelatorioViagem> relatorioListados = relatorioViagemService.get();
	     System.out.println("relatorio listados: " + relatorioListados);
		
	}

	

}
