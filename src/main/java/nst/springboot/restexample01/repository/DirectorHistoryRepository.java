package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.DirectorHistory;
import nst.springboot.restexample01.domain.DirectorHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorHistoryRepository extends JpaRepository<DirectorHistory, DirectorHistoryId> {
}
