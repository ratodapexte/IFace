import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Message> listOfMessage = new ArrayList<Message>();
		ArrayList<String> listOfAttribute = new ArrayList<String>();
		ArrayList<String> listOfAttributeFeature = new ArrayList<String>();
		ArrayList<User> listOfFriends = new ArrayList<User>(), listOfPendentFriends = new ArrayList<User>();
		Friend friend = new Friend(listOfFriends, listOfPendentFriends);
		int choice, index, communityNum = 0;
		Profile initProfile = new Profile(listOfAttribute, listOfAttributeFeature);
		Scanner scanner = new Scanner(System.in);
		String choice2;
		User loggedUser = null, zeroUser = new User("", "", "", initProfile, friend, listOfMessage, null);



		ArrayList<User> listOfUsers = new ArrayList<User>();
		listOfUsers.add(new User("aborbora", "123", "victor", initProfile, friend, listOfMessage, null));
		listOfUsers.add(new User("abacaxi", "123", "kamila", initProfile, friend, listOfMessage, null));
		listOfUsers.add(new User("lol", "123", "jonas", initProfile, friend, listOfMessage, null));
		listOfUsers.add(new User("racha", "123", "junas", initProfile, friend, listOfMessage, null));
		listOfUsers.add(new User("animes", "123", "luizy", initProfile, friend, listOfMessage, null));

		while(true)
		{
			if(loggedUser == null)
			{
				System.out.println("******************IFACE******************");
				System.out.println("Acoes:\n1- Entrar;\n2 - Criacao de conta;");

				choice = Deleted.returnInt();

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
				Profile.printProfile(loggedUser.getProfile());
				System.out.printf("\n" + Friend.showInvitationQnt(loggedUser.getFriend()) + " solicitacoes de amizade.\n");
				System.out.println("\nAcoes:\n1 - criacao/edicao de perfil;\n2 - enviar pedido de amizade;\n"
						+ "3 - pedidos de amizade;\n4 - enviar mensagem;");

				if(loggedUser.getCommunity() == null)
					System.out.println("7 - criar comunidade;");
				else
					System.out.println("7 - gerenciar comunidade;");

				if(loggedUser.getJoinedCommunity() == null)
				{
					System.out.println("8 - participar de comunidade;\n99 - sair.");
				}
				else
					System.out.println("8 - ver comunidade que participa;\n99 - sair.");

				choice = Deleted.returnInt();

				switch(choice)
				{
				case 1:
					loggedUser.setProfile(Profile.editProfile(loggedUser.getProfile()));
					break;
				case 2:
					listOfUsers = User.friendRequest(listOfUsers, loggedUser);
					break;
				case 3:
					if(loggedUser.getFriend().getListOfPendentFriends().size() == 0)
						System.out.println("Sem pedidos de amizade.\n");
					else
						//loggedUser.setFriend(Friend.acceptInvitation(loggedUser.getFriend()));
						listOfUsers = Friend.acceptInvitation(loggedUser, listOfUsers);
					break;
				case 4:
					listOfUsers = Message.sendMessage(loggedUser, listOfUsers);
					break;
				case 7:
					if(loggedUser.getCommunity() == null)
						{
						loggedUser = Community.createCommunity(listOfUsers, loggedUser);
						communityNum ++;
						}
					else
						listOfUsers = Community.manageCommunity(listOfUsers, loggedUser);
					break;
				case 8:
					if(loggedUser.getJoinedCommunity() == null)
					{
						if(communityNum == 0)
							System.out.println("Nenhuma comunidade foi criada.");
						else
							listOfUsers = Community.joinCommunity(listOfUsers, loggedUser);
					}
					else
						System.out.println("\nComunidade: " + loggedUser.getJoinedCommunity().getCommunityName());
					break;
				case 10:
					listOfUsers.remove(loggedUser);
					loggedUser = null;
					System.out.println("Usuário deletado do sistema.");
					break;
				case 96:
					System.out.println("Community name: " + loggedUser.getCommunity().getCommunityName() +
						"\nDescription: " + loggedUser.getCommunity().getCommunityDescription());
					break;
				case 97:
					Friend.showFriendList(loggedUser.getFriend().getListOfFriends());
					break;
				case 98:
					Message.showMessages(loggedUser);
					break;
				case 99:
					loggedUser = null;
					break;
				}
			}
		}
	}
//salvando
}
