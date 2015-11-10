package hu.dupetya.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.dupetya.common.entity.RoleEntity;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	List<RoleEntity> findRolesByUserId(Long id);

	@Modifying
	@Query(value = "INSERT INTO user_roles (user_id, role_id) VALUES (?2, ?1)", nativeQuery = true)
	void addRoleToUser(Long roleId, Long userId);

	@Query("SELECT r FROM RoleEntity r WHERE r.name=?1")
	RoleEntity findRoleByName(String name);

	@Modifying
	@Query(value = "DELETE FROM user_roles WHERE role_id=?1 and user_id=?2", nativeQuery = true)
	void removeRoleFromUser(Long roleId, Long userId);

}
