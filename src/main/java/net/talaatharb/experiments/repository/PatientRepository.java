package net.talaatharb.experiments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.talaatharb.experiments.entity.Patient;
import net.talaatharb.experiments.entity.PatientProjection;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	@Query(value = "SELECT pac.id as id, pac.birthDay as birthDate FROM Patient as pac")
	public abstract List<PatientProjection> findAllPatientInfo();
}
