import * as React from 'react';
import { ChallengeAttempt } from './ChallengeAttempt';

interface Props {
  lastAttempts: ChallengeAttempt[];
}

class LastAttemptsComponent extends React.Component<Props> {
  render() {
    this.props.lastAttempts.map((a: ChallengeAttempt) => console.log(a))
    return (
      <table>
        <thead>
          <tr>
            <th>Challenge</th>
            <th>Your guess</th>
            <th>Correct</th>
          </tr>
        </thead>
        <tbody>
          {this.props.lastAttempts.map((a: ChallengeAttempt) => (
            <tr
              key={a.id}
              style={{ color: a.correct ? 'green' : 'red' }}
            >
              <td>{a.factorA} x {a.factorB}</td>
              <td>{a.attemptResult}</td>
              <td>{a.correct ? "Correct" : `Incorrect (${a.factorA * a.factorB})`}</td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  }
}

export default LastAttemptsComponent;