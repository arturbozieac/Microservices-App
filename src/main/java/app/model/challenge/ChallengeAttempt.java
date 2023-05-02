package app.model.challenge;

import app.model.user.User;
import lombok.*;

/**
 * Identifies the attempt from a {@link User} to solve a challenge.
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ChallengeAttempt {
	private Long id;
	private User user;
	private int factorA;
	private int factorB;
	private int resultAttempt;
	private boolean correct;
}