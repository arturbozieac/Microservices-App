package app.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import app.model.challenge.Challenge;
import app.services.interfaces.ChallengeGeneratorService;

/**
 * Challenge generator
 * 
 * @author Artur
 *
 */
@Service
public class ChallengeGeneratorServiceImpl implements ChallengeGeneratorService {

	/**
	 * Minimum factor value.
	 */
	private final static int MINIMUM_FACTOR = 11;
	/**
	 * Maximum factor value.
	 */
	private final static int MAXIMUM_FACTOR = 100;

	/**
	 * Random.
	 */
	private final Random random;

	public ChallengeGeneratorServiceImpl() {
		this.random = new Random();
	}

	public ChallengeGeneratorServiceImpl(final Random random) {
		this.random = random;
	}

	/**
	 * @return a randomly-generated challenge with factors between 11 and 99
	 */
	@Override
	public Challenge randomChallenge() {
		return new Challenge(next(), next());
	}
	
	/**
	 * @return next random-generated value.
	 */
	private int next() {
		return random.nextInt(MAXIMUM_FACTOR - MINIMUM_FACTOR) + MINIMUM_FACTOR;
	}
}