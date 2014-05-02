/**
 * @author AnkitaBhatia
 *
 */
package codingChallenge;

import java.util.Arrays;
import java.util.Random;


public class SecretSanta {

	
/**
 * @param participants - list of individuals participating in the draw.
 * @return assignments - the list of individuals paired with the participants.
 */
public static String[] generateAssignments(final String[] participants) {
	int numOfParticipants = participants.length;
	
	/*If we have less than 3 participants, there is no Secret!*/
	if(numOfParticipants <= 2){
		System.out.println("Number of participants should be greater than 2");
		return participants;	
	}
	
	/*Array is initialized to false. 
	 * When a random number 'randomNum' is generated, randomGenrator[randomNum] is set to True 
	 * to indicate that number has been used and prevent reuse */
	Boolean [] randomGenerator=new Boolean [numOfParticipants];
	Arrays.fill(randomGenerator, false);
	Random random = new Random();
	int randomNum=0;
	
	/* notFull is used to track the status of the Assignments array
	 * true indicates that array has not be fully populated 
	 * flag is set to false when all the participants have been assigned to someone*/
	Boolean notFull = true;
	String[] assignments= new String[numOfParticipants];
	int i=0;
	
	
	while(notFull){
		randomNum=random.nextInt(numOfParticipants);
		/*participant[i] will be paired with assignment[randomNum] 
		 * hence ensure that 'i' is not equal to 'randNum' generated*/
		if(randomGenerator[randomNum]==false && randomNum != i){
			randomGenerator[randomNum]=true;
			assignments[randomNum]=participants[i];
			i++;
		}
	/*	check if the assignments array has been fully populated*/
		if(i==numOfParticipants)
			notFull=false;
	}
	return assignments;
 	 
}

public static void main(String[] args) {
	
	
    /*Input Array*/ 
    final String[] participants = new String[] { "Kyle", "Kenny", "Eric","Stan",
    	    "Stewie", "Brian","Carol", "Marty", "Karen", "Mick", "Adam" };
  
	/*Output Array*/ 
    final String[] assignments = generateAssignments(participants);		
	int length=participants.length;
	
	System.out.println("Participant-->Assignement");
	for(int i=0; i< length; i++){
		/*If we have only 2 Participants, Reverse the order to get the Assignments */
			if(length==2)
				System.out.println(participants[i]+"-->"+assignments[length-1-i]);
			else
				System.out.println(participants[i]+"-->"+assignments[i]);		
		}

	}

}
