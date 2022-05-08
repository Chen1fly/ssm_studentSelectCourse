package com.ssm.entity;

import lombok.Data;

/**
 * @program: ssmdemo
 * @description: ${description}
 * @anther mt
 * @creater 2021-06-23 15:23
 */
@Data
public class Course {
    private Integer id;

    private String name;

    private Integer teacherId;

    private String courseDate;

    private Integer selectedNum;

    private Integer maxNum;

    private String info;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(String courseDate) {
		this.courseDate = courseDate;
	}

	public Integer getSelectedNum() {
		return selectedNum;
	}

	public void setSelectedNum(Integer selectedNum) {
		this.selectedNum = selectedNum;
	}

	public Integer getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
    
}