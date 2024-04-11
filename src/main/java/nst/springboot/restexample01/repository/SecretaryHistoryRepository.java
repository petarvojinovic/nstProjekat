package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.SecretaryHistory;
import nst.springboot.restexample01.domain.SecretaryHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretaryHistoryRepository extends JpaRepository<SecretaryHistory, SecretaryHistoryId> {
}
