package app.model.challenge.dto;

import lombok.Value;

/**
 * Attempt coming from the user
 */
@Value
public class ChallengeAttemptDTO {
	
	/**
	 * First multiplication factor
	 */
	int factorA;
	
	/**
	 * Second multiplication factor
	 */
	int factorB;
	
	/**
	 * User name.
	 */
	String userAlias;
	
	/**
	 * User's answer.
	 */
	int guess;
}