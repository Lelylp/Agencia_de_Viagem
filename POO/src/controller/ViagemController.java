package controller;
import java.time.LocalDate;
import java.util.List;

import Enum.Lugar;
import Repositories.ViagemRepository;
import entities.Viagem;
import exceptions.ViagemValidationException;

public class ViagemController {

    private ViagemRepository repository;

    public ViagemController() {
        repository = ViagemRepository.getInstance();
    }

    public Viagem criarViagem(double valor, Lugar lugar, LocalDate data) throws ViagemValidationException  {
        if (valor <= 0) {
            throw new ViagemValidationException("O valor da viagem deve ser maior que zero.");
        }

        if (lugar == null) {
            throw new ViagemValidationException("O lugar da viagem não pode ser nulo.");
        }

        if (data == null) {
            throw new ViagemValidationException("A data da viagem não pode ser nula.");
        }

        Viagem viagem = new Viagem(valor, lugar, data);
        return repository.inserir(viagem);
    }

    public Viagem alterarViagem(Viagem viagem) throws ViagemValidationException {
        if (viagem == null) {
            throw new ViagemValidationException("A viagem não pode ser nula.");
        }

        if (viagem.getId() == null) {
            throw new ViagemValidationException("Não é possível alterar uma viagem sem ID.");
        }

        return repository.alterar(viagem);
    }

    public Viagem excluirViagem(Viagem viagem) throws ViagemValidationException {
        if (viagem == null) {
            throw new ViagemValidationException("A viagem não pode ser nula.");
        }

        if (viagem.getId() == null) {
            throw new ViagemValidationException("Não é possível excluir uma viagem sem ID.");
        }

        return repository.excluir(viagem);
    }
    
//modificao de Marcos
    public List<Viagem> consultarViagens(Viagem viagem) throws ViagemValidationException {
        if (viagem == null) {
            throw new ViagemValidationException("A viagem não pode ser nula.");
        }

        if (viagem.getLugar() == null) {
            throw new ViagemValidationException("Não é possível consultar uma viagem sem Lugar.");
        }

        if (viagem.getValor() == 0 ) {
            throw new ViagemValidationException("Não é possível consultar uma viagem sem Valor.");
        }
        
        if (viagem.getData() == null) {
            throw new ViagemValidationException("Não é possível consultar uma viagem sem data.");
        }

        try {
            return repository.consultar(viagem);
        } catch (Exception e) {
            throw new ViagemValidationException("Ocorreu um erro ao consultar as viagens.");
        }
    }
}
