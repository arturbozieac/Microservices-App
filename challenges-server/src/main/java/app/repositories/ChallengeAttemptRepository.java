package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.model.challenge.ChallengeAttempt;

public interface ChallengeAttemptRepository extends CrudRepository<ChallengeAttempt, Long>
{

  /**
  * @return the last 10 attempts for a given user, identified by their alias.
  */
  List<ChallengeAttempt> findTop10ByUserAliasOrderByIdDesc(String userAlias);
  
  /**
  * @return the last attempts for a given user, identified by their alias.
  */
  @Query("SELECT a FROM ChallengeAttempt a WHERE a.user.alias = ?1 ORDER BY a.id DESC")
  List<ChallengeAttempt> lastAttempts(String userAlias);
}
