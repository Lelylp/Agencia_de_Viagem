package controller;

import java.util.List;

import entities.DetalheDaViagem;
import entities.Passagem;

public class PassagemController {

	private static PassagemController instance;
	private PassagemController repositorio;
	
	private PassagemController() {
		repositorio = PassagemController.getInstance();	
	}
	
	public static PassagemController getInstance() {
		if (instance == null) {
			instance = new PassagemController();
		}
		return instance;
	}
	
	public Passagem inserirPassagemDaViagem(Passagem passagem) {
		//valor>0 && assento diferente de outro assento
		//fazer throw pra ca tbm
		if (passagem.getValor()<=0 && passagem.getAssento() != repositorio.consultarAssentoPassagemDaViagem(passagem.getAssento())){
			System.out.println("Assentos invalido "+passagem);
			//tem q ter um throw aqui tbm
			return null;
			//lembrar de colocar um throw new CargaHorariaException("Falha: carga hor�ria n�o pode exceder 120 horas "+disciplina);
		}else {
			Passagem aux = repositorio.inserirPassagemDaViagem(passagem);
			System.out.println(aux+" adicionada");
			return aux;
		}
		return null;
	}
	
	public Passagem alterarPassagemViagem(Passagem passagem) {
		Passagem consultaSeJaExiste = (Passagem) this.consultarAssentoPassagemDaViagem(passagem.getAssento());
		if (consultaSeJaExiste != null) {
			if (passagem.getValor()<=0 && passagem.getAssento() != repositorio.consultarAssentoPassagemDaViagem(passagem.getAssento())) {
				System.out.println("Assentos invalido "+passagem);
				return null;
			} else {
				repositorio.alterarPassagemViagem(passagem);
				//ViagemController.getInstance().atualizarDetalhe(objDDViagem);
				System.out.println(consultaSeJaExiste + " alterado para " + passagem);
				return consultaSeJaExiste;
			}
		}else {
			System.out.println(passagem+" n�o encontrada");
			return null;
		}
	}
	public Passagem excluirPassagemDaViagem(Passagem passagem) {
		Passagem exluirPassagem = repositorio.excluirPassagemDaViagem(passagem);
		if (exluirPassagem!= null) {
			System.out.println(exluirPassagem+" exclu�da");
			return exluirPassagem;
		}else {
			System.out.println(exluirPassagem+" n�o encontrada");
			return null;
		}
	}
	public Passagem consultarAssentoPassagemDaViagem(String string) {
		Passagem algumaCoisa = new Passagem(string);
		//fazer ele rodar o repostirio e achar o assento passado
	
		List<Passagem> passagens = algumCoisa;
		if (passagens.size() > 0 && passagens.get(0) != null) {
			return passagens;
		} else {
			return null;
			//throw new DisciplinaNotFoundException("Nenhuma disciplina encontrada para o id: " + id);
		}
	}
}
