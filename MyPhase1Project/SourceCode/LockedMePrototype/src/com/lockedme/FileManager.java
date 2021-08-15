package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager {

	/**
	 * This method will return file names in ascending order from the folderPath
	 * @param folderPath
	 * @return List<String>
	 */
	public static List<String> getAllFiles(String folderPath)
	{
		//Creating file object
		File dir = new File(folderPath);
		
		//Getting all the files into file array
		File[] listOfFiles = dir.listFiles();
		
		//Declare a list to store file names
		List<String> fileNames = new ArrayList<String>();
		
		for(File f:listOfFiles)
			fileNames.add(f.getName());
		
		//sort the files
		Collections.sort(fileNames);
		
		return fileNames;
	}
	
	/**
	 * This method will add or append the content into the specified file
	 * @param folderPath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	
	public static boolean addFiles(String folderPath,String fileName,List<String> content)	
	{
		File file = new File(folderPath,fileName);
		
		//To add or append content to File
		try(FileWriter fileWriter = new FileWriter(file,true))
		{
			for(String s:content) 
			{
				//Write content into the file
				fileWriter.write(s + System.lineSeparator());
			}
			return true;
		}
		catch(Exception ex) 
		{
			return false;
		}		
	}
	
	/**
	 * This method will delete the file if it exists
	 * @param folderPath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean deleteFile(String folderPath,String fileName) 
	{
		//adding folderpath with file name and creating file object
		File file = new File(folderPath + "\\" + fileName);
		
		//	return true if delete is successful
		try 
		{
			if(file.delete())
				return true;
			else
				return false;
		}
		catch(Exception ex) 
		{
			return false;
		}		
		
	}
	
	/**
	 * This method will search file from the folder.
	 * @param folderPath
	 * @param fileName
	 * @return
	 */
	public static boolean searchFile(String folderPath,String fileName) 
	{
		//adding folderPath with file name and creating file object
		File file = new File(folderPath + "\\" + fileName);
		//return true if file exists
		try 
		{
			if(file.exists())
				return true;
			else
				return false;
		}
		catch(Exception ex) 
		{
			return false;
		}		
		
	}
	
	
}
