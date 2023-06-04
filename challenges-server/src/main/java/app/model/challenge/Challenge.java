package app.model.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* This class represents a Challenge to solve a Multiplication (a * b).
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Challenge {
	/**
	 * First multiplication factor
	 */
	private int factorA;
	
	/**
	 * Second multiplication factor
	 */
	private int factorB;
}