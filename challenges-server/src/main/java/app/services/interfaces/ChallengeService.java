package app.services.interfaces;

import app.model.challenge.ChallengeAttempt;
import app.model.challenge.dto.ChallengeAttemptDTO;

public interface ChallengeService {

	/**
	 * Verifies if an attempt coming from the presentation layer is correct or not.
	 *
	 * @return the resulting ChallengeAttempt object
	 */
	ChallengeAttempt verifyAttempt(ChallengeAttemptDTO resultAttempt);
}
