package Test;

import Enum.TipoPassagem;
import entities.Passagem;
import org.junit.Assert;
import org.junit.Test;

public class PassagemTest {

    @Test
    public void testarConstrutor() {
        Passagem passagem = new Passagem(1, "MANAUS", "2023-05-17", "04:00", 100.0, "PARATY",
                "PARATY", TipoPassagem.ECONOMICA, "Gol", "A1");

        Assert.assertEquals(1, passagem.getId().intValue());
        Assert.assertEquals("MANAUS", passagem.getDestino());
        Assert.assertEquals("2023-05-17", passagem.getData());
        Assert.assertEquals("10:00", passagem.getHorario());
        Assert.assertEquals(100.0, passagem.getValor(), 0.001);
        Assert.assertEquals("PARATY", passagem.getOrigem());
        Assert.assertEquals("PARATY", passagem.getLocalEmbarque());
        Assert.assertEquals(TipoPassagem.ECONOMICA, passagem.getTipoPassagem());
        Assert.assertEquals("Gol", passagem.getEmpresa());
        Assert.assertEquals("A1", passagem.getAssento());
    }

    @Test
    public void testarSettersAndGetters() {
        Passagem passagem = new Passagem("A2");

        passagem.setId(2);
        passagem.setDestino("SALVADOR");
        passagem.setData("2023-05-17");
        passagem.setHorario("11:00");
        passagem.setValor(150.0);
        passagem.setOrigem("FLOORIANOPOLIS");
        passagem.setLocalEmbarque("FLOORIANOPOLIS");
        passagem.setTipoPassagem(TipoPassagem.EXECUTIVA);
        passagem.setEmpresa("Tam");
        passagem.setAssento("B1");

        Assert.assertEquals(2, passagem.getId().intValue());
        Assert.assertEquals("SALVADOR", passagem.getDestino());
        Assert.assertEquals("2023-05-17", passagem.getData());
        Assert.assertEquals("12:00", passagem.getHorario());
        Assert.assertEquals(150.0, passagem.getValor(), 0.001);
        Assert.assertEquals("FLOORIANOPOLIS", passagem.getOrigem());
        Assert.assertEquals("FLOORIANOPOLIS", passagem.getLocalEmbarque());
        Assert.assertEquals(TipoPassagem.EXECUTIVA, passagem.getTipoPassagem());
        Assert.assertEquals("Tam", passagem.getEmpresa());
        Assert.assertEquals("B1", passagem.getAssento());
    }
}