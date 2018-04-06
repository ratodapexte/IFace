import java.util.ArrayList;
import java.util.Scanner;


public class User {

//	public ArrayList<String> listOfAttribute;
	private String login;
	private String password;
	private String nick;
	private Profile profile;// = new Profile(ArrayList<String> listOfAttribute, ArrayList<String> listOfAttribute);
	private Friend friend;
	private ArrayList<Message> listOfMessage;
	private Community community;
	private Community joinedCommunity;

	public User(String login, String password, String nick, Profile profile, Friend friend, ArrayList<Message> listOfMessage, Community community) {
		super();
		this.login = login;
		this.password = password;
		this.nick = nick;
		this.profile = profile;
		this.friend = friend;
		this.listOfMessage = listOfMessage;
		this.community = community;
	}

	public Community getJoinedCommunity()
	{
		return joinedCommunity;
	}
	public void setJoinedCommunity(Community joinedCommunity)
	{
		this.joinedCommunity = joinedCommunity;
	}
	public Community getCommunity()
	{
		return community;
	}
	public void setCommunity(Community community)
	{
		this.community = community;
	}
	public ArrayList<Message> getListOfMessage()
	{
		return listOfMessage;
	}
	public void setListOfMessage(ArrayList<Message> listOfMessage)
	{
		this.listOfMessage = listOfMessage;
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

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
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

	public static int indexOfUserByNick(ArrayList<User> listOfUser, String nick)
	{
		int size = listOfUser.size();
		for (int i = 0; i < size; i++) {
			if(listOfUser.get(i).nick.equals(nick))
				return i;
		}
		return -1;
	}


	public static User createUser(ArrayList<User> listOfUser)
	{
		Scanner scanner = new Scanner(System.in);

		ArrayList<Message> listOfMessage = new ArrayList<Message>();
		ArrayList<String> listOfAttribute = new ArrayList<String>();
		ArrayList<String> listOfAttributeFeature = new ArrayList<String>();
		ArrayList<User> listOfFriends = new ArrayList<User>(), listOfPendentFriends = new ArrayList<User>();
		Friend friend = new Friend(listOfFriends, listOfPendentFriends);

		Profile initProfile = new Profile(listOfAttribute, listOfAttributeFeature);

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

		User user = new User(login, password, nick, initProfile, friend, listOfMessage, null);

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

	public static ArrayList<User> friendRequest(ArrayList<User> listOfUsers, User user)
	{

		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome do usuario a ser adicionado.");
		System.out.print("Nome: ");

		String nick = scanner.nextLine();

		while(user.nick.equals(nick) == true)
		{
			System.out.print("Voce nao pode se adicionar.'-'\nNome: ");
			nick = scanner.nextLine();
		}

		while(User.isNameRegistred(listOfUsers, nick) == false)
		{
			System.out.print("Nome nao cadastrado.\nNome: ");
			nick = scanner.nextLine();
		}

		while(User.isNameRegistred(user.getFriend().getListOfFriends(), nick) == true)
		{
			System.out.print("Usuario ja adicionado.\nNome: ");
			nick = scanner.nextLine();
		}

		while(User.isNameRegistred(user.getFriend().getListOfPendentFriends(), nick) == true)
		{
			System.out.print("Usuario ja solicita a sua amizade.\nNome: ");
			nick = scanner.nextLine();
		}

		int index = indexOfUserByNick(listOfUsers, nick);

		listOfUsers.get(index).friend = Friend.sendInvitation(listOfUsers.get(index).friend, user);

		return listOfUsers;
	}


}
