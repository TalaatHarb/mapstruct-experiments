package net.talaatharb.experiments.bootstrap;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.talaatharb.experiments.entity.Patient;
import net.talaatharb.experiments.repository.PatientRepository;

@Component
@RequiredArgsConstructor
public class Boostrap implements CommandLineRunner {

	private final PatientRepository patientRepository;

	private static final Random RANDOM = new Random();

	@Override
	@Transactional(readOnly = false)
	public void run(String... args) {
		
		for(int i = 0; i < 3; i ++) {
			Patient p = new Patient(new Date(), Math.abs(RANDOM.nextLong()), UUID.randomUUID().toString());
			p = patientRepository.save(p);
		}
	}
}
