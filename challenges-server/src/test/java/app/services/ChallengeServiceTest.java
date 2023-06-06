package app.services;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import app.model.challenge.ChallengeAttempt;
import app.model.challenge.dto.ChallengeAttemptDTO;
import app.model.user.User;
import app.repositories.ChallengeAttemptRepository;
import app.repositories.UserRepository;
import app.services.interfaces.ChallengeService;

@ExtendWith(MockitoExtension.class)
class ChallengeServiceTest {

  private ChallengeService challengeService;

  @Mock
  private UserRepository userRepository;

  @Mock
  private ChallengeAttemptRepository attemptRepository;
	
	@BeforeEach
	public void setUp() {
    challengeService = new ChallengeServiceImpl(userRepository, attemptRepository);
	}

	/**
	 * Test validity of a correct answer for a challenge attempt.
	 */
	@Test
	public void checkCorrectAttemptTest() {
	  given(attemptRepository.save(ArgumentMatchers.any())).will(AdditionalAnswers.returnsFirstArg());
	  
		// given
		ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "john_doe", 3000);
		// when
		ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
		// then
		then(resultAttempt.isCorrect()).isTrue();
		
		verify(userRepository, times(1)).findByAlias("john_doe");
		verify(userRepository, atLeast(1)).save(ArgumentMatchers.any(User.class));
		verify(attemptRepository).save(resultAttempt);
	}

	/**
	 * Test validity of a wrong answer for a challenge attempt.
	 */
	@Test
	public void checkWrongAttemptTest() {
	  given(attemptRepository.save(ArgumentMatchers.any())).will(AdditionalAnswers.returnsFirstArg());
		// given
		ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "john_doe", 5000);
		// when
		ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
		// then
		then(resultAttempt.isCorrect()).isFalse();
	}
	
  @Test
  public void checkExistingUserTest() {
    given(attemptRepository.save(ArgumentMatchers.any())).will(AdditionalAnswers.returnsFirstArg());
    // given
    User existingUser = User.builder().alias("john_doe").build();
    given(userRepository.findByAlias("john_doe")).willReturn(Optional.of(existingUser));
    ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 60, "john_doe", 5000);
    // when
    ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
    // then
    then(resultAttempt.isCorrect()).isFalse();
    then(resultAttempt.getUser()).isEqualTo(existingUser);
    verify(userRepository, never()).save(ArgumentMatchers.any());
    verify(attemptRepository).save(resultAttempt);
  }
  
  /**
   * Test validity of a correct answer for a challenge attempt.
   */
  @Test
  public void retrieveStatsTest() {
      // given
      User user = User.builder().alias("john_doe").build();
      ChallengeAttempt attempt1 = new ChallengeAttempt(1L, user, 50, 60, 3010, false);
      ChallengeAttempt attempt2 = new ChallengeAttempt(2L, user, 50, 60, 3051, false);
      List<ChallengeAttempt> lastAttempts = List.of(attempt1, attempt2);
      given(attemptRepository.findTop10ByUserAliasOrderByIdDesc("john_doe"))
              .willReturn(lastAttempts);

      // when
      List<ChallengeAttempt> latestAttemptsResult =
              challengeService.getStatsForUser("john_doe");

      // then
      then(latestAttemptsResult).isEqualTo(lastAttempts);
  }
}
