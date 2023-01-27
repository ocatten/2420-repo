package assign02;
/**
 * This class holds all the information corresponding to an Email Address object for the information about a student
 * in a CS2420 class. This student is a University of Utah student, and this class inherits from the UofUStudent class
 * accordingly. 
 * 
 * @author Parker Catten, Everett Oglesby
 * @version 01:20:23 CS-2420-SP2023
 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CS2420Student extends UofUStudent {
	
	private String firstName;
	private String lastName;
	private int uNID;
	private EmailAddress contactInfo;
	
	private double assignmentScore = 0;
	private double examScore = 0;
	private double labScore = 0;
	private double quizScore = 0;
	
	private double totalAssignmentScore = 0;
	private double totalExamScore = 0;
	private double totalLabScore = 0;
	private double totalQuizScore = 0;
	
	private double weightedAssignmentScore = 0;
	private double weightedExamScore = 0;
	private double weightedLabScore = 0;
	private double weightedQuizScore = 0;
	private double[] weightedScores = new double[] {weightedAssignmentScore, weightedExamScore, weightedLabScore, weightedQuizScore};
	
	
	private double finalScore;
	private String finalGrade;	
	
	
	public CS2420Student(String firstName, String lastName, int uNID, EmailAddress contactInfo) {
		
		// Calls the superclass constructor, as the assignment said it extended to the UofUStudent.
		super(firstName, lastName, uNID);
		
		// Sets up the proper fields
		this.firstName = firstName;
		this.lastName = lastName;
		this.uNID = uNID;
		this.contactInfo = contactInfo;
	}
	
	
	
	/**
	 * @return EmailAddress contactInfo
	 */
	public EmailAddress getContactInfo()
	{
		return contactInfo;
	}
	
	
	
	/**
	 * @return int uNID
	 */
	public int getUNID() 
	{
		return this.uNID;
	}
	
	
	
	/**
	 * @return double finalScore
	 */
	public double getScore()
	{
		return finalScore;
	}
	
	
	
	/**
	 * Adds the score of each category to its proper category
	 * if no categories fit the category it does nothing. After the 
	 * score is added it updates the grades.
	 * 
	 * @param: score: Score to be added to the category, out of 100
	 * @param: category: Category of the score, assignment, lab, quiz, or exam
	 */
	public void addScore(double score, String category)
	{
		//"assignment", "exam", "lab", or "quiz", if none are found, print an error message.
		switch(category)
		{
			case "assignment":
				assignmentScore += score; // Adds the total to the variables that track the cumulative score
				totalAssignmentScore += 100; // Each assignment is out of 100, so the total is adjusted for later averaging
				break; // Break from each case if it's a find.
			case "exam":
				examScore += score;
				totalExamScore += 100;
				break;
			case "lab":
				labScore += score;
				totalLabScore += 100;
				break;
			case "quiz":
				quizScore += score;
				totalQuizScore += 100;
				break;
			default: // Catch case if a category doesn't match a proper grade.
				System.out.println("Score does not fit into any valid category. " + category);
		}
		
		// Runs the gradeCalculator method to adjust all of the scores and weight them. 
		gradeCalculator();
	}
	
	
	
	/**
	 * If the exam score is under 65, return the exam score. If not
	 * return the final score based on different weights from the CS 
	 * 2420 syllabus.
	 */
	public double computeFinalScore() {
		
		// If the exams total out to be below 65, then the grade forces the new test score to be 65.
		if(weightedExamScore < .65) {
			
			return weightedExamScore*100;
		}
		
		// Creates an array of all of the scores to loop through them
		double[] totalScores = new double[] { totalAssignmentScore, totalExamScore, totalLabScore, totalQuizScore };
		// For each total score in the array:
		for(double totalScore : totalScores) {
			if(totalScore == 0) {
				// If the total score is 0 (& there are therefore no assignments submitted for a section) return 0
				return 0;
			}
		}
		
		//final CS 2420 grade is comprised of assignments (programming and analysis) 40%,
		// exams 40%, labs 10%, Canvas quizzes 10%
		finalScore = (weightedAssignmentScore * 40) + (weightedExamScore * 40) 
				+ (weightedLabScore * 10) + (weightedQuizScore * 10);
		return finalScore;
		
	}
	
	
	
	/**
	 * Computes the final grade based on the final score put into a 
	 * tree map which marks the given grade at each score.
	 */
	public String computeFinalGrade()
	{
		// Set up the TreeMap according to the syllabus.
		TreeMap<Double, String> gradeMap = new TreeMap<>();
		gradeMap.put(93.0, "A");
		gradeMap.put(90.0, "A-");
		gradeMap.put(87.0, "B+");
		gradeMap.put(83.0, "B");
		gradeMap.put(80.0, "B-");
		gradeMap.put(77.0, "C+");
		gradeMap.put(73.0, "C");
		gradeMap.put(70.0, "C-");
		gradeMap.put(67.0, "D+");
		gradeMap.put(63.0, "D");
		gradeMap.put(60.0, "D-");
		gradeMap.put(0.0, "E");
		
		// Creates an array of all of the scores to loop through them
		double[] totalScores = new double[] { totalAssignmentScore, totalExamScore, totalLabScore, totalQuizScore };
		// For each total score in the array:
		for(double totalScore : totalScores) {
			if(totalScore == 0) {
				// If the total score is 0 (& there are therefore no assignments submitted for a section) return N/A
				return "N/A";
			}
		}
		
		computeFinalScore();
		
		// Finds the TreeMap value and returns the corresponding letter
        finalGrade = gradeMap.floorEntry(finalScore).getValue();
        //System.out.println(finalScore); // Added for testing.
        return finalGrade;
	}
	
	/**
	 * Creates a weighted grade for each category based on 
	 * the totals of the assignment score and the total number 
	 * of points that were available.
	 */
	private void gradeCalculator()
	{
		// Each weighted score is the cumulative score gathered by the code, and the total is the number of 
		//  assignments included in intervals of 100. Each weightedScore is turned into a percentage.
		weightedAssignmentScore = assignmentScore / totalAssignmentScore;
		weightedExamScore = examScore / totalExamScore;
		weightedLabScore = labScore / totalLabScore;
		weightedQuizScore = quizScore / totalQuizScore;
	}
}
