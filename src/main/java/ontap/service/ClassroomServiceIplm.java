package ontap.service;

import ontap.model.Classroom;
import ontap.repository.IclassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassroomServiceIplm implements IclassroomService{
    @Autowired
    IclassroomRepo iclassroomRepo;
    @Override
    public List<Classroom> findAll() {
        return (List<Classroom>) iclassroomRepo.findAll();
    }

    @Override
    public Classroom findById(long id) {
        return iclassroomRepo.findById(id).get();
    }
}
