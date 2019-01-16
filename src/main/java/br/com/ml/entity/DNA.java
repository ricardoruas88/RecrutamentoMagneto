package br.com.ml.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name="DNA")
@RequiredArgsConstructor
public class DNA {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	@Setter
	int id;
	
	@Getter
	@Setter
	@Column(name="DNA", nullable=false)
	@NonNull
	private String[] dna;
	
	
	@Getter
	@Setter
	@Column(name="mutante", nullable=false)
	@NonNull
	private boolean mutante;
	
	
	
	
	
	
	
	
	
}
