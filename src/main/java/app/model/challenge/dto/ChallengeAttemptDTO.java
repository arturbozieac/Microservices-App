package app.model.challenge.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Value;

/**
 * Attempt coming from the user
 */
@Value
public class ChallengeAttemptDTO {
	
	/**
	 * First multiplication factor
	 */
	@Min(1) @Max(99)
	int factorA;
	
	/**
	 * Second multiplication factor
	 */
	@Min(1) @Max(99)
	int factorB;
	
	/**
	 * User name.
	 */
	@NotBlank
	String userAlias;
	
	/**
	 * User's answer.
	 */
	@Positive
	int guess;
}