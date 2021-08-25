package ontap.service;

import ontap.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IstudentService {

    List<Student> findAll();

    void save(Student student);


    void delete(Student student);

    List<Student> findAllByName(String name);

    Page<Student> findAllPage(Pageable pageable);

    Student findById(long id);
}
