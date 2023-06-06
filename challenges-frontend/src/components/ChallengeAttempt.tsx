export interface ChallengeAttempt {
    id: number;
    factorA: number;
    factorB: number;
    attemptResult: number;
    correct: boolean;
  }