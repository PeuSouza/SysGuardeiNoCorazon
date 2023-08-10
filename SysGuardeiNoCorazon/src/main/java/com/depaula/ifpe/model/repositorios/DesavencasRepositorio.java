package com.depaula.ifpe.model.repositorios;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.devpaula.ifpe.model.entidades.Desavencas;
import com.devpaula.ifpe.model.entidades.Desafetos;


public class DesavencasRepositorio implements GenericRepository<Desavencas, Integer>{
	
 protected DesavencasRepositorio() {
	
}
 @Override
	public void criar(Desavencas dv) throws SQLException {
		String sql = "insert into Desavencas(data,hora,descricao,motivacao,local,desafeto_id) values(?,?,?,?,?,?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString (1,dv.getData());
		pstm.setString(2, dv.getHora());
		pstm.setString(3, dv.getDescricao());
		pstm.setString(4, dv.getMotivacao());
		pstm.setString(5, dv.getLocal());
		pstm.setInt(6, dv.getDesafeto().getId());
		 

		pstm.execute();

	}
 
 @Override
	public void atualizar(Desavencas dv) {

		String sql = "update Desavencas set data=?, hora=?, descricao=?, motivacao=?, local=? where codigo=?";
      try {
	      PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

	       pstm.setString (1, dv.getData());
	       pstm.setString(2, dv.getHora());
	       pstm.setString(3, dv.getDescricao());
	       pstm.setString(4, dv.getMotivacao());
	       pstm.setString(5, dv.getLocal());
	       pstm.setObject(6, dv.getDesafeto());
	       pstm.setInt(7,dv.getCodigo()); 

	       pstm.execute();
 
     }catch (SQLException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
  }
 @Override
	public Desavencas ler (Integer codigo) {
		String sql = "select * from Desavencas as dv join Desafetos as df on (dv.desafeto_id = df.codigo) where codigo=?";
		
		try {

			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

			pstm.setInt(1, codigo);

			ResultSet result = pstm.executeQuery();

			Desavencas nDesavencas = null;

			if (result.next()) {
				nDesavencas = new Desavencas();
				nDesavencas.setCodigo(result.getInt("codigo"));
				nDesavencas.setData(result.getString("data"));
				nDesavencas.setHora(result.getString("hora"));
				nDesavencas.setDescricao(result.getString("descricao"));
				nDesavencas.setMotivacao(result.getString("motivacao"));
				nDesavencas.setLocal(result.getString("local"));
				
                Desafetos Desafeto = new Desafetos();
                Desafeto.setId(result.getInt("id"));
                Desafeto.setNome(result.getString("nome"));
                Desafeto.setApelido(result.getString("apelido"));
                Desafeto.setSexo(result.getString("sexo"));
                Desafeto.setDeOndeConheco(result.getString("deOndeConheco"));
                
                nDesavencas.setDesafeto(Desafeto);
				
			}

			return nDesavencas;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

 @Override
	public List<Desavencas> lerTodos(){
		String sql = "select * from Desavencas as dv join Desafetos as df on (dv.desafeto_id = df.codigo)";
		List<Desavencas> lDesavencas = new ArrayList<>();
		
		try {
			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
			ResultSet result = pstm.executeQuery();
			
			Desavencas nDesavencas = null;
			
			while (result.next()){
				nDesavencas.setCodigo(result.getInt("codigo"));
				nDesavencas.setData(result.getString("Data"));
				nDesavencas.setHora(result.getString("Hora"));
				nDesavencas.setDescricao(result.getString("Descricao"));
				nDesavencas.setMotivacao(result.getString("Motivacao"));
				nDesavencas.setLocal(result.getString("Local"));
				
				Desafetos Desafeto = new Desafetos();
                Desafeto.setId(result.getInt("id"));
                Desafeto.setNome(result.getString("nome"));
                Desafeto.setApelido(result.getString("apelido"));
                Desafeto.setSexo(result.getString("sexo"));
                Desafeto.setDeOndeConheco(result.getString("deOndeConheco"));
                nDesavencas.setDesafeto(Desafeto);
                
                
			 lDesavencas.add(nDesavencas);
			 
			} 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return lDesavencas;
	    }
	
	
 @Override
    public void deletar(Integer codigo) {
		// TODO Auto-generated method stub

		String sql = "delete from Desavencas where codigo = ?";

		try {

			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

			pstm.setInt(1, codigo);

			pstm.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
