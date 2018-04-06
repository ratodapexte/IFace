import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Deleted {
	private ArrayList<User> lastDeletedFriends;
	private ArrayList<Message> listOfDeletedMessage;
	private Community lastJoinedCommunity;
	private Profile deletedAtributtes;
	
	public static int returnInt()
	{
		Scanner scanner = new Scanner(System.in);
		int choice;
		while(true)
		{
			try
			{
				System.out.print("Opcao: ");
				choice = scanner.nextInt();
				break;
			}
			catch(InputMismatchException e)
			{
				System.out.print("Apenas inteiro. Opcao: ");
				scanner.nextLine();
			}
		}
		
		return choice;
	}
	
	public static ArrayList<User> deleteFriend(ArrayList<User> listOfUser, User loggedUser)
	{
		scanner
		for (User user : listOfUser) {
			
		}
		return listOfUser;
	}
	
	public static ArrayList<User> deleteMenu(ArrayList<User> listOfUser, User loggedUser)
	{
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		while(true)
		{
			System.out.println("\nMenu de exclusao/recuperacao de dados");
			System.out.println("1 - Deletar amigo");
			
			choice = returnInt();
			
			switch(choice)
			{
			case 1:
				listOfUser = deleteFriend(listOfUser, loggedUser);
				break;
			}
		}
		
		
		return listOfUser;
	}
}
