package com.expertsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity 
@Table(name="photos")
public class PhotoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PhotoId", nullable = false)
	private int photoId;
	@Lob
	@Column(name = "photoname", nullable = true)
	 private String photoname;
	@Column(name = "date", nullable = false)
	private String date;	
	@Column(name = "reply", nullable = true)
	private String reply;
	@Column(name = "logid", nullable = true)
	private int logid;
	
	public int getPhotoId() {
		return photoId;
	}
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public int getLogid() {
		return logid;
	}
	public void setLogid(int logid) {
		this.logid = logid;
	}
	
}
