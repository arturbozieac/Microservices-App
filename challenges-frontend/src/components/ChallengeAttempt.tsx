export interface ChallengeAttempt {
    id: number;
    factorA: number;
    factorB: number;
    resultAttempt: number;
    correct: boolean;
  }