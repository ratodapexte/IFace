import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Community {

	private ArrayList<User> listOfMembers;
	private ArrayList<User> listOfPendentMembers;
	private String communityName;
	private String communityDescription;
	private User communityAdm;



	public Community(ArrayList<User> listOfMembers, ArrayList<User> listOfPendentMembers, String communityName,
			String communityDescription, User communityAdm)
	{
		super();
		this.listOfMembers = listOfMembers;
		this.communityName = communityName;
		this.communityDescription = communityDescription;
		this.communityAdm = communityAdm;
		this.listOfPendentMembers = listOfPendentMembers;
	}
	public ArrayList<User> getListOfPendentMembers()
	{
		return listOfPendentMembers;
	}

	public void setListOfPendentMembers(ArrayList<User> listOfPendentMembers) {
		this.listOfPendentMembers = listOfPendentMembers;
	}

	public ArrayList<User> getListOfMembers()
	{
		return listOfMembers;
	}
	public void setListOfMembers(ArrayList<User> listOfMembers)
	{
		this.listOfMembers = listOfMembers;
	}
	public String getCommunityName()
	{
		return communityName;
	}
	public void setCommunityName(String communityName)
	{
		this.communityName = communityName;
	}
	public String getCommunityDescription()
	{
		return communityDescription;
	}
	public void setCommunityDescription(String communityDescription)
	{
		this.communityDescription = communityDescription;
	}
	public User getCommunityAdm()
	{
		return communityAdm;
	}
	public void setCommunityAdm(User communityAdm)
	{
		this.communityAdm = communityAdm;
	}

	public static boolean isThereCommunity(ArrayList<User> listOfUsers, String communityName)
	{
		for (User user : listOfUsers) {
			if(user.getCommunity() != null)
			{
				if(user.getCommunity().getCommunityName().equals(communityName) == true)
					return true;
				}
			}
		return false;
	}

	public static User createCommunity(ArrayList<User> listOfUsers, User loggedUser)
	{

		ArrayList<User> listOfMembers = new ArrayList<User>(), listOfPendentMembers = new ArrayList<User>();
		Community community;
		Scanner scanner = new Scanner(System.in);
		String communityName;
		String communityDescription;
		User communityAdm = loggedUser;

		System.out.print("Entre com um nome para uma comunidade.\nNome: ");
		communityName = scanner.nextLine();

		while(isThereCommunity(listOfUsers, communityName) == true)
		{
			System.out.print("Nome ja cadastrado, digite outro nome.\nNome:");
			communityName = scanner.nextLine();
		}

		System.out.print("Entre com uma descricao para a comunidade.\nDescricao:");
		communityDescription = scanner.nextLine();

		community = new Community(listOfMembers, listOfPendentMembers, communityName, communityDescription, communityAdm);

		loggedUser.setCommunity(community);

		return loggedUser;
	}

	public static ArrayList<User> joinCommunity(ArrayList<User> listOfUsers, User loggedUser)
	{
		ArrayList<User> auxList;
		int index;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome da Comunidade que deseja entrar.\nComunidade: ");
		String communityName = scanner.nextLine();
		if(loggedUser.getCommunity() != null)
		{
			if(communityName.equals(loggedUser.getCommunity().getCommunityName()) ==  true)
			System.out.println("Comunidade ja te pertence.");
		}
			while(isThereCommunity(listOfUsers, communityName) == false)
			{
				System.out.println("Digite o nome de uma Comunidade existente.\nComunidade: ");
				communityName = scanner.nextLine();
			}

			for (User user : listOfUsers) {
				if(user.getCommunity() != null)
				{
					if(user.getCommunity().getCommunityName().equals(communityName))
					{
						index = listOfUsers.indexOf(user);
						auxList = listOfUsers.get(index).getCommunity().getListOfPendentMembers();
						auxList.add(loggedUser);
						listOfUsers.get(index).getCommunity().setListOfPendentMembers(auxList);
						System.out.println("Solocitacao enviada.");
						break;
					}
				}
			}


		return listOfUsers;
	}
	//////rever
	public static ArrayList<User> manageMembers(ArrayList<User> listOfUsers, User loggedUser)
	{
		ArrayList<User> listOfMembersTemp = new ArrayList<User>();
		int choice;
		Scanner scanner = new Scanner(System.in);

		for (User user : loggedUser.getCommunity().getListOfMembers()) {
			System.out.print("Deseja excluir " + user.getNick() + " da comunidade? 1(SIM) ou X(NAO).\nOpcao: ");

			choice = Deleted.returnInt();

			if(choice == 1)
			{
				user.setJoinedCommunity(null);
				System.out.println("\nMembro excluido.");
			}
			else
			{
				listOfMembersTemp.add(user);
				System.out.println("\nMembro mantido.");
			}
		}
		loggedUser.getCommunity().setListOfMembers(listOfMembersTemp);
		return listOfUsers;
	}
	////rever
	public static ArrayList<User> managePendentMembers(ArrayList<User> listOfUsers, User loggedUser)
	{
		ArrayList<User> listOfPendentMembersTemp = new ArrayList<User>();
		ArrayList<User> listOfMembersTemp = loggedUser.getCommunity().listOfMembers;
		Scanner scanner = new Scanner(System.in);
		int choice;

		for (User user : loggedUser.getCommunity().listOfPendentMembers) {
			System.out.print("Deseja aceitar " + user.getNick() + " na comunidade? 1(SIM) ou X(NAO).\nOpcao: ");

			choice = Deleted.returnInt();

			if(choice == 1)
			{
				listOfMembersTemp.add(user);
				user.setJoinedCommunity(loggedUser.getCommunity());
//				listOfUsers.set(listOfUsers.indexOf(user), user);
				System.out.println("\nMembro adicionado.");
			}
		}

		loggedUser.getCommunity().setListOfMembers(listOfMembersTemp);
		loggedUser.getCommunity().setListOfPendentMembers(listOfPendentMembersTemp);

		return listOfUsers;
	}

	public static ArrayList<User> manageCommunity(ArrayList<User> listOfUsers, User loggedUser)
	{
		System.out.print("\nMenu de gerenciamento de comunidade\n");

		System.out.printf(loggedUser.getCommunity().communityName);
		System.out.printf("\nDescricao: " + loggedUser.getCommunity().communityDescription);
		int choice;

		Scanner scanner = new Scanner(System.in);

		while(true)
		{
			System.out.println("\n1 - Gerenciar membros;\n2 - Gerenciar membros pendentes;\n3 - sair da tela de gerenciamento");

			choice = Deleted.returnInt();

			switch(choice)
			{
			case 1:
				if(loggedUser.getCommunity().listOfMembers != null)
					listOfUsers = manageMembers(listOfUsers, loggedUser);
				else
					System.out.println("Comunidade sem membros para gerenciar.");
				break;
			case 2:
				if(loggedUser.getCommunity().listOfPendentMembers != null)
					listOfUsers = managePendentMembers(listOfUsers, loggedUser);
				else
					System.out.println("Comunidade sem solicitacoes pendentes.");
				break;
			}
			if(choice == 3)
				break;
		}
//		listOfUsers.set(listOfUsers.indexOf(loggedUser), loggedUser);
		return listOfUsers;
	}

}
