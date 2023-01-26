package assign02;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Java class represents an unordered collection of University of Utah students enrolled in CS 2420.
 * 
 * NOTE: The word "Class" in the name of this Java class means a collection of students and should not 
 *       be confused with the Java term class, which is a blueprint for making objects.
 * 
 * @author Erin Parker and Everett Oglesby
 * @version January 20, 2022
 */
public class CS2420ClassGeneric<Type> {

	private ArrayList<CS2420StudentGeneric> studentList;
	
	/**
	 * Creates an empty CS 2420 class.
	 */
	public CS2420ClassGeneric() {
		this.studentList = new ArrayList<CS2420StudentGeneric>();
		System.out.println("Clone Test...");
	}
	
	/**
	 * Adds the given student to the collection of students in CS 2420, avoiding duplicates.
	 * 
	 * @param student - student to be added to this CS 2420 class
	 * @return true if the student was added, 
	 *         false if the student was not added because they already exist in the collection
	 */
	public boolean addStudent(CS2420StudentGeneric student) {
		
		// Add for 
		for(CS2420StudentGeneric existingStudent : studentList) {
		
			if( existingStudent.equals(student) ) {
				return false;
			}
			
		}
		studentList.add(student);
		return true;
	}
	
	/**
	 * Retrieves the CS 2420 student with the given uNID.
	 * 
	 * @param uNID - uNID of student to be retrieved
	 * @return the CS 2420 student with the given uNID, or null if no such student exists in the collection
	 */
	public CS2420StudentGeneric lookup(int uNID) 
	{
		for(CS2420StudentGeneric student : studentList) {
			
			if(student.getUNID() == uNID) {
				
				return student;
			}
		}
		
		return null;
	}
	
	/**
	 * Retrieves the CS 2420 student(s) with the given contact information.
	 * 
	 * @param contactInfo - contact information of student(s) to be retrieved
	 * @return a list of the CS 2420 student(s) with the given contact information (in any order), 
	 * 	     or an empty list if no such students exist in the collection
	 */
	public ArrayList<CS2420StudentGeneric<Type>> lookup(Type contactInfo) {
		
		ArrayList<CS2420StudentGeneric<Type>> studentsSelected = new ArrayList<CS2420StudentGeneric<Type>>();
		
		for(int i = 0; i < studentList.size(); i++) {
			
			
			if(studentList.get(i).getContactInfo().equals(contactInfo)) {
				
				//System.out.println("found valid contact info"); // Added for testing.
				
				studentsSelected.add(studentList.get(i));				
			}
		}
		
		return studentsSelected;
	}
	
	/**
	 * Adds an assignment, exam, lab, or quiz score for the CS 2420 student with the given uNID.
	 * 
	 * NOTE: If the category string is not one of "assignment", "exam", "lab", or "quiz", or
	 *       if no student with the uNID exists in the collection, then this method has no effect.
	 * 
	 * @param uNID - uNID of student whose score is to be added
	 * @param score - the score to be added
	 * @param category - the category in which to add the score
	 */
	public void addScore(int uNID, double score, String category) 
	{
		CS2420StudentGeneric currentStudent = lookup(uNID);
		
		if(currentStudent != null) {
			
			currentStudent.addScore(score, category);
		} else {
			
			System.out.println("Could not find the category: " + category);
		}
	}
	
	/**
	 * Computes the average score of all CS 2420 students in the collection.
	 * 
	 * @return the average score, or 0 if there are no students in the collection
	 */
	public double computeClassAverage() 
	{
		double averageScore = 0;
		int classSize = 0;
		for(int i = 0; i < studentList.size(); i++)
		{
			averageScore += studentList.get(i).computeFinalScore();
			
			classSize ++;
		}
		
		if(classSize <= 0)
		{
			return 0;
		}
		else
		{
			averageScore = averageScore / (double) classSize;
			return averageScore;
		}
	}
	
	/**
	 * Creates a list of contact information for all CS 2420 students in the collection.
	 *
	 * @return the duplicate-free list of contact information, in any order
	 */
	public ArrayList<Type> getContactList() {

		ArrayList<Type> contactInfos = new ArrayList<Type>();
		for(int i = 0; i < studentList.size(); i++)
		{
			Type currentInfo = (Type)studentList.get(i).getContactInfo();
			boolean infoFound = false;
		
			for(Type email: contactInfos)
			{
				if(email.equals(currentInfo))
				{
					infoFound = true;
				}


			}
			if(!infoFound)
			{
				contactInfos.add(currentInfo);
			}


		}
		return contactInfos;
	}
	
}
