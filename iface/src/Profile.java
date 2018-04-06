import java.util.ArrayList;
import java.util.Scanner;

public class Profile {

	private ArrayList<String> listOfAttribute = new ArrayList<String>();
	private ArrayList<String> listOfAttributeFeature = new ArrayList<String>();
	
	
	public static boolean isThereAttribute(Profile profile, String attribute)
	{
		for (String string : profile.listOfAttribute) {
			if(string.equals(attribute))
				return true;
		}
		return false;
	}
	
	public Profile(ArrayList<String> listOfAttribute,
			ArrayList<String> listOfAttributeFeature) {
		super();
		this.listOfAttribute = listOfAttribute;
		this.listOfAttributeFeature = listOfAttributeFeature;
	}

	public static void printProfile(Profile profile)
	{
		int size = profile.listOfAttribute.size();
		
		for (int i = 0; i < size; i++) 
		{
			System.out.println(profile.listOfAttribute.get(i) + ": " + profile.listOfAttributeFeature.get(i) + ".");
		}
		
	}
	
	public static Profile editProfile(Profile profile)
	{
		Profile tempProfile;
		Scanner scanner = new Scanner(System.in);
		String newFeature;
		
		System.out.println("Digite o nome do atributo a ser adicionado/cadastrado: ");
		System.out.print("Nome: ");
		String attribute = scanner.nextLine();
		
		if(isThereAttribute(profile, attribute) == true)
		{
			System.out.println("O atributto informado será editado.");
			int index = profile.listOfAttribute.indexOf(attribute);
			System.out.print("Descricao do atributo: ");
			newFeature = scanner.nextLine();
			
			profile.listOfAttributeFeature.set(index, newFeature);
		}
		else
		{
			System.out.println("O atributto informado foi criado.");
			System.out.print("Descricao do atributo: ");
			newFeature = scanner.nextLine();
			
			profile.listOfAttribute.add(attribute);
			profile.listOfAttributeFeature.add(newFeature);
		}
		System.out.println("Atributo editado/criado com sucesso.");
		
		return profile;
	}
}
