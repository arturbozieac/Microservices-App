package app.controllers;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import app.challenge.Challenge;
import app.microservice.Microservices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import app.challenge.ChallengeAttempt;
import app.challenge.ChallengeAttemptDTO;
import app.challenge.ChallengeService;
import app.controllers.ChallengeAttemptController;
import app.user.User;

@SpringBootTest(classes = Microservices.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
class ChallengeAttemptControllerTest {

	@MockBean
	private ChallengeService challengeService;

	@Autowired
	private MockMvc mvc;

	@Autowired
	private JacksonTester<ChallengeAttemptDTO> jsonRequestAttempt;
	@Autowired
	private JacksonTester<ChallengeAttempt> jsonResultAttempt;

	@Test
	void postValidResult() throws Exception {
		// given
		User user = new User(1L, "john");
		long attemptId = 5L;
		ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(50, 70, "john", 3500);
		ChallengeAttempt expectedResponse = new ChallengeAttempt(attemptId, user, 50, 70, 3500, true);
		given(challengeService.verifyAttempt(eq(attemptDTO))).willReturn(expectedResponse);
		// when
		MvcResult response = mvc.perform(post("/attempts").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonRequestAttempt.write(attemptDTO).getJson())).andExpect(status().isOk()).andReturn();
		// then
		then(response.getResponse().getContentAsString()).isEqualTo(jsonResultAttempt.write(expectedResponse).getJson());
	}

	@Test
	void postInvalidResult() throws Exception {
		// given an attempt with invalid input data
		ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(2000, -70, "john", 1);
		// when
		MockHttpServletResponse response = mvc.perform(post("/attempts").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonRequestAttempt.write(attemptDTO).getJson())).andReturn().getResponse();
		//then
		then(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}
}
