import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice, index;
		Scanner scanner = new Scanner(System.in);
		User loggedUser = null;
		
		ArrayList<User> listOfUsers = new ArrayList<User>();
		listOfUsers.add(new User("aborbora", "123", "victor"));
		listOfUsers.add(new User("abacaxi", "123", "kamila"));
		listOfUsers.add(new User("lol", "123", "jonas"));
		listOfUsers.add(new User("racha", "123", "junas"));
		listOfUsers.add(new User("animes", "123", "luizy"));
		
		while(true)
		{
			if(loggedUser == null)
			{
				System.out.println("******************IFACE******************");
				System.out.println("Acoes:\n1- Entrar;\n2 - Criacao de conta;");
				choice = scanner.nextInt();
		
				switch(choice)
				{
				case 1:
					loggedUser = User.loginIn(listOfUsers);
					break;
				case 2:
					listOfUsers.add(User.createUser(listOfUsers));
					break;		
				}
			}
			else
			{
				System.out.printf("Usuario " + loggedUser.getNick() + ", logado.\n");
				System.out.println("Acoes:\n1 - criacao/edicao de perfil;\n99 - sair.");
				choice = scanner.nextInt();
				if(loggedUser.getProfile() != null)Profile.printProfile(loggedUser.getProfile());
				
				switch(choice)
				{
				case 1:
					loggedUser.setProfile(Profile.editProfile(loggedUser.getProfile()));
					break;
				case 99:
					loggedUser = null;
					break;
				}
				
			}
		}
	}

}
