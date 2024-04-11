package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.DirectorHistoryDto;
import nst.springboot.restexample01.domain.DirectorHistory;
import nst.springboot.restexample01.domain.DirectorHistoryId;
import org.springframework.stereotype.Component;

@Component
public class DirectorHistoryConverter implements DtoEntityConverter<DirectorHistoryDto, DirectorHistory> {
    private final DepartmentConverter departmentConverter;
    private final MemberConverter memberConverter;

    public DirectorHistoryConverter(DepartmentConverter departmentConverter, MemberConverter memberConverter) {
        this.departmentConverter = departmentConverter;
        this.memberConverter = memberConverter;
    }

    @Override
    public DirectorHistoryDto toDto(DirectorHistory directorHistory) {
        return new DirectorHistoryDto(departmentConverter.toDto(directorHistory.getDepartment()), memberConverter.toDto(directorHistory.getMember()),
                directorHistory.getStartDate(), directorHistory.getEndDate());
    }

    @Override
    public DirectorHistory toEntity(DirectorHistoryDto directorHistoryDto) {
        return new DirectorHistory(new DirectorHistoryId(directorHistoryDto.getDepartmentDto().getId(), directorHistoryDto.getMemberDto().getId()),
                departmentConverter.toEntity(directorHistoryDto.getDepartmentDto()),
                memberConverter.toEntity(directorHistoryDto.getMemberDto()),
                directorHistoryDto.getStartDate(), directorHistoryDto.getEndDate());
    }
}
