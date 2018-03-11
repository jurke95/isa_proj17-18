package com.ISA.ISA_Project.controller.ProjectionController.dto;

import java.util.ArrayList;

public class ProjectionDTO {

	private String name;
	private String actors;
	private String geners;
	private String director;
	private String runtime;
	private String poster;
	private String storyline;

	public ProjectionDTO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getGeners() {
		return geners;
	}

	public void setGeners(String geners) {
		this.geners = geners;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getStoryline() {
		return storyline;
	}

	public void setStoryline(String storyline) {
		this.storyline = storyline;
	}

}
