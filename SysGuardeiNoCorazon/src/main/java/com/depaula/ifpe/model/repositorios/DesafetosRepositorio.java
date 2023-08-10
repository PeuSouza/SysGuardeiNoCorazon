package com.depaula.ifpe.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.devpaula.ifpe.model.entidades.Desafetos;
import com.devpaula.ifpe.model.entidades.Desavencas;



public class DesafetosRepositorio implements GenericRepository<Desafetos, Integer>{

DesafetosRepositorio(){
	
}
	
@Override
  public void criar(Desafetos df) {
	String sql = "insert into Desafetos(nome, apelido, sexo, deOndeConheco) values(?,?,?,?)";

	PreparedStatement pstm;
	try {
		pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, df.getNome());
		pstm.setString(2, df.getApelido());
		pstm.setString(3, df.getSexo());
		pstm.setString(4, df.getDeOndeConheco());
		

		pstm.execute();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	   }
@Override
   public void atualizar(Desafetos df) {

	String sql = "update Desafetos set nome=?, apelido=?, sexo=?, deOndeConheco=? where id=?";

	try {

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, df.getNome());
		pstm.setString(2, df.getApelido());
		pstm.setString(3, df.getSexo());
		pstm.setString(4, df.getDeOndeConheco());

		pstm.setInt(5, df.getId());

		pstm.execute();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
@Override
   public Desafetos ler (Integer id) {
	String sql = "select * from Desafetos where id=?";
	
	try {

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, id);

		ResultSet result = pstm.executeQuery();

		Desafetos nDesafetos = null;

		if (result.next()) {
			nDesafetos = new Desafetos();
			nDesafetos.setId(id);
			nDesafetos.setNome(result.getString("Nome"));
			nDesafetos.setApelido(result.getString("Apelido"));
			nDesafetos.setSexo(result.getString("Sexo"));
			nDesafetos.setDeOndeConheco(result.getString("DeOndeConheco"));
		
		 nDesafetos.setDesavencas(filtroDeDesavencasporDesafeto(id));
		}

		return nDesafetos;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
  }

@Override
  public List<Desafetos> lerTodos(){
	String sql = "select * from Desafetos";
	List<Desafetos> lDesafetos = new ArrayList<>();
	
	try {
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		ResultSet result = pstm.executeQuery();
		
		Desafetos nDesafetos = null;
		
		while (result.next()){
			nDesafetos = new Desafetos();
			nDesafetos.setId(result.getInt("id"));
			nDesafetos.setNome(result.getString("Nome"));
			nDesafetos.setApelido(result.getString("Apelido"));
			nDesafetos.setSexo(result.getString("Sexo"));
			nDesafetos.setDeOndeConheco(result.getString("DeOndeConheco"));
		
			
			nDesafetos.setDesavencas(filtroDeDesavencasporDesafeto(nDesafetos.getId()));
			
		 lDesafetos.add(nDesafetos);
		 
		} 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lDesafetos;
    }

@Override
   public void deletar(Integer key) {
	// TODO Auto-generated method stub

	String sql = "delete from Desafetos where id = ?";

	try {

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, key);

		pstm.execute();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

   }

// filtro 

public List<Desavencas> filtroDeDesavencasporDesafeto(Integer id){
	
	String sql= "select * from desavencas where desafeto_id = ?";
	List<Desavencas> Desavencas= new ArrayList<>();
    Desavencas Desavenca = null;
	try {
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setInt(1, id);
		ResultSet result= pstm.executeQuery();
		
		while(result.next()){
			Desavenca = new Desavencas();
			Desavenca.setCodigo(result.getInt("Codigo"));
			Desavenca.setData(result.getString("data"));
			Desavenca.setHora(result.getString("Hora"));
			Desavenca.setDescricao(result.getString("Descricao"));
			Desavenca.setMotivacao(result.getString("motivacao"));
			Desavenca.setLocal(result.getString("Local"));
			
			Desavencas.add(Desavenca);
        }
        return Desavencas;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}

}

