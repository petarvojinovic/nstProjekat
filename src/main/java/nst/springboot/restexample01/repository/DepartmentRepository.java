package nst.springboot.restexample01.repository;

import java.util.Optional;
import nst.springboot.restexample01.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    Optional<Department> findByName(String name);
}