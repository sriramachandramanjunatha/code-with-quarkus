package org.acme.entity;

import java.sql.Date;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Movie extends PanacheEntity{
public String title;

@Column(name = "release_date")
public Date releaseDate;

//public static List<Movie> findByYear(int year){
//	return find("YEAR(releaseDate)",year).list();
//}
}
