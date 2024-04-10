package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.EducationTitleDto;
import nst.springboot.restexample01.domain.EducationTitle;
import org.springframework.stereotype.Component;

@Component
public class EducationTitleConverter implements DtoEntityConverter<EducationTitleDto, EducationTitle> {
    @Override
    public EducationTitleDto toDto(EducationTitle educationTitle) {
        return new EducationTitleDto(educationTitle.getId(), educationTitle.getName());
    }

    @Override
    public EducationTitle toEntity(EducationTitleDto educationTitleDto) {
        return new EducationTitle(educationTitleDto.getId(), educationTitleDto.getName());
    }
}
