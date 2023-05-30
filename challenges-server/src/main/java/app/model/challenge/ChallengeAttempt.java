package app.model.challenge;

import app.model.user.User;
import lombok.*;

/**
 * Identifies the attempt from a {@link User} to solve a challenge.
 */
@Data
@AllArgsConstructor
public class ChallengeAttempt {
	/**
	 * Attempt identifier.
	 */
	private Long id;
	/**
	 * User executing the challenge.
	 */
	private User user;

	/**
	 * Attempted challenge.
	 */
	private Challenge challenge;
	
	/**
	 * Attempt result
	 */
	private int attemptResult;
	/**
	 * Flag for attempt result correctness.
	 */
	private boolean correct;
}