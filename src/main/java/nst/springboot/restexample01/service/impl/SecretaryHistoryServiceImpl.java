package nst.springboot.restexample01.service.impl;

import nst.springboot.restexample01.converter.impl.SecretaryHistoryConverter;
import nst.springboot.restexample01.dto.SecretaryHistoryDto;
import nst.springboot.restexample01.domain.Department;
import nst.springboot.restexample01.domain.Member;
import nst.springboot.restexample01.domain.SecretaryHistory;
import nst.springboot.restexample01.domain.SecretaryHistoryId;
import nst.springboot.restexample01.repository.DepartmentRepository;
import nst.springboot.restexample01.repository.MemberRepository;
import nst.springboot.restexample01.repository.SecretaryHistoryRepository;
import nst.springboot.restexample01.service.SecretaryHistoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class SecretaryHistoryServiceImpl implements SecretaryHistoryService {
    private final SecretaryHistoryRepository secretaryHistoryRepository;
    private final SecretaryHistoryConverter secretaryHistoryConverter;
    private final DepartmentRepository departmentRepository;
    private final MemberRepository memberRepository;

    public SecretaryHistoryServiceImpl(SecretaryHistoryRepository secretaryHistoryRepository, SecretaryHistoryConverter secretaryHistoryConverter, DepartmentRepository departmentRepository, MemberRepository memberRepository) {
        this.secretaryHistoryRepository = secretaryHistoryRepository;
        this.secretaryHistoryConverter = secretaryHistoryConverter;
        this.departmentRepository = departmentRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional
    public SecretaryHistoryDto save(SecretaryHistoryDto secretaryHistoryDto) throws Exception {
        SecretaryHistory secretaryHistory = secretaryHistoryConverter.toEntity(secretaryHistoryDto);

        Optional<Member> memberOptional = memberRepository.findById(secretaryHistory.getId().getMemberId());
        if (memberOptional.isEmpty()) throw new Exception("Member does not exist!");
        Optional<Department> departmentOptional = departmentRepository.findById(secretaryHistory.getId().getDepartmentId());
        if (departmentOptional.isEmpty()) throw new Exception("Department does not exist!");

        Optional<SecretaryHistory> secretaryHistoryOptional = secretaryHistoryRepository.findById(new SecretaryHistoryId(secretaryHistory.getId().getDepartmentId(),
                secretaryHistory.getId().getMemberId()));
        if (secretaryHistoryOptional.isEmpty()) return secretaryHistoryConverter.toDto(secretaryHistoryRepository.save(secretaryHistory));
        SecretaryHistory existingSecretaryHistory = secretaryHistoryOptional.get();
        existingSecretaryHistory.setStartDate(secretaryHistory.getStartDate());
        existingSecretaryHistory.setEndDate(secretaryHistory.getEndDate());
        return secretaryHistoryConverter.toDto(secretaryHistoryRepository.save(existingSecretaryHistory));
    }

    @Override
    public List<SecretaryHistoryDto> getAll(Pageable pageable) {
        return secretaryHistoryRepository.findAll(pageable).stream().map(secretaryHistoryConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SecretaryHistoryDto> getAll() {
        return secretaryHistoryRepository.findAll().stream().map(secretaryHistoryConverter::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long departmentId, Long memberId) throws Exception {
        Optional<SecretaryHistory> secretaryHistory = secretaryHistoryRepository.findById(new SecretaryHistoryId(departmentId, memberId));
        if (secretaryHistory.isEmpty()) throw new Exception("Secretary history does not exist!");
        secretaryHistoryRepository.delete(secretaryHistory.get());
    }

    @Override
    public void update(SecretaryHistoryDto secretaryHistoryDto) throws Exception {

    }

    @Override
    public SecretaryHistoryDto findById(Long departmentId, Long memberId) throws Exception {
        Optional<SecretaryHistory> secretaryHistory = secretaryHistoryRepository.findById(new SecretaryHistoryId(departmentId, memberId));
        if (secretaryHistory.isEmpty()) throw new Exception("Secretary history does not exist!");
        return secretaryHistoryConverter.toDto(secretaryHistory.get());
    }
}
