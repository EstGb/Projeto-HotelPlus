import java.util.Scanner;

import Classes.Hoteis;
import Classes.User;
import ClassesDAO.UserDAO;

public class App {

	public static void main(String[] args) throws Exception {
		User user = new User();
		UserDAO userDAO = new UserDAO();
		Scanner sc = new Scanner(System.in);
		Hoteis hoteis = new Hoteis();
		
		int menu;
			do {
				
				System.out.println("SISTEMA DE CADASTRO");
	            System.out.println("--------------------");
	            System.out.println("1 - CADASTRAR USUARIO");
	            System.out.println("2 - PESQUISAR");
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

					default:
						System.out.println("Até mais!");
						break;
					}
			} while (menu !=0);
		sc.close();
		

	}

}
