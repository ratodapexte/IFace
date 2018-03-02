import java.util.ArrayList;
import java.util.Scanner;


public class User {

//	public ArrayList<String> listOfAttribute;
	private String login;
	private String password;
	private String nick;
	private Profile profile = null;// = new Profile(listOfAttribute, listOfAttribute);
	
	public User(String login, String password, String nick) 
	{
		super();
		this.login = login;
		this.password = password;
		this.nick = nick;
	}
	
	public String getLogin() 
	{
		return login;
	}
	public void setLogin(String login)
	{
		this.login = login;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getNick() 
	{
		return nick;
	}
	public void setNick(String nick) 
	{
		this.nick = nick;
	}	
	public Profile getProfile() 
	{
		return profile;
	}

	public void setProfile(Profile profile)
	{
		this.profile = profile;
	}

	public static boolean isNameRegistred(ArrayList<User> listOfUser, String name)
	{
		for (User user : listOfUser) {
			if(user.nick.equals(name))
				return true;
		}
		return false;
	}
	
	public static boolean isLoginRegistred(ArrayList<User> listOfUser, String login)
	{
		for (User user : listOfUser) {
			if(user.login.equals(login))
				return true;
		}
		return false;
	}
	
	public static int indexOfUser(ArrayList<User> listOfUser, String login)
	{
		int size = listOfUser.size();
		for (int i = 0; i < size; i++) {
			if(listOfUser.get(i).login.equals(login))
				return i;
		}
		return -1;
	}
	
	public static User createUser(ArrayList<User> listOfUser)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("****MENU DE CRIACAO DE CONTA****");
		System.out.print("\nNome de usuario: ");
		String nick = scanner.nextLine();
		
		while(isNameRegistred(listOfUser, nick) == true)
		{
			System.out.print("Nome ja cadastrado!!!\nNome de usuario: ");
		    nick = scanner.nextLine();
		}
		System.out.print("\nLogin do usuario: ");
		String login = scanner.nextLine();
		
		while(isLoginRegistred(listOfUser, login) == true)
		{
			System.out.print("login ja cadastrado!!!\nLogin de usuario: ");
		    login = scanner.nextLine();
		}
		
		System.out.print("\nSenha do usuario: ");
		String password = scanner.nextLine();
		
		User user = new User(login, password, nick);
		
		System.out.println("aeeeeeeeeeeee");
		
		return user;
	}
	
	public static User loginIn(ArrayList<User> listOfUsers)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Login: ");
		String login = scanner.nextLine();
		
		while(isLoginRegistred(listOfUsers, login) == false)
		{
			System.out.print("Login nao cadastrado!!!\nLogin: ");
		    login = scanner.nextLine();
		}
		int index = indexOfUser(listOfUsers, login);
		
		System.out.print("Senha: ");
		String password = scanner.nextLine();
		
		while(listOfUsers.get(index).password.equals(password) == false)
		{
			System.out.print("Senha incorreta!!!\nSenha: ");
			password = scanner.nextLine();
		}
		
		return listOfUsers.get(index);
	}
}
