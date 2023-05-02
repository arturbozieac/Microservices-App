package app.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.challenge.ChallengeAttempt;
import app.challenge.ChallengeAttemptDTO;
import app.challenge.ChallengeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This class provides a REST API to POST the attempts from users.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/attempts", consumes = MediaType.APPLICATION_JSON_VALUE)
public class ChallengeAttemptController {
	private final ChallengeService challengeService;

	@PostMapping
	ResponseEntity<ChallengeAttempt> postResult(@RequestBody ChallengeAttemptDTO challengeAttemptDTO) {
		return ResponseEntity.ok(challengeService.verifyAttempt(challengeAttemptDTO));
	}
}
