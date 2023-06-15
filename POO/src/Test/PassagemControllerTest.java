package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Enum.TipoPassagem;
import controller.PassagemController;
import entities.Passagem;
import exceptions.PassagemValidationException;


public class PassagemControllerTest {
	
    private PassagemController passagemController;

    @Before
    public void setUp() {
        passagemController = PassagemController.getInstance();
    }
    
    private Passagem criarPassagemExemplo() {
        return new Passagem(1, "MANAUS", "2023-05-17", "04:00", 100.0, "FLOORIANOPOLIS",
                "FLOORIANOPOLIS",TipoPassagem.EXECUTIVA, "Empresa", "A1");
    }

    @Test
    public void testarInserirPassagem() throws PassagemValidationException {
        Passagem passagem = criarPassagemExemplo();

        Passagem passagemInserida = passagemController.inserirPassagemDaViagem(passagem);

        Assert.assertNotNull(passagemInserida);
        Assert.assertEquals(passagem, passagemInserida);
    }

    @Test
    public void testarExcluirPassagem() throws PassagemValidationException {
        Passagem passagem = criarPassagemExemplo();
        passagemController.inserirPassagemDaViagem(passagem);

        Passagem passagemExcluida = passagemController.excluirPassagem(passagem);

        Assert.assertNotNull(passagemExcluida);
        Assert.assertEquals(passagem, passagemExcluida);
    }
   
}