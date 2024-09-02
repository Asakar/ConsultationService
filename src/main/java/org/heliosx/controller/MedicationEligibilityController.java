package org.heliosx.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.heliosx.model.Answer;
import org.heliosx.model.EligibilityResponse;
import org.heliosx.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * I have kept the solution simple as to then develop it out in any way possible.
 */
@RestController
@RequestMapping("/consultation")
public class MedicationEligibilityController {

    /**
     * using a journey reference we can get a set of questions
     * @param journeyReference the journey reference for the set of questions
     * @return a list of questions
     */
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "questions for the provided journey")})
    @GetMapping(value ="/questions/{journeyReference}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Question> getQuestions(@PathVariable UUID journeyReference) {
        return List.of(
                new Question("allergy", "Are you allergic to any medications?", "boolean"),
                new Question("age", "What is your age?", "text"),
                new Question("healthConditions", "Select any conditions you have:", "multipleChoice")
        );
    }

    /**
     * based on a set of answers we find out if the person is eligible for the medication, I have kept this
     * here for now but this can be extracted out into a separate controller for a better separation of conserns
     * @param answers consultation answers
     * @return message if the patient is eligible for the medication
     */
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "eligibility evaluation")})
    @PostMapping(value = "/answers", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public EligibilityResponse submitAnswers(@RequestBody List<Answer> answers) {
        boolean eligible = answers.stream()
                .noneMatch(answer -> "true".equalsIgnoreCase(answer.value()) && "allergy".equals(answer.questionId()));

        String message = eligible ? "You are eligible for the medication."
                : "You may not be eligible due to allergies.";

        return new EligibilityResponse(eligible, message);
    }
}
