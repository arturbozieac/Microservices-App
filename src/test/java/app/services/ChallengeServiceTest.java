package app.services;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.model.challenge.ChallengeAttempt;
import app.model.challenge.dto.ChallengeAttemptDTO;
import app.services.interfaces.ChallengeService;

class ChallengeServiceTest {

	private ChallengeService challengeService;

	@BeforeEach
	public void setUp() {
		challengeService = new ChallengeServiceImpl();
	}

	@Test
	public void checkCorrectAttemptTest() {
		// given
		ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "john_doe", 3000);
		// when
		ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
		// then
		then(resultAttempt.isCorrect()).isTrue();
	}

	@Test
	public void checkWrongAttemptTest() {
		// given
		ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "john_doe", 5000);
		// when
		ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
		// then
		then(resultAttempt.isCorrect()).isFalse();
	}
}
