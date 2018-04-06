import java.util.ArrayList;
import java.util.Scanner;

public class Message {

	private User sender;
	private String message;

	public Message(User sender, String message) {
		super();
		this.sender = sender;
		this.message = message;
	}
	
	public static ArrayList<User> sendMessage(User loggedUser, ArrayList<User> listOfUsers)
	{
		int i = 0, choice;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Amigos adicionados. Escolha um para enviar a mensagem.");
		for (User user2 : loggedUser.getFriend().getListOfFriends()) {
			System.out.printf(i + " - " + loggedUser.getNick() +";\n");
		i++;
		}
		
		System.out.print("Escolha um número: ");	
		choice = Deleted.returnInt();
		scanner.nextLine();
		
		System.out.print("Escreva a mensagem: ");
		String message = scanner.nextLine();
		
		User reciever = loggedUser.getFriend().getListOfFriends().get(choice);
		//ArrayList<Message> listOfMessage = reciever.getListOfMessage();
		Message message2 = new Message(loggedUser, message);		
		//listOfMessage.add(message2);
		
		listOfUsers.get(listOfUsers.indexOf(reciever)).getListOfMessage().add(message2);
		listOfUsers.get(listOfUsers.indexOf(loggedUser)).getListOfMessage().add(message2);
		
		
		return listOfUsers;
	}



	public static void showMessages(User user)
	{
		for (Message message : user.getListOfMessage()) {
			System.out.println(message.sender.getNick() + ": " + message.message);
		}
	}


}
