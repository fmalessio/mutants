package com.fmalessio.mercadolibre.Mutants.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLInsert;

import com.fmalessio.mercadolibre.Mutants.converter.DnaIdColumnConverter;

@Entity
@Table(name = "`DNA`")
@SQLInsert(sql = "INSERT IGNORE INTO DNA (dna, is_mutant) VALUES (?, ?)")
public class Dna {

	public Dna(String[] dna, boolean isMutant) {
		this.dna = dna;
		this.isMutant = isMutant;
	}

	public Dna() {
		// Needed to JPA
	}

	@Id
	@Convert(converter = DnaIdColumnConverter.class)
	private String[] dna;

	@Column(name = "is_mutant")
	private boolean isMutant;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	public boolean isMutant() {
		return isMutant;
	}

	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}

}
