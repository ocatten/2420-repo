package assign02;
/**
 * This Java class represents an unordered collection of University of Utah students enrolled in CS 2420.
 * This class is nearly identical to the CS2420Class, but utilizes the generic type values for wider
 * implementation.
 * 
 * NOTE: The word "Class" in the name of this Java class means a collection of students and should not 
 *       be confused with the Java term class, which is a blueprint for making objects.
 *
 * @author Erin Parker, Parker Catten, and Everett Oglesby
 * @version January 20, 2022
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class CS2420ClassGeneric<Type> {

	private ArrayList<CS2420StudentGeneric> studentList;
	

	/**
	 * Creates an empty CS 2420 class.
	 */
	public CS2420ClassGeneric() {

		// Sets up the relevant fields.
		this.studentList = new ArrayList<CS2420StudentGeneric>();
	}
	
	
	

	/**
	 * Adds the given student to the collection of students in CS 2420, avoiding duplicates.
	 * 
	 * @param student - student to be added to this CS 2420 class
	 * @return true if the student was added, 
	 *         false if the student was not added because they already exist in the collection
	 */
	public boolean addStudent(CS2420StudentGeneric student) {
		

		// Loops through each student that's already in the class
		for(CS2420StudentGeneric existingStudent : studentList) {
			
			// If the student is already in the list, don't add it to the list.
			if( existingStudent.equals(student) ) {
				return false;
			}
		}
		
		// If the new student doesn't match any of the existing students, add it to the list.

		studentList.add(student);
		return true;
	}

	/**
	 * Retrieves the CS 2420 student with the given uNID.
	 * 
	 * @param uNID - uNID of student to be retrieved
	 * @return the CS 2420 student with the given uNID, or null if no such student exists in the collection
	 */

	public CS2420StudentGeneric lookup(int uNID) {
		
		// Loops through each student in the class
		for(CS2420StudentGeneric student : studentList) {

			// If there is a match, return that student
			if(student.getUNID() == uNID) {

				return student;
			}
		}
	
		// If there is no match, return null.
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
		

		// Loops through each element of the existing students.
		for(int i = 0; i < studentList.size(); i++) {
			
			// If the contactInfo is a match, add that student to the returned list.
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

		// Finds the correct student by using their ID.
		CS2420StudentGeneric currentStudent = lookup(uNID);
		
		// If the student actually exists in the class, add their score.
		if(currentStudent != null) {
			
			currentStudent.addScore(score, category);
		} else {

			// Print statement to catch when the class can't find the student.
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

		// Empty variable that will be used for further calculation.
		double averageScore = 0;
		// Loops through each index of the students.
		for(int i = 0; i < studentList.size(); i++)
		{
			// Get the final score of each student and add it to the running total.
			averageScore += studentList.get(i).computeFinalScore();
		}
		
		if(studentList.size() <= 0)
		{
			return 0; // Catch case for an empty class.
		}
		else
		{
			// If the list has students in it, compute the average
			averageScore = averageScore / (double) studentList.size();
			return averageScore;
		}
	}
	
	/**
	 * Creates a list of contact information for all CS 2420 students in the collection.
	 *
	 * @return the duplicate-free list of contact information, in any order
	 */
	public ArrayList<Type> getContactList() {
		
		// Empty list that will be returned.
		ArrayList<Type> contactInfos = new ArrayList<Type>();
		
		// Loops through each student in the class.
		for(int i = 0; i < studentList.size(); i++)
		{
			// Create the flag and the temporary email that will be used later in the code.
			Type currentInfo = (Type)studentList.get(i).getContactInfo();
			boolean emailFound = false;
			
			// For every email in the addresses:
			for(Type contactInfo: contactInfos)
			{
				// If the currentEmail is equal to an email on the list:
				if(currentInfo.equals(contactInfo))
				{
					emailFound = true; // Notify the flag.
				}


			}

			if(!emailFound) // If the flag wasn't set off:
			{
				contactInfos.add(currentInfo); // Add the new address to the existing list of addresses
			}


		}

		return contactInfos;
	}
	
	
	
	/**
	 * Returns the list of CS 2420 students in this class, 
	 * sorted by uNID in ascending order.
	 */
	public ArrayList<CS2420StudentGeneric<Type>> getOrderedByUNID() {
	    ArrayList<CS2420StudentGeneric<Type>> studentListCopy = new ArrayList<CS2420StudentGeneric<Type>>();
		    for(CS2420StudentGeneric<Type> student : studentList)
		    {
		    	studentListCopy.add(student);
		    	
		    	sort(studentListCopy, new OrderByUNID());
		    }
	    	
	    	return studentListCopy;
		}
	
	
	
	/**
	 * Returns the list of CS 2420 students in this class, 
	 * sorted by last name in lexicographical order.
	 * Breaks ties in last names using first names (lexicographical order).
	 * Breaks ties in first names using uNIDs (ascending order).
	 */
	public ArrayList<CS2420StudentGeneric<Type>> getOrderedByName() {
		ArrayList<CS2420StudentGeneric<Type>> studentListCopy = new ArrayList<CS2420StudentGeneric<Type>>();
	    for(CS2420StudentGeneric<Type> student : studentList)
	    {
	    	studentListCopy.add(student);
	    	
	    	sort(studentListCopy, new OrderByName());
	    }
	    return studentListCopy;
	}
	
	
	/**
	 * Performs a SELECTION SORT on the input ArrayList.
	 *
	 * 1. Finds the smallest item in the list.
	 * 2. Swaps the smallest item with the first item in the list.
	 * 3. Reconsiders the list be the remaining unsorted portion 
	 * (second item to Nth item) and repeats steps 1, 2, and 3.
	 */
		private static <ListType> void sort(ArrayList<ListType> list, 
			Comparator<ListType> c) {
			for(int i = 0; i < list.size() - 1; i++) {
				
				int j, minIndex;
				
				for(j = i + 1, minIndex = i; j < list.size(); j++)
				if(c.compare(list.get(j), list.get(minIndex)) < 0)
					minIndex = j;
					ListType temp = list.get(i);
					list.set(i, list.get(minIndex));
					list.set(minIndex, temp);
			}
		}
		
		
		/**
		 * Comparator that defines an ordering among CS 2420 students using their uNIDs.
		 * uNIDs are guaranteed to be unique, making a tie-breaker unnecessary.
		 */
		protected class OrderByUNID implements Comparator<CS2420StudentGeneric<Type>> {
			/**
		 	* Returns a negative value if lhs (left-hand side) is smaller than rhs (right-hand side).
		 	* Returns a positive value if lhs is larger than rhs.
		 	* Returns 0 if lhs and rhs are equal.
		 	*/
			public int compare(CS2420StudentGeneric<Type> lhs, CS2420StudentGeneric<Type> rhs) {
				return lhs.getUNID() - rhs.getUNID();
		}
	}
		
		
	/**
	 * Comparator that defines an ordering among CS 2420 students using their names.
	 * Compares by last name, then first name (if last names are the same), then uNID
	 * (if both names are the same).  uNIDs are guaranteed to be unique.
	 */
	protected class OrderByName implements Comparator<CS2420StudentGeneric<Type>> {

		public int compare(CS2420StudentGeneric<Type> lhs, CS2420StudentGeneric<Type> rhs) {
			//First compare by last name
			int lastNameCompare = lhs.getLastName().compareTo(rhs.getLastName());
			 if (lastNameCompare != 0) {
	            return lastNameCompare;
	        }
			//Then by first name if last names match
	        int firstNameCompare = lhs.getFirstName().compareTo(rhs.getFirstName());
	        if (firstNameCompare != 0) {
	            return firstNameCompare;
		    }
	        //Finally by UNIDs if first and last names match
			return lhs.getUNID() - rhs.getUNID();
	}
	}
	
	
	/**
	 * Returns the list of CS 2420 students in this class with a final 
	 * score of at least cutoffScore, sorted by final score in descending order.
	 * Breaks ties in final scores using uNIDs (ascending order).
	 *
	 * @param cutoffScore - value that a student's final score 
	 * must be at or above to be included in the returned list
	 */
	public ArrayList<CS2420StudentGeneric<Type>> getOrderedByScore(double cutoffScore) {
		ArrayList<CS2420StudentGeneric<Type>> studentListCopy = new ArrayList<CS2420StudentGeneric<Type>>();
	    for(CS2420StudentGeneric<Type> student : studentList)
	    {
	    	if(student.getScore() >= cutoffScore)
	    	{
		    	studentListCopy.add(student);
		    	
		    	sort(studentListCopy, new OrderByScore());
	    	}
	    }
	    return studentListCopy;
	}
	
	
		/**
		 * Comparator that defines an ordering among CS 2420 students using their FinalScores.
		 * Tie-breakers are chosen by uNID order.
		 */
		protected class OrderByScore implements Comparator<CS2420StudentGeneric<Type>> {
		/**
	 	* Returns a negative value if lhs (left-hand side) is smaller than rhs (right-hand side).
	 	* Returns a positive value if lhs is larger than rhs.
	 	* Returns 0 if lhs and rhs are equal.
	 	*/
			
		public int compare(CS2420StudentGeneric<Type> lhs, CS2420StudentGeneric<Type> rhs) {
			
			//Find the higher score
			//Left hand side score larger
			if (lhs.getScore() > rhs.getScore()) {
		        return 1;
		    } 
			//Right hand side score larger
			else if (lhs.getScore() < rhs.getScore()) {
		        return -1;
		    } 
			
	        //if final scores are equal, compare by UNIDs
			else {
		        return lhs.getUNID() - rhs.getUNID();
		    }
	        }
		}
	}		

