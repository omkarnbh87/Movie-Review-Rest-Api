package com.movie.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String movie_name;
	private Date release_date;
}
