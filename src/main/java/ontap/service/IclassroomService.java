package ontap.service;

import ontap.model.Classroom;
import ontap.model.Student;

import java.util.List;

public interface IclassroomService {
    List<Classroom> findAll();
    Classroom findById(long id);
}
