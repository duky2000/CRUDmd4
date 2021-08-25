package ontap.controller;

import ontap.model.Classroom;
import ontap.model.Student;
import ontap.service.IclassroomService;
import ontap.service.IstudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    IstudentService istudentService;
    @Autowired
    IclassroomService iclassroomService;

    @RequestMapping("/students")
    public ModelAndView homeStudent(@PageableDefault(size = 2)Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("list",istudentService.findAllPage(pageable));
        return modelAndView;
    }


    @ModelAttribute("listClass")
    public List<Classroom> listClassroom() {
        return iclassroomService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student",new Student());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView ShowFormEdit(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("student",istudentService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("student",istudentService.findById(id));
        return modelAndView;
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam("findName") String name) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list", istudentService.findAllByName(name));
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView showFormView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("student", istudentService.findById(id));
        return modelAndView;

    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Student student, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("student",student);
            return modelAndView;
        }

        istudentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }


    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Student student) {
        istudentService.save(student);
        return "redirect:/students";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        istudentService.delete(istudentService.findById(id));
        return "redirect:/students";
    }
}
