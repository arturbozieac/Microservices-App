package app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import app.model.user.User;

public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByAlias(final String alias);
}