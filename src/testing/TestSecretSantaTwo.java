/**
 * @author AnkitaBhatia
 *
 */
package testing;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import codingChallenge.SecretSantaTwo;	

/*The Following tests test the file SecretSantaTwo.java*/

public class TestSecretSantaTwo {

	/*Test to check if any participant is assigned to himself
	 If any of the participants is matched with himself, the test will fail*/
	@Test
	public void assignedToSelf() {
		final String[] participants = new String[] { "Kyle", "Kenny", "Eric","Stan"};
		final String[] assignmentsTwo = SecretSantaTwo.generateAssignments(participants);
		int length= participants.length;
				
		for (int i=0; i<length; i++){
			if(participants[i].equals(assignmentsTwo[i]))
				Assert.fail(participants[i]+" is assigned to Himself/Herself");
		}
		
	}
	
	/*Test to check if participant array is right shifted and assigned
	 If the assignments array matches rightShifted array, test will fail*/ 
	@Test
	public void rightShifted() {
		final String[] participants = new String[] { "Kyle", "Kenny", "Eric","Stan"};
		final String[] assignmentsTwo = SecretSantaTwo.generateAssignments(participants);
		int length= participants.length;
		final String[] rightShifted=new String[length];
		
		for (int i=1; i<length;i++)
			rightShifted[i]=participants[i-1];
			rightShifted[0]=participants[length-1];
		
		if(Arrays.equals(assignmentsTwo, rightShifted))
				Assert.fail("Participants have been right shifted");
	}
		
	
	/*Test to check if participant array is left shifted and assigned
	 If the assignments array matches rightShifted array, test will fail*/
	@Test
	public void leftShifted() {
		final String[] participants = new String[] { "Kyle", "Kenny", "Eric","Stan"};
		final String[] assignmentsTwo = SecretSantaTwo.generateAssignments(participants);
		int length= participants.length;
		final String[] leftShifted=new String[length];
		
		for (int i=0; i<length-1;i++)
			leftShifted[i]=participants[i+1];
		    leftShifted[length-1]=participants[0];
		    		
		if(Arrays.equals(assignmentsTwo, leftShifted))
				Assert.fail("Participants have been left shifted");
	}
	
	
	/* For a single person, function should return the input value given 
	   Test will pass if function returns the same name*/
	@Test
	public void oneParticipant() {
		final String[] participants = new String[] {"Kyle"};
		final String[] assignmentsTwo = SecretSantaTwo.generateAssignments(participants);
		
		Assert.assertArrayEquals(participants, assignmentsTwo);
			
	}
	
}
