package app.services;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

import java.security.SecureRandom;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import app.model.challenge.Challenge;
import app.services.interfaces.ChallengeGeneratorService;

@ExtendWith(MockitoExtension.class)
public class ChallengeGeneratorServiceTest {
	
	private ChallengeGeneratorService challengeGeneratorService;
	private Random random = mock(SecureRandom.class, withSettings().withoutAnnotations());

	@BeforeEach
	public void setUp() {
		challengeGeneratorService = new ChallengeGeneratorServiceImpl(random);
	}

	/**
	 * Test random generator limits.
	 */
	@Test
	public void generateRandomFactorIsBetweenExpectedLimits() {
		// 89 is max - min range
		given(random.nextInt(89)).willReturn(20, 30);
		// when we generate a challenge
		Challenge challenge = challengeGeneratorService.randomChallenge();
		// then the challenge contains factors as expected
		then(challenge).isEqualTo(new Challenge(31, 41));
	}
}
