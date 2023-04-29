package app.challenge;

import org.springframework.stereotype.Service;

import app.user.User;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Override
	public ChallengeAttempt verifyAttempt(ChallengeAttemptDTO attemptDTO) {
		boolean isCorrect = attemptDTO.getGuess() == attemptDTO.getFactorA() * attemptDTO.getFactorB();

		User user = new User(null, attemptDTO.getUserAlias());

		return new ChallengeAttempt(null, user, attemptDTO.getFactorA(), attemptDTO.getFactorB(), attemptDTO.getGuess(), isCorrect);
	}
}
