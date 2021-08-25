package ontap.service;

import ontap.model.Student;
import ontap.repository.IstudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSeverviceIplm implements IstudentService {
    @Autowired
    IstudentRepo istudentRepo;

    @Override
    public List<Student> findAll() {
        return (List<Student>) istudentRepo.findAll();
    }

    @Override
    public void save(Student student) {
        istudentRepo.save(student);
    }

    @Override
    public void delete(Student student) {
        istudentRepo.delete(student);
    }

    @Override
    public List<Student> findAllByName(String name) {
        return istudentRepo.fillByName(name);
    }

    @Override
    public Page<Student> findAllPage(Pageable pageable) {
        return istudentRepo.findAll(pageable);
    }

    @Override
    public Student findById(long id) {
        return istudentRepo.findById(id).get();
    }
}
