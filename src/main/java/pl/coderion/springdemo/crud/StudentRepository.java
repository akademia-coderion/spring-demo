package pl.coderion.springdemo.crud;

import org.springframework.data.repository.CrudRepository;
import pl.coderion.springdemo.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
