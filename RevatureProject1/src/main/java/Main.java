

import com.alldaos.EmployeeDAO;
import com.models.Employee;
import com.utils.ConnectionControl;

public class Main {
    public static void main(String[] args){

    ConnectionControl.connect();

    //UserDAO userDAO = new UserDAO();
    //Employee chris = new Employee("BigDawg17", "myPassword");
   // Employee mike = new Employee(3,"TysonFuryMike","anotherPassword");
    //userDAO.create(chris);
   // userDAO.create(mike);
    //userDAO.delete(2);
    //mike.setUsername("BigMike");
    //System.out.println(mike.getUsername());
    //userDAO.update(mike);
        //userDAO.checkLoginInfo("BigMike");
        //userDAO.read(1);
        //userDAO.checkLoginInfo("BigMike");
        Employee chris = new Employee(1,"chris17","bronson","employee");
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.create(chris);






        
    }
}
