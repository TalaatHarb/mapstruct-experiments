package net.talaatharb.experiments.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PatientDto {

	private Date birthDate;

	private Long id;
	
	private String name = "";

}
