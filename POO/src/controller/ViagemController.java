package controller;
import entities.Viagem;
import Repositories.ViagemRepository;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class ViagemController {

    private ViagemRepository repository;

    public ViagemController() {
        repository = ViagemRepository.getInstance();
    }

    public Viagem criarViagem(double valor, Lugar lugar, LocalDate data) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da viagem deve ser maior que zero.");
        }

        if (lugar == null) {
            throw new IllegalArgumentException("O lugar da viagem não pode ser nulo.");
        }

        if (data == null) {
            throw new IllegalArgumentException("A data da viagem não pode ser nula.");
        }

        Viagem viagem = new Viagem(valor, lugar, data);
        return repository.inserir(viagem);
    }

    public Viagem alterarViagem(Viagem viagem) {
        if (viagem == null) {
            throw new IllegalArgumentException("A viagem não pode ser nula.");
        }

        if (viagem.getId() == null) {
            throw new IllegalArgumentException("Não é possível alterar uma viagem sem ID.");
        }

        return repository.alterar(viagem);
    }

    public Viagem excluirViagem(Viagem viagem) {
        if (viagem == null) {
            throw new IllegalArgumentException("A viagem não pode ser nula.");
        }

        if (viagem.getId() == null) {
            throw new IllegalArgumentException("Não é possível excluir uma viagem sem ID.");
        }

        return repository.excluir(viagem);
    }

    public List<Viagem> consultarViagens(Viagem viagem) {
        if (viagem == null) {
            throw new IllegalArgumentException("A viagem não pode ser nula.");
        }

        if (viagem.getId() == null) {
            throw new IllegalArgumentException("Não é possível consultar uma viagem sem ID.");
        }

        return repository.consultar(viagem);
    }
}