package nst.springboot.restexample01.repository;

import java.util.Optional;
import nst.springboot.restexample01.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public <S extends Department> S save(S entity);

    Optional<Department> findByName(String name);
}