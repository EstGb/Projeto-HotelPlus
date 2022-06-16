package ClassesDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import Classes.User;
import Conexao.Conexao;
import Classes.Hoteis;

public class UserDAO {
	// Método cadastrar Usuário
	public void Salvar (User user) {
		String sql = "INSERT INTO usuario (nome, sobrenome, email, senha) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, user.getNome());
				pstm.setString(2, user.getSobrenome());
				pstm.setString(3, user.getEmail());
				pstm.setString(4, user.getSenha());
				pstm.execute();
				System.out.println("Usuário salvo com sucesso!");
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
				finally {
					try {
						if (pstm!= null) {
							pstm.close();
						}
						if (conn!= null) {
							conn.close();
						}
					
					}
					catch (Exception e) {                
		                e.printStackTrace();
		            }
			}
			
		
							}
	
								//Método Remover Usuário
							    public void removerContato(int idRem){
							        String sql = "DELETE FROM usuario WHERE id = ?";
							        Connection conn = null;
							        PreparedStatement pstm = null;
							
							        try {
							            conn = Conexao.createConnectionToMySQL();
							            pstm = (PreparedStatement) conn.prepareStatement(sql);
							            
							            pstm.setInt(1, idRem);
							
							            pstm.execute();
							
							            System.out.println("Usuário deletado com Sucesso!!");
							                        
							        } catch (Exception e) {
							            e.printStackTrace();
							        } finally {
							            //fechar Conexões
							            try {
							                if (pstm!=null) {
							                    pstm.close();
							                }
							                if (conn!=null) {
							                    conn.close();
							                }
							            } catch (Exception e) {                
							                e.printStackTrace();
							            }
							        }
							    }
							    	//Método Pesquisar Hoteis
							    	public ArrayList<Hoteis> Pesquisar() throws Exception{
							    		String sql = "SELECT * FROM HOTEIS";
							    		Connection conn = null;
								        PreparedStatement pstm = null;
								        
								        ResultSet rst;
								        ArrayList<Hoteis> lista = new ArrayList<>();
							    		
							    		try {
							    			conn = Conexao.createConnectionToMySQL();
											pstm = (PreparedStatement) conn.prepareStatement(sql);
							    			
											rst = pstm.executeQuery();           
							    			
							    			Hoteis hoteis = new Hoteis();
							    			
							    			 while (rst.next()) {
												hoteis.setId(rst.getInt("id"));
												hoteis.setNome(rst.getString("nome"));
												hoteis.setEndereco(rst.getString("endereco"));
												hoteis.setProx_praia(rst.getString("prox_praia"));
												hoteis.setEstrelas(rst.getString("estrelas"));
												hoteis.setValor(rst.getString("valor"));
												
												lista.add(hoteis);
												
											}
											
											
										} catch (SQLException e) {
											System.out.println("Erro em Pesquisar Hoteis");
											
										}
							    		return lista;
							    		
							    		
							    	}
	
}
