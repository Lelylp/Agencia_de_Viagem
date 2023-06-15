package Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Enum.Lugar;
import entities.DetalheDaViagem;
import entities.Viagem;
import exceptions.ViagemValidationException;
import services.ViagemService;

public class TestViagem {
	
	public static void main(String[] args) {
		
	ViagemService viagemService = new ViagemService();
	
	try {
		DetalheDaViagem primeiroDetalhe = new DetalheDaViagem(1,20, true,"destino", "origem",true);
		
		List<DetalheDaViagem> lista = new ArrayList<>();
		lista.add(primeiroDetalhe);
	    Viagem viagem1= new Viagem(100.0, Lugar.FLOORIANOPOLIS_SC,LocalDate.of(2024, 5, 1 ));
	    Viagem viagem2 = new Viagem(150.0, Lugar.BUZIOS_RJ,LocalDate.of(2024, 5, 2));
	    
	    viagem1.setDetalhes(lista);
	    viagem2.setDetalhes(lista);
	    
	    viagem1 = viagemService.post(viagem1);
	    viagem2 = viagemService.post(viagem2);
	    
	    System.out.println(viagem2);
	    System.out.println(viagem1);
	    
	} catch (ViagemValidationException e) {
	   
		 System.out.println("Erro ao criar viagem: " + e.getMessage());
	}
	
	try {
    	
        Viagem viagemExcluir = new Viagem();
        viagemExcluir.setId(2);;

        Viagem viagemExcluida = viagemService.delete(viagemExcluir);
        System.out.println("Viagem excluída: " + viagemExcluida);
        
    } catch (ViagemValidationException e) {
    	
        System.out.println("Erro ao excluir viagem: " + e.getMessage());
    }
	
	
	 List<Viagem> viagemListadas = viagemService.get();
     System.out.println("Viagens listadas: " + viagemListadas);
     
 
     
     try {
    	 
 	    Viagem viagem1= new Viagem(100.0, Lugar.FLOORIANOPOLIS_SC,LocalDate.of(2024, 5, 1 ));
 	   

         List<Viagem> viagensConsultadas = viagemService.consultarViagens(viagem1);
         System.out.println("Viagens consultadas:");
         
         for (Viagem viagem : viagensConsultadas) {
         	
             System.out.println(viagem);
         }
         
     } catch (ViagemValidationException e) {
         System.out.println("Erro ao consultar viagens: " + e.getMessage());
     }
     
     try {
         Viagem viagemAlterar = new Viagem();
         viagemAlterar.setId(1);
         viagemAlterar.setValor(200.0);
         
         Viagem viagemAlterada = viagemService.put(viagemAlterar);

         if (viagemAlterada != null) {
             System.out.println("Viagem alterada: " + viagemAlterada);
         } else {
             System.out.println("Falha ao alterar a viagem.");
         }
     } catch (ViagemValidationException e) {
         System.out.println("Erro ao alterar viagem: " + e.getMessage());
     }
    
	}

}