package co.develhope.mongoDb.repositories;

import co.develhope.mongoDb.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
