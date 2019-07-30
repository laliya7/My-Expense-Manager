import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class ADD{
	
	//this is class to add items on list
	String name;
	int amount;
	int liability;
	
	Date date = new Date();
	
	public ADD(String name, int amount, int liability) {
		this.name = name;
		this.amount = amount;
		this.liability = liability;
	}
	public void addingDetails(){
		
		//creating files to store details
		try {
	File expenseFile = new File("Expense Details.txt");

	
		PrintWriter pw = new PrintWriter(expenseFile);
		
		//printing on file
		pw.print("Added date: ");
		pw.print(date);
		
		pw.println();
		
		pw.print("Name: ");
		pw.println(name);
		
		pw.print("Amount: ");
		pw.println(amount);
		
		pw.print("Due: ");
		pw.println(liability);
		pw.println();
		pw.close();
		
		//if file not found
	} catch (FileNotFoundException e) {
		System.out.println("Error!");
		e.printStackTrace();
	}
		
		System.out.println("\nExpense added!\n");
	
	}
	//to change details
	public void editDetails(String editName, int editAmount, int editDue) {
		
		this.name = editName;
		this.amount = editAmount;
		this.liability = editDue;
	}
}

public class ManageMyExpenses {

	public static void main(String[] args) {
		
		//Vector<String> vec = new Vector<String>();
		
		Scanner input = new Scanner(System.in);
		Scanner details = new Scanner(System.in);
		
		int chooseOption;
		String name, newName;
		int amount1, newAmount, newDue, process=1;
		int due;
		
		//main view of application
		while(process<1000) {
		System.out.println("1. Add\n2. View\n3. Edit Details\n4. Exit");
		chooseOption = input.nextInt();
		
		switch(chooseOption) {
		
		//switching the options
		case 1:
			//this case add items on the list
			System.out.println("Enter name: ");
			name = details.nextLine();
			
			System.out.print("Enter amount: ");
			amount1 = details.nextInt();
			
			System.out.print("Enter due: ");
			due = details.nextInt();
			
			ADD newExpense = new ADD(name, amount1, due);
			newExpense.addingDetails();
			break;
		
		case 2:
			//to view details of item
			System.out.print("\n**Details** ");
			System.out.println();
			ManageExpenseRead readFile = new ManageExpenseRead();
			readFile.Read();
			break;
			
		case 3:
			//this is to edit added expense
			System.out.print("Enter new name: ");
			newName = details.nextLine();
			if(details.hasNextLine()) {
				newName = details.nextLine();
			}
			System.out.print("Enter new amount: ");
			newAmount = details.nextInt();
			System.out.print("Enter new due: ");
			newDue = details.nextInt();
			
			
			ADD editExpense = new ADD(newName, newAmount, newDue);
			editExpense.editDetails(newName, newAmount, newDue);
			
			System.out.println("\nEdit success!\n");
			break;
			
		case 4:
			//to exit the program
			System.out.println("Program terminated!");
			System.exit(0);
			
		}
		process++;
		}
		
		input.close();
		details.close();

	}

}
