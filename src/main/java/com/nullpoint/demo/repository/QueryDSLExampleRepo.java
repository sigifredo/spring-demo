package com.nullpoint.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.nullpoint.demo.entity.Course;
import com.nullpoint.demo.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

	private QCourse qCourse = QCourse.course;

	@PersistenceContext
	private EntityManager em;

	public void find(boolean exist) {
		JPAQuery<Course> query = new JPAQuery<Course>();

		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

		if (exist) {
			predicateBuilder.and(qCourse.id.eq(23));
		} else {
			predicateBuilder.or(qCourse.name.endsWith("OP"));
		}

		Course course = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(predicateBuilder)
				.fetchOne();
		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
	}
}
