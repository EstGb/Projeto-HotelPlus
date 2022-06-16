package Conexao;

//biblioteca java sql 
import java.sql.Connection;
import java.sql.DriverManager;

//Classe de conexão.
public class Conexao {
  // Declaração de variáveis para montar conexão no DeiverManager
  private static final String user = "root";// usuário do banco de dados
  private static final String pass = "Estevamb1@";// password do banco(se não tiver informar vazio)
  private static final String url = "jdbc:mysql://localhost:3306/HOTELPLUS";// URL informando local do banco de dados e
                                                                         // qual banco será utilizado

  // Método connection onde é montada todas conexão passando os parâmetros criados
  // acima retornando a conexão
  public static Connection createConnectionToMySQL() throws Exception {
      // identificação do Class for Name
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection(url, user, pass);
      return connection;
  }

  // Método Conectando o banco e validando se o mesmo foi conectado
  public static void main(String[] args) throws Exception {
      Connection conn = createConnectionToMySQL();
      // Condicional que verifica se de fato o banco conectou, se existir uma conexão
      // aberta ele fecha para a msma não consumir espaço e processamento
      if (conn != null) {
          System.out.println("CONEXAO ESTABELECIDA");
          conn.close();
      }
  }
}