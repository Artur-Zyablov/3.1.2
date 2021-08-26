package spring.crud.security.service;

import org.springframework.data.repository.CrudRepository;
import spring.crud.security.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
