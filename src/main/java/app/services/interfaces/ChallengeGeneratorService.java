package app.services.interfaces;

import app.model.challenge.Challenge;

/**
 * Challenge Generator
 * 
 * @author Artur
 *
 */
public interface ChallengeGeneratorService {
	
	/**
	 * @return a randomly-generated challenge.
	 */
	Challenge randomChallenge();
}