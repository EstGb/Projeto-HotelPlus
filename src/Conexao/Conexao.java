package Conexao;

//biblioteca java sql 
import java.sql.Connection;
import java.sql.DriverManager;

//Classe de conex�o.
public class Conexao {
  // Declara��o de vari�veis para montar conex�o no DeiverManager
  private static final String user = "root";// usu�rio do banco de dados
  private static final String pass = "Estevamb1@";// password do banco(se n�o tiver informar vazio)
  private static final String url = "jdbc:mysql://localhost:3306/HOTELPLUS";// URL informando local do banco de dados e
                                                                         // qual banco ser� utilizado

  // M�todo connection onde � montada todas conex�o passando os par�metros criados
  // acima retornando a conex�o
  public static Connection createConnectionToMySQL() throws Exception {
      // identifica��o do Class for Name
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection(url, user, pass);
      return connection;
  }

  // M�todo Conectando o banco e validando se o mesmo foi conectado
  public static void main(String[] args) throws Exception {
      Connection conn = createConnectionToMySQL();
      // Condicional que verifica se de fato o banco conectou, se existir uma conex�o
      // aberta ele fecha para a msma n�o consumir espa�o e processamento
      if (conn != null) {
          System.out.println("CONEXAO ESTABELECIDA");
          conn.close();
      }
  }
}