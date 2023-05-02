package app.services.interfaces;

import app.model.challenge.Challenge;

public interface ChallengeGeneratorService {
	/**
	 * @return a randomly-generated challenge with factors between 11 and 99
	 */
	Challenge randomChallenge();
}