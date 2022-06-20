import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Classes.Hoteis;
import Classes.User;
import ClassesDAO.UserDAO;
import Classes.Reserva;

public class App {

	public static void main(String[] args) throws Exception {
		User user = new User();
		UserDAO userDAO = new UserDAO();
		Scanner sc = new Scanner(System.in);
		Hoteis hoteis = new Hoteis();
		Reserva reserva = new Reserva();
		int menu;
			do {
				System.out.println("--------------------");
				System.out.println("MENU");
	            System.out.println("--------------------");
	            System.out.println("1 - CADASTRAR USUARIO");
	            System.out.println("2 - LOGIN");
	            System.out.println("3 - PESQUISAR");
	            System.out.println("4 - RESERVAR");
	            System.out.println("0 - SAIR");
	            menu = sc.nextInt();
					
	            	switch (menu) {
					case 1:
						
						System.out.println("--------------");
						System.out.println("NOME");
						sc.nextLine();
						user.setNome(sc.nextLine());
						
						System.out.println("SOBRENOME");
						user.setSobrenome(sc.next());
						
						System.out.println("EMAIL");
						user.setEmail(sc.next());
						
						System.out.println("SENHA");
						user.setSenha(sc.next());
						
						userDAO.Salvar(user);
						
						break;
					
					case 2:
						
						System.out.println("TELA DE LOGIN");
						System.out.println("EMAIL: ");
						sc.nextLine();
						user.setEmail(sc.nextLine());
						
						System.out.println("SENHA: ");
						user.setSenha(sc.next());
						
						try {
							ResultSet rstUser = userDAO.autenticacaoUser(user);
							
							if (rstUser.next()) {
								System.out.println("LOGIN EFETUADO COM SUCESSO!!");
								userDAO.Pesquisar();
								
							} else {
								System.out.println("EMAIL OU SENHA INCORRETOS!");

							}
							
						} catch (SQLException e) {
							System.out.println("ERRO DE AUTENTICAÇÂO");
						}
						
						
						break;
						
					case 3:
		
						System.out.println("Pesquisa de Hoteis");
						System.out.println("--------------");
						for (Hoteis h: userDAO.Pesquisar()) {
							System.out.println("Id: " + h.getId());
							System.out.println("Nome do Hotel: " + h.getNome());
							System.out.println("Endereço: " + h.getEndereco());
							System.out.println("Distancia da Praia: " + h.getProx_praia());
							System.out.println("Estrelas: " + h.getEstrelas());
							System.out.println("Valor: " + h.getValor());
							System.out.println("--------------");
							
						}
						
						break;
					case 10:
						
					                    
	                    System.out.println("INFORME O ID DO CONTATO QUE DESEJA REMOVER?");
	                    int contRem = sc.nextInt();
	                    userDAO.removerContato(contRem);
						
						break;
						
					case 4:
						
						System.out.println("----------RESERVA----------");
						System.out.println("INFORME O ID DO USUARIO: ");
						sc.nextInt();
						System.out.println("INFORME O ID DO HOTEL: ");
						sc.nextInt();
						System.out.println("INFORME SEU NOME: ");
						sc.nextLine();
						reserva.setNome(sc.nextLine());
						System.out.println("INFORME SEU E-MAIL: ");
						reserva.setEamil(sc.nextLine());
						System.out.println("INFORME A DATA DE CHECK-IN:");
						reserva.setDataEntrada(sc.next());
						System.out.println("INFORME A DATA DE CHECK-OUT:");
						reserva.setDataSaida(sc.next());
						
						userDAO.Reserva(user);
						
						break;

					default:
						System.out.println("Até mais!");
						break;
					}
			} while (menu !=0);
		sc.close();
		

	}

}
