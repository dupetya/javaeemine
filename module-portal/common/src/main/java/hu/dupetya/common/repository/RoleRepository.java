package hu.dupetya.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.dupetya.common.entity.RoleEntity;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
