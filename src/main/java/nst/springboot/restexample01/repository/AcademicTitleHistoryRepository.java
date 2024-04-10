package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.AcademicTitleHistory;
import nst.springboot.restexample01.domain.AcademicTitleHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicTitleHistoryRepository extends JpaRepository<AcademicTitleHistory, AcademicTitleHistoryId> {

    List<AcademicTitleHistory> findByMemberId(Long memberId);
}
