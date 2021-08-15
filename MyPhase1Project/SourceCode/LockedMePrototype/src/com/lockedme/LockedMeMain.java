package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeMain {

	static final String FOLDER_PATH = "C:\\Users\\Barkha\\Study\\Java\\simplilearn_First_Reddy\\Repo\\FSD_Java\\MyPhase1Project\\LockedMeFiles";

	public static void main(String[] args) 
	{
		System.out.println("*********************************************************");
		System.out.println("\t\tLockedMe.com");
		System.out.println("*********************************************************");
		System.out.println("1. Display all files.");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
		System.out.println("*********************************************************");
		System.out.println("Enter your choice:");
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
	 * This method takes file name,number of lines and content from user to create the file 
	 */
	public static void createFiles()
	{
		//Variable declaration
		Scanner scanner = new Scanner(System.in);
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
		scanner.close();
	}

	/**
	 * This method is used to get file name from the user to delete that file.
	 */
	public static void deleteFile()
	{
		//Code for deleting a file
		String fileNameDel;
		Scanner scannerObj = new Scanner(System.in);
		System.out.println("Enter file name to be deleted");
		fileNameDel = scannerObj.nextLine();
		boolean isDeleted = FileManager.deleteFile(FOLDER_PATH, fileNameDel);
		if(isDeleted) 
			System.out.println("File deleted successfully");
		else
			System.out.println("Unable to delete.Either file not there or some access issue.");
		scannerObj.close();
	}
	
	/**
	 * This method takes in a file name and lets user know if its present
	 */
	public static void searchFile() 
	{
		//Code for searching a file
		String fileNameSearch;
		Scanner scannerObj1 = new Scanner(System.in);
		System.out.println("Enter file name to be searched");
		fileNameSearch = scannerObj1.nextLine();
		boolean isFound = FileManager.searchFile(FOLDER_PATH, fileNameSearch);
		if(isFound) 
			System.out.println("File is present in the folder ");
		else
			System.out.println("File is not present in the folder.");
		scannerObj1.close();
	}	
	
	
}

