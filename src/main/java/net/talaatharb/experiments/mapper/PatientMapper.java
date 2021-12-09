package net.talaatharb.experiments.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.talaatharb.experiments.dto.PatientDto;
import net.talaatharb.experiments.dto.PatientInfoDto;
import net.talaatharb.experiments.entity.Patient;
import net.talaatharb.experiments.entity.PatientProjection;

@Mapper(componentModel = "spring")
public interface PatientMapper {

	@Mapping(source = "dto.birthDate", target = "birthDay")
	public abstract Patient dtoToEntity(PatientDto dto);

	@Mapping(source = "entity.birthDay", target = "birthDate")
	public abstract PatientDto entityToDto(Patient entity);

	public abstract List<PatientDto> entityToDto(List<Patient> entities);

	@Mapping(source = "projection.birthDate", dateFormat = "dd/MM/yyyy", target = "birthDate")
	public abstract PatientInfoDto projectionToDto(PatientProjection projection);

	public abstract List<PatientInfoDto> projectionToDto(List<PatientProjection> projection);

}
