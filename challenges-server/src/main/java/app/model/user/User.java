package app.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Stores information to identify the user.
 */
@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
  @Id
  @GeneratedValue
	private Long id;
  
  @NonNull
	private String alias;
}
