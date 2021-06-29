package com.te.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springboot.bean.StudentBean;
import com.te.springboot.exception.StudentException;

@Repository
public class StudentDAOImpl implements StudentDAO {

	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public StudentBean getStudent(int user_id) {
		entityManager = factory.createEntityManager();
		StudentBean bean = entityManager.find(StudentBean.class, user_id);
		return bean;
	}// end of the getStudent method

	@Override
	public boolean deleteStudent(int user_id) {
		try {
			entityManager = factory.createEntityManager();
			StudentBean bean = entityManager.find(StudentBean.class, user_id);
			transaction = entityManager.getTransaction();

			transaction.begin();
			entityManager.remove(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();

				e.printStackTrace();
			}
		} finally {

			if (entityManager != null) {
				entityManager.close();
			}
		}
		return false;
	}// end of the deleteStudent method

	@Override
	public List<StudentBean> getAllStudents() {

		try {

			entityManager = factory.createEntityManager();

			String select = "from StudentBean";

			Query query = entityManager.createQuery(select);

			List<StudentBean> list = query.getResultList();

			if (list != null) {
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (entityManager != null) {
				entityManager.close();
			}
		}
		return null;

	}// End of getAllEmployees method

	@Override
	public boolean addStudent(StudentBean bean) {
		try {
			
			entityManager = factory.createEntityManager();
			transaction = entityManager.getTransaction();

			transaction.begin();
			if (bean != null) {
				entityManager.persist(bean);
			}
			transaction.commit();
			return true;

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();

			}
			throw new StudentException("could not Added the data");
		} finally {

			if (entityManager != null) {
				entityManager.close();
			}
		}
	

	}// End of addEmp Method

	@Override
	public boolean updateStudent(StudentBean bean) {
		try {
			entityManager = factory.createEntityManager();
			transaction = entityManager.getTransaction();

			transaction.begin();
			StudentBean info = entityManager.find(StudentBean.class, bean.getUser_id());
			if (bean.getName() != null && bean.getName() != "") {
				info.setName(bean.getName());
			}

			if (bean.getMarks() != 0.0) {
				info.setMarks(bean.getMarks());
			}

			if (bean.getEmail() != null && bean.getEmail() != "") {
				info.setEmail(bean.getEmail());
			}

			if (bean.getGrade() != null && bean.getGrade() != "") {
				info.setGrade(bean.getGrade());
			}
			transaction.commit();
			return true;
		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();

			}
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return false;
	}// End of updateStudent method

}// End of StudentDAoImpl Class
