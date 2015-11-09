package hu.dupetya.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.dupetya.common.entity.UserEntity;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	public UserEntity findByUsername(@Param("username") String name);
}
