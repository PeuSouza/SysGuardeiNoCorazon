package com.depaula.ifpe.model.repositorios;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository <dv, I>{
	
	public void criar(dv dv) throws SQLException;
	public void atualizar(dv dv);
	public dv ler(I key);
	public void deletar(I key);
	public List<dv> lerTodos();

}
