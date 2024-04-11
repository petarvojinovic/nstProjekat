package nst.springboot.restexample01.service;

import nst.springboot.restexample01.dto.SecretaryHistoryDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SecretaryHistoryService {
    SecretaryHistoryDto save(SecretaryHistoryDto secretaryHistoryDto) throws Exception;

    List<SecretaryHistoryDto> getAll(Pageable pageable);

    List<SecretaryHistoryDto> getAll();

    void delete(Long departmentId, Long memberId) throws Exception;

    void update(SecretaryHistoryDto secretaryHistoryDto) throws Exception;

    SecretaryHistoryDto findById(Long departmentId, Long memberId) throws Exception;
}
