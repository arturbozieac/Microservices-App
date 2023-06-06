import * as React from 'react';
import { ChallengeAttempt } from './ChallengeAttempt';

interface Props {
  lastAttempts: ChallengeAttempt[];
}

class LastAttemptsComponent extends React.Component<Props> {
  render() {
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
              <td>{a.resultAttempt}</td>
              <td>{a.correct ? "Correct" : `Incorrect (${a.factorA * a.factorB})`}</td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  }
}

export default LastAttemptsComponent;