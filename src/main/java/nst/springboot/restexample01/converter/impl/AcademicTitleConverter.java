package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.AcademicTitleDto;
import nst.springboot.restexample01.domain.AcademicTitle;
import org.springframework.stereotype.Component;

@Component
public class AcademicTitleConverter implements DtoEntityConverter<AcademicTitleDto, AcademicTitle> {
    @Override
    public AcademicTitleDto toDto(AcademicTitle academicTitle) {
        return new AcademicTitleDto(academicTitle.getId(), academicTitle.getName());
    }

    @Override
    public AcademicTitle toEntity(AcademicTitleDto academicTitleDto) {
        return new AcademicTitle(academicTitleDto.getId(), academicTitleDto.getName());
    }
}
