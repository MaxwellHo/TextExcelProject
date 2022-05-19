package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args) //My MAIN METHOD
	{
		Spreadsheet sheet = new Spreadsheet();
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter a command: ");
		String command = scanner.nextLine();
	    while(!scanner.equals("quit")) {
	    	System.out.println(sheet.processCommand(command));
	    	System.out.println("Enter a command: ");
	    	command = scanner.nextLine();
	    	
	    }
	    scanner.close();
	}

}
