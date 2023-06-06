package app.model.challenge;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import app.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Identifies the attempt from a {@link User} to solve a challenge.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeAttempt {
	/**
	 * Attempt identifier.
	 */
  @Id
  @GeneratedValue
	private Long id;
	/**
	 * User executing the challenge.
	 */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID")
	private User user;

  private int factorA;
  private int factorB;
	
	/**
	 * Attempt result
	 */
	private int attemptResult;
	/**
	 * Flag for attempt result correctness.
	 */
	private boolean correct;
}