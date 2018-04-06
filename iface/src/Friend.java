import java.util.ArrayList;
import java.util.Scanner;

public class Friend {
	private ArrayList<User> listOfFriends;
	private ArrayList<User> listOfPendentFriends;

	public Friend(ArrayList<User> listOfFriends, ArrayList<User> listOfPendentFriends) {
		this.listOfFriends = listOfFriends;
		this.listOfPendentFriends = listOfPendentFriends;
	}

	public ArrayList<User> getListOfFriends() 
	{
		return listOfFriends;
	}
	public void setListOfFriends(ArrayList<User> listOfFriends)
	{
		this.listOfFriends = listOfFriends;
	}
	public ArrayList<User> getListOfPendentFriends() 
	{
		return listOfPendentFriends;
	}
	public void setListOfPendentFriends(ArrayList<User> listOfPendentFriends)
	{
		this.listOfPendentFriends = listOfPendentFriends;
	}

	public static Friend sendInvitation(Friend friend, User user)
	{
		friend.listOfPendentFriends.add(user);
		return friend;
	}
	
	public static Friend removeRequest(Friend friend, int index)
	{
		friend.listOfPendentFriends.remove(index);
		return friend;
	}
	public static int showInvitationQnt(Friend friend)
	{
		int i = 0;
		for (User user : friend.listOfPendentFriends) {
			i++;
		}
		return i;
	}
	
	public static ArrayList<User> acceptInvitation(User loggedUser, ArrayList<User> listOfUsers)
	{
		Scanner scanner = new Scanner(System.in);
		int choice;
		ArrayList<User> listOfFriends = loggedUser.getFriend().getListOfFriends();
		ArrayList<User> listOfPendentFriends = new ArrayList<User>(); //loggedUser.getFriend().getListOfPendentFriends();
		//User user;
		
		for (User user : loggedUser.getFriend().getListOfPendentFriends()) {
			System.out.print(user.getNick() + " deseja ser seu amigo. 1(sim) ou 2 (nao).\n");
		
			choice = Deleted.returnInt();
			if(choice == 1) 
			{
				listOfFriends.add(user);
				//listOfPendentFriends.remove(user);
				user.getFriend().getListOfFriends().add(loggedUser);
			}
			else
				listOfPendentFriends.add(user);
		}
		
		loggedUser.getFriend().setListOfFriends(listOfFriends);
		loggedUser.getFriend().setListOfPendentFriends(listOfPendentFriends);
		
		return listOfUsers;
	}
	
	public static void showFriendList(ArrayList<User> listOfFriends)
	{
		for (User user : listOfFriends) {
			System.out.printf("Nome: " + user.getNick() + ".\n");
		}
	}
}
