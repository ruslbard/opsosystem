package com.tsystems.jschool20.srvengine.repos;

import com.tsystems.jschool20.srvengine.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ruslbard on 12.04.2017.
 */
@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findOneByName(String name);
}
