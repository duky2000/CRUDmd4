package ontap.repository;

import ontap.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface IstudentRepo extends PagingAndSortingRepository<Student,Long> {

    @Query(value = "select s from Student as s where s.name like concat('%',:name,'%')")
    public ArrayList<Student> fillByName(@Param("name") String name);
    Page<Student> findAll(Pageable pageable);

    Iterable<Student> findAllByNameContaining(String name);

}
