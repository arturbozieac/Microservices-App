package app.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.challenge.ChallengeAttempt;
import app.model.challenge.dto.ChallengeAttemptDTO;
import app.services.interfaces.ChallengeService;
import lombok.RequiredArgsConstructor;

/**
 * Provides a REST API to POST the attempts from users.
 */
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
