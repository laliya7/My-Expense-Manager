import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManageExpenseRead {
	
	//this program is to read details from the text file which i created in the -->
	//ManageMyExpenses.java file
	public void Read() {
	BufferedReader br = null;
	
	try {
	br = new BufferedReader (new FileReader("Expense Details.txt"));
	String line;
	
	while((line = br.readLine()) != null) {
		System.out.println(line);
	}
	} catch(IOException ex) {
		ex.printStackTrace();
	} finally {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
}
