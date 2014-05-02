/**
 * @author AnkitaBhatia
 *
 */
package codingChallenge;

import java.util.Arrays;
import java.util.Random;


public class SecretSantaTwo {

	
/**
 * @param participants -list of individuals participating in the draw.
 * @return assignments -the list of individuals paired with the participants.
 */
public static String[] generateAssignments(final String[] participants) {
	int numOfParticipants = participants.length;
	
	/*If we have less than 3 participants, there is no Secret!*/
	if(numOfParticipants <= 2){
		System.out.println("Number of participants should be greater than 2");
		return participants;	
	}
	
/*Copy the contents of the participants array into the assignments array
 * Randomly shuffle the assignments array to give the matched list */
	String[] assignments=Arrays.copyOf(participants, participants.length) ;
	shuffleList(assignments,0,numOfParticipants);
	
	/*If a participant is matched with himself, shuffle the assignments array 
	 * with the start position as the incorrect match*/ 
	 for(int i=0; i< numOfParticipants;i++){
		 if(participants[i].equals(assignments[i])){
			 assignments=shuffleList(assignments,i,numOfParticipants);
			 }
		 }
	 
	 return assignments;
	 }
	 
/**
 * @param assignments- the array that needs to be shuffled randomly.
 * @param start- the first element of the array.
 * @param end- the last element of the array. 
 * @return assignments- the shuffled list of participants.
 */	
public static String[] shuffleList(String[] assignments, int start, int end){
	Random random = new Random();
	int tempIndex=0;
	for (int i = start; i < end; i++) {
		tempIndex =random.nextInt(end-start-1)+start;
		if(tempIndex==start)
			tempIndex++;
        String tempStr = assignments[i];
        assignments[i]=assignments[tempIndex];
        assignments[tempIndex]=tempStr;
        }		
	return assignments;
	}
	

public static void main(String[] args) {
	
	final String[] participants = new String[] { "Kyle", "Kenny", "Eric", "Stan",
    "Stewie", "Brian","Carol", "Marty", "Karen", "Mick", "Adam"  };

    final String[] assignments = SecretSantaTwo.generateAssignments(participants);		
    int length=participants.length;

    System.out.println("Participant-->Assignement");
    for(int i=0; i< length; i++){
    	if(length==2)
    		System.out.println(participants[i]+"-->"+assignments[length-1-i]);
    	else
    		System.out.println(participants[i]+"-->"+assignments[i]);
		
		}

	}

}