package net.talaatharb.experiments.api;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.talaatharb.experiments.dto.PatientDto;
import net.talaatharb.experiments.dto.PatientInfoDto;
import net.talaatharb.experiments.mapper.PatientMapper;
import net.talaatharb.experiments.repository.PatientRepository;

@RestController
@RequiredArgsConstructor
public class PatientController {

	private final PatientRepository patientRepository;

	private final PatientMapper patientMapper;

	@GetMapping(path = "/patients-info")
	@Transactional(readOnly = true)
	public List<PatientInfoDto> getAllPatientInfo() {
		return patientMapper.projectionToDto(patientRepository.findAllPatientInfo());
	}

	@GetMapping(path = "/patients")
	@Transactional(readOnly = true)
	public List<PatientDto> getAllPatients() {
		return patientMapper.entityToDto(patientRepository.findAll());
	}

}
