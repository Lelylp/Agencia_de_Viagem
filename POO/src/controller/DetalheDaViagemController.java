package controller;


import java.util.List;

import entities.DetalheDaViagem;

public class DetalheDaViagemController {

	private static DetalheDaViagemController instance;
	private DetalheDaViagemController repositorio;
	
	private DetalheDaViagemController() {
		repositorio = DetalheDaViagemController.getInstance();	
	}
	
	public static DetalheDaViagemController getInstance() {
		if (instance == null) {
			instance = new DetalheDaViagemController();
		}
		return instance;
	}
	
	public DetalheDaViagem inserirDetalheDaViagem(DetalheDaViagem objDDViagem) {
		if (objDDViagem.isDisponivel() == false && objDDViagem.getDestino() != objDDViagem.getOrigem()){
			System.out.println("Infelizmente estamos sem esse pacote no momento "+objDDViagem);
			//tem q ter um throw aqui tbm
			return null;
			//lembrar de colocar um throw new CargaHorariaException("Falha: carga hor�ria n�o pode exceder 120 horas "+disciplina);
		}else {
			DetalheDaViagem aux = repositorio.inserirDetalheDaViagem(objDDViagem);
			System.out.println(aux+" adicionada");
			return aux;
		}
	}
	
	public DetalheDaViagem alterarDetalheDaViagem(DetalheDaViagem objDDViagem) {
		//tenho q ver em viagem e no detalhe tbm, na vdd nn pq existem varias passagens para o mesmo lguar
		DetalheDaViagem consultaSeJaExiste = (DetalheDaViagem) this.consultar(objDDViagem);
		if (consultaSeJaExiste != null) {
			if (objDDViagem.isDisponivel() == false) {
				System.out.println("Infelizmente estamos sem esse pacote no momento "+objDDViagem);
				return null;
			} else {
				repositorio.alterarDetalheDaViagem(objDDViagem);
				//ViagemController.getInstance().atualizarDetalhe(objDDViagem);
				System.out.println(consultaSeJaExiste + " alterado para " + objDDViagem);
				return consultaSeJaExiste;
			}
		}else {
			System.out.println(objDDViagem+" n�o encontrada");
			return null;
		}
	}
	public DetalheDaViagem excluirDetalheDaViagem(DetalheDaViagem objDDViagem) {
		DetalheDaViagem detalheDaViagem = repositorio.excluirDetalheDaViagem(objDDViagem);
		if (detalheDaViagem!= null) {
			System.out.println(detalheDaViagem+" exclu�da");
			return detalheDaViagem;
		}else {
			System.out.println(detalheDaViagem+" n�o encontrada");
			return null;
		}
	}
	public List<DetalheDaViagem> consultar(DetalheDaViagem detalheDaViagem) {
		List<DetalheDaViagem> detalheDaViagens = repositorio.consultar(detalheDaViagem);
		if (detalheDaViagens.size() > 0 && detalheDaViagens.get(0) != null) {
			return detalheDaViagens;
		} else {
			return null;
			//throw new DisciplinaNotFoundException("Nenhuma disciplina encontrada para o id: " + id);
		}
	}
}
