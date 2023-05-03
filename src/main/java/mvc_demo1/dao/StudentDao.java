package mvc_demo1.dao;

import mvc_demo1.dto.Student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
@Component
public class StudentDao {
	
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sigma");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		public void saveStudent(Student student) {
			et.begin();
			em.persist(student);
			et.commit();
		}
		public Student getStudent(int id) {
			return em.find(Student.class, id);
		}
		
		public void updateStudent(Student student) {
			et.begin();
			em.merge(student);
			et.commit();
		}
		public List<Student> getAllStudents() {
			Query q= em.createQuery("SELECT a FROM Student a ");
			List<Student> s=q.getResultList();
			return s;
		}
		public void deleteStudent(Student student) {
			et.begin();
			em.remove(student);
			et.commit();
		}
}
