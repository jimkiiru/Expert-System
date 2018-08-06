package com.expertsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="SoybeanDiseases")
public class SoybeanDiseaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "diseaseId", nullable = false)
	private int diseaseId;
	@Column(name = "diseaseName", nullable = true)
	 private String diseaseName;
	@Column(name = "diseasePhoto", nullable = true)
	 private String diseasePhoto;
	@Column(name = "culturalControl", nullable = true)
	 private String culturalControl;
	@Column(name = "chemicalControl", nullable = true)
	 private String chemicalControl;
	@Column(name = "biologicalControl", nullable = true)
	 private String biologicalControl;
	
	public int getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(int diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}	
	public String getDiseasePhoto() {
		return diseasePhoto;
	}
	public void setDiseasePhoto(String diseasePhoto) {
		this.diseasePhoto = diseasePhoto;
	}
	public String getCulturalControl() {
		return culturalControl;
	}
	public void setCulturalControl(String culturalControl) {
		this.culturalControl = culturalControl;
	}
	public String getChemicalControl() {
		return chemicalControl;
	}
	public void setChemicalControl(String chemicalControl) {
		this.chemicalControl = chemicalControl;
	}
	public String getBiologicalControl() {
		return biologicalControl;
	}
	public void setBiologicalControl(String biologicalControl) {
		this.biologicalControl = biologicalControl;
	}	
}
