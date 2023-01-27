package assign02;
/**
 * This Java class represents an unordered collection of University of Utah students enrolled in CS 2420.
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
import java.util.Scanner;

public class CS2420Class {

	private ArrayList<CS2420Student> studentList;
	
	
	/**
	 * Creates an empty CS 2420 class.
	 */
	public CS2420Class() {
		// Sets up the relevant fields.
		this.studentList = new ArrayList<CS2420Student>();
	}
	
	
	
	/**
	 * Adds the given student to the collection of students in CS 2420, avoiding duplicates.
	 * 
	 * @param student - student to be added to this CS 2420 class
	 * @return true if the student was added, 
	 *         false if the student was not added because they already exist in the collection
	 */
	public boolean addStudent(CS2420Student student) {
		
		// Loops through each student that's already in the class
		for(CS2420Student existingStudent : studentList) {
			
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
	public CS2420Student lookup(int uNID) {
		
		// Loops through each student in the class
		for(CS2420Student student : studentList) {

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
	public ArrayList<CS2420Student> lookup(EmailAddress contactInfo) {
		
		ArrayList<CS2420Student> studentsSelected = new ArrayList<CS2420Student>();
		
		// Loops through each element of the existing students.
		for(int i = 0; i < studentList.size(); i++) {
			
			// If the contactInfo is a match, add that student to the returned list.
			if(studentList.get(i).getContactInfo().equals(contactInfo)) {
				
				//System.out.println("found valid contact info"); // Added for testing.
				studentsSelected.add(studentList.get(i));				
			}
		}
		
		// Return the list of students that correspond to the contact info.
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
		CS2420Student currentStudent = lookup(uNID);
		
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
	public ArrayList<EmailAddress> getContactList() {
		
		// Empty list that will be returned.
		ArrayList<EmailAddress> emailAddresses = new ArrayList<EmailAddress>();
		
		// Loops through each student in the class.
		for(int i = 0; i < studentList.size(); i++)
		{
			// Create the flag and the temporary email that will be used later in the code.
			EmailAddress currentEmail = studentList.get(i).getContactInfo();
			boolean emailFound = false;
			
			// For every email in the addresses:
			for(EmailAddress email: emailAddresses)
			{
				// If the currentEmail is equal to an email on the list:
				if(email.equals(currentEmail))
				{
					emailFound = true; // Notify the flag.
				}


			}
			if(!emailFound) // If the flag wasn't set off:
			{
				emailAddresses.add(currentEmail); // Add the new address to the existing list of addresses
			}


		}
		return emailAddresses; // Return the completed list.
	}
	
	/**
	 * Adds the students specified by the input file to the collection of students in CS 2420.
	 * 
	 * Assumes a very strict file format:
	 *     -- first line: FirstName LastName (u0123456) userName@domainName
	 *     -- second line: assignment scores, separated by blank spaces
	 *     -- third line: exam scores, separated by blank spaces
	 *     -- fourth line: lab scores, separated by blank spaces
	 *     -- fifth line: quiz scores, separated by blank spaces
	 *     -- sixth line ... : repeat of lines 1-5 for another student
	 *     
	 * Also assumes there are no duplicate students in the file.
	 * 
	 * @param filename - full or relative path to file containing student data
	 */
	public void addAll(String filename) {
		String[] categories = { "assignment", "exam", "lab", "quiz" };
		
		try {
			Scanner fileIn = new Scanner(new File(filename));
			int lineNumber = 0;

			while(fileIn.hasNextLine()) {
				
				// first line: FirstName LastName (u0123456) userName@domainName
				String line = fileIn.nextLine();
				lineNumber++;
				CS2420Student student = parseStudent(line, lineNumber);
				
				// second-fifth lines: assignment, exam, lab, and quiz scores
				for(int i = 0; i < 4; i++) {
					// make sure there is a next line ...
					if(!fileIn.hasNextLine()) {
						fileIn.close();
						throw new ParseException(categories[i] + " scores ", lineNumber + 1);
					}
					
					line = fileIn.nextLine();
					lineNumber++;
					parseScores(line, categories[i], student);
				}
				
				addStudent(student);
			}  // repeat for more students on sixth+ lines
			
			fileIn.close();
		}
		catch(FileNotFoundException e) {
			System.err.println(e.getMessage() + " No students added to CS 2420 class.");
		}
		catch(ParseException e) {
			System.err.println(e.getLocalizedMessage() + " formatted incorrectly at line " + e.getErrorOffset()
					+ ". No students added to CS 2420 class.");
		}
	}
	
	/**
	 * Helper method for parsing the information about a student from file.
	 * 
	 * @param line - string to be parsed
	 * @param lineNumber - line number in file, used for error reporting (see above)
	 * @return the CS2420Student constructed from the information
	 * @throws ParseException if file containing line is not properly formatted (see above)
	 */
	private CS2420Student parseStudent(String line, int lineNumber) throws ParseException {
		Scanner lineIn = new Scanner(line);
		lineIn.useDelimiter(" ");

		if(!lineIn.hasNext()) {
			lineIn.close();
			throw new ParseException("First name", lineNumber);
		}
		String firstName = lineIn.next();

		if(!lineIn.hasNext()) {
			lineIn.close();
			throw new ParseException("Last name", lineNumber);
		}
		String lastName = lineIn.next();

		if(!lineIn.hasNext()) {
			lineIn.close();
			throw new ParseException("uNID", lineNumber);
		}
		String uNIDString = lineIn.next();
		int uNID = Integer.parseInt(uNIDString.substring(2, 9));

		if(!lineIn.hasNext()) {
			lineIn.close();
			throw new ParseException("Email address", lineNumber);
		}
		String[] emailAddress = lineIn.next().split("@");
		
		lineIn.close();

		return new CS2420Student(firstName, lastName, uNID, new EmailAddress(emailAddress[0], emailAddress[1]));
	}
	
	/**
	 * Helper method for parsing the scores for a student from file.
	 * 
	 * @param line - string to be parsed
	 * @param category - "assignment", "exam", "lab", or "quiz"
	 * @param student - the student for which to add the scores
	 */
	private void parseScores(String line, String category, CS2420Student student) {
		Scanner lineIn = new Scanner(line);
		lineIn.useDelimiter(" ");
		while(lineIn.hasNextDouble()) 
			student.addScore(lineIn.nextDouble(), category);
		lineIn.close();
	}
}
