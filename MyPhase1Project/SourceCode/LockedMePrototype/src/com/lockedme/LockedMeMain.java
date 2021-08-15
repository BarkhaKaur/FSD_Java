package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeMain {

	static final String FOLDER_PATH = "C:\\Users\\Barkha\\Study\\Java\\simplilearn_First_Reddy\\Repo\\FSD_Java\\MyPhase1Project\\LockedMeFiles";

	public static void main(String[] args) 
	{
		//Variable Declaration
		Scanner scannerObj = new Scanner(System.in);
		int choice = 0; //Variable for Main Menu choice		
		String seeChoice; // Variable to hold Y/N if user wants to see main menu again
		int proceed = 1; //Variable to check if user wants to do more operations
		int mainMenuProceed = 1; //variable to see if user wants to see the main menu again.
		int invalidOuter = 0; //if user chooses other than numbers 1 to 5,set it to 1 to repeat the choices.
		
		//Display menu for the first time.
		displayMenu();
		do
		{		
			System.out.println("Enter your choice:");
			/* If user enters invalid option, the switch case will go to default value
			 * If a non-number is entered by user,it will throw NumberFormatException 
			*/
			try 
			{
				choice=Integer.parseInt(scannerObj.nextLine());
			}
			catch(NumberFormatException ne) 
			{
				choice = 0;
			}
			//Anything other than numbers 1-5 is not valid so repeat the loop.
			switch(choice)
			{
				case 1 :
					getAllFiles();
					//System.out.println("1");
					break;				
				case 2 :
					createFile(scannerObj);
					//System.out.println("2");
					break;					
				case 3 :
					deleteFile(scannerObj);
					//System.out.println("3");
					break;					
				case 4 :
					searchFile(scannerObj);
					//System.out.println("4");
					break;
				case 5 :
					proceed=0; //The outer do-while will only run if proceed==1
					System.out.println("GoodBye.Thank you for using our Application.");
					System.exit(0);					
				default :
					invalidOuter = 1;
					System.out.println("Invalid Option.Choose Numbers between 1 to 5.");
				
			} 
			/* If user chooses Invalid option then invalidOuter=1. 
			 * In that case, do not ask him if he wants to see the Menu again.
			 *
			 *This inner do-while loop is to cater for the case that user might choose wrong option.
			 *Y y N n are all correct options.
			 *
			 *The inner do while will run till User chooses the correct option
			 * */
			if(invalidOuter==0) 
			{
				do 
				{
					System.out.println("Would you like to see the Menu again? :Y/N");
					seeChoice = scannerObj.nextLine();
					if(seeChoice.equalsIgnoreCase("Y"))
					{	
						proceed = 1;
						mainMenuProceed = 0;
						displayMenu();
					}
					else if(seeChoice.equalsIgnoreCase("N"))
					{
						proceed = 0;//setting this to 0 will break out of the outer do-while
						mainMenuProceed = 0;//setting this to 0 will break out of the inner do-while
						System.out.println("GoodBye.Thank you for using our Application.");
					}
					else
					{
						System.out.println("Choose 'Y' or 'N'");
						mainMenuProceed = 1;
					}
				}while(mainMenuProceed==1);
			}
			invalidOuter = 0;
		}while(proceed==1);
		
		scannerObj.close();
	}
	
	public static void displayMenu()
	{
		System.out.println("*********************************************************");
		System.out.println("\t\tLockedMe.com");
		System.out.println("*********************************************************");
		System.out.println("1. Display all files");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
		System.out.println("*********************************************************");
		
	}
	
	/**
	 * This method gets all the files from the FOLDER_PATH
	 */
	public static void getAllFiles()
	{
		List<String> fileNames = FileManager.getAllFiles(FOLDER_PATH);
		for(String f:fileNames)
			System.out.println(f);
	}
	
	/**
	 * This method takes file name,number of lines and content from user
	 *  to create the file 
	 */
	public static void createFile(Scanner scanner)
	{
		//Variable declaration
		//Scanner scanner = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();
		
		//Read file name from user
		System.out.println("Enter file name");
		fileName=scanner.nextLine();
		
		//Read number of lines from user
		System.out.println("Enter how many lines in the file");
		linesCount = Integer.parseInt(scanner.nextLine());
		
		//Read lines from user
		for (int i=1; i<=linesCount;i++)
		{
			System.out.println("Enter line "+i+":");
			content.add(scanner.nextLine());
		}
		
		//Save the content into the file
		boolean isSaved = FileManager.addFiles(FOLDER_PATH, fileName, content);
		
		if(isSaved)
			System.out.println("File and Data saved successfully");
		else
			System.out.println("Some error occured.Please contact admin@lockedme.com");
		//scanner.close();
	}

	/**
	 * This method is used to get file name from the user to delete that file.
	 */
	public static void deleteFile(Scanner scannerObj)
	{
		//Code for deleting a file
		String fileNameDel;
	//	Scanner scannerObj = new Scanner(System.in);
		System.out.println("Enter file name to be deleted");
		fileNameDel = scannerObj.nextLine();
		boolean isDeleted = FileManager.deleteFile(FOLDER_PATH, fileNameDel);
		if(isDeleted) 
			System.out.println("File deleted successfully");
		else
			System.out.println("Unable to delete.Either file not there or some access issue.");
		//scannerObj.close();
	}
	
	/**
	 * This method takes in a file name and lets user know if its present
	 */
	public static void searchFile(Scanner scannerObj1) 
	{
		//Code for searching a file
		String fileNameSearch;
		//Scanner scannerObj1 = new Scanner(System.in);
		System.out.println("Enter file name to be searched");
		fileNameSearch = scannerObj1.nextLine();
		boolean isFound = FileManager.searchFile(FOLDER_PATH, fileNameSearch);
		if(isFound) 
			System.out.println("File is present in the folder ");
		else
			System.out.println("File is not present in the folder.");
		//scannerObj1.close();
	}	
	
	
}

