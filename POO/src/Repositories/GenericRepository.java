package Repositories;

import java.util.List;

	public interface GenericRepository <Obj> {

		public Obj inserir(Obj obj);
		public Obj alterar(Obj obj);
		public Obj excluir(Obj obj);
		public List<Obj> consultar(Obj obj);
}
