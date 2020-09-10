package javaorders.app.services;

public interface AgentService {
}



//import com.lambdaschool.sampleemps.models.Employee;
//        import com.lambdaschool.sampleemps.repositories.EmployeeRepository;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.stereotype.Service;
//        import org.springframework.transaction.annotation.Transactional;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//@Service(value = "employeeSerivce") // needed to name this implementation as the service to use
//public class EmployeeServiceImpl
//        implements EmployeeService // notice the Impl for implementing a service
//{
//    @Autowired
//    private EmployeeRepository employeerepos;
//
//    @Override
//    public List<Employee> findAllEmployees()
//    {
//        List<Employee> list = new ArrayList<>();
//        /*
//         * findAll returns an iterator set.
//         * iterate over the iterator set and add each element to an array list.
//         */
//        employeerepos.findAll()
//                .iterator()
//                .forEachRemaining(list::add);
//        return list;
//    }
//
//    @Override
//    public List<Employee> findEmployeeNameContaining(String subname)
//    {
//        return employeerepos.findByNameContainingIgnoreCase(subname);
//    }
//
//    @Override
//    public List<Employee> findEmployeeEmailContaining(String subemail)
//    {
//        return employeerepos.findByEmails_EmailContainingIgnoreCase(subemail);
//    }
//
//    @Transactional
//    @Override
//    public Employee save(Employee employee)
//    {
//        return employeerepos.save(employee);
//    }
//}