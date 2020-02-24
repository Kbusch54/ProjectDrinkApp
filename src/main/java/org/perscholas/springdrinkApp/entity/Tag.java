package org.perscholas.springdrinkApp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tags database table.
 * 
 */
@Entity
@Table(name = "tags")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	private String name;

	// bi-directional many-to-many association to Alcohol
	@ManyToMany
	private List<Alcohol> alcohols;

	
	public Tag() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Alcohol> getAlcohols() {
		return this.alcohols;
	}

	public void setAlcohols(List<Alcohol> alcohols) {
		this.alcohols = alcohols;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", alcohols=" + alcohols + "]";
	}

}