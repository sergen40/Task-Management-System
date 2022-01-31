
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication.view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import mainapplication.controller.EditController;
import mainapplication.controller.TaskController;
import mainapplication.controller.ToDoListController;
import mainapplication.controller.UserController;
import mainapplication.dao.EditDao;
import mainapplication.dao.TaskDao;
import mainapplication.dao.ToDoListDao;
import mainapplication.dao.UserDao;
import mainapplication.model.Edit;
import mainapplication.model.Task;
import mainapplication.model.ToDoList;
import mainapplication.model.User;

/**
 *
 * @author Rita
 */
public class ViewLayer {


    public void displayMenu() throws ParseException {
        UserDao userDao = new UserDao();
        UserController userController = new UserController(userDao);

        List<User> userList = userController.getList();
      //  List<Task> taskList = TaskController.getList();
        
        ToDoListDao toDoListDao = new ToDoListDao();
        ToDoListController toDoListController =new ToDoListController(toDoListDao);

        EditDao editDao = new EditDao();
        EditController editController = new EditController(editDao);
        
        TaskDao taskDao = new TaskDao();
        TaskController taskController= new TaskController(taskDao);
        
        
        Scanner input = new Scanner(System.in);
        boolean mainLoop = true;

        System.out.println("***** * * * * TASK MANAGER * * * * *****");
        System.out.println("Enter User Name:\n");
        String username = input.next();
        //  System.out.println(userController.get(username));
        System.out.println("Enter Password:\n");
        int password = input.nextInt();

        User user =userController.getUserWithPasswordAndUsername(password, username);
        
        if(user == null){
            System.out.println("!!! User is not found !!!");
            System.out.println("Re-run Code!");
        }
        else{
            
        
        
        System.out.println(user.toString());


     while(true){
        System.out.println("\nTask Manager Main Menu\n");
        System.out.print("1.) Create ToDo List \n");
        System.out.print("2.) See Activities\n");
        System.out.print("3.) Create a Task\n");
        System.out.print("4.) Edit Task\n");
        System.out.print("5.) See All Tasks\n");
        System.out.print("6.) Exit\n");
        System.out.print("\nEnter Your Menu Choice: ");
        
        
        
        int choice = input.nextInt();


    switch(choice){

    case 1:
        //Create ToDo List
        
            System.out.print("Please Enter Title: ");
            String title = input.next();
            System.out.print("Please Enter Date: (yyyy-mm-dd)");
            String createdAtString = input.next();
            System.out.print("Please Enter Content: ");
            String content = input.next();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date = sdf.parse(createdAtString); 
        java.sql.Date sqlDate = new Date(date.getTime());              
        toDoListController.createToDoListByUser(title,sqlDate, content);
        
        
        break;

    case 2:
        //See Activities
        System.out.println(" Activities\n ");
        
        List<Edit> editList = editController.getList();
            
      for (Edit edit : editList) {
          System.out.println("TaskId: " + edit.getTaskId());
          System.out.println("Title: " + edit.getTitle());
          System.out.println("Description: "+ edit.getDescription());
         
        }
        break;


    case 3: 
        //Create a Task
        if( user.getroleId() == 0){
            System.out.println("Permission Denied!!!");
        }
        else{
        System.out.println("Please Enter The UserId: ");
        int userId = input.nextInt();
        System.out.println("Please Enter The Title: ");
        String title1 = input.next();
        System.out.println("Please Enter The Description: ");
        String description1 = input.next();
        System.out.println("Please Enter The Actual Start Date: ");
        String startedAtString = input.next();
        
        SimpleDateFormat abc = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date1 = abc.parse(startedAtString); 
        java.sql.Date sqlDate1 = new Date(date1.getTime()); 
        
        System.out.println("Please Enter The Actual End Date: ");
        String endAtString = input.next();
        
        SimpleDateFormat abc2 = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date2 = abc2.parse(endAtString); 
        java.sql.Date sqlDate2 = new Date(date2.getTime());
        
        System.out.println("Please Enter The Content: ");
        String content1= input.next();
        
        
        
         
        
        
        taskController.createToTaskByUser(userId, title1, description1, sqlDate1, sqlDate2, content1);
        }
        break;


    case 4:
        //Edit Task
        System.out.println("Which Task You want edit? : ");
        int taskId= input.nextInt();
        
      //  Edit edit=editController.checktaskId(password);
       // Edit edit=editController.updateByUser(password);
        System.out.println("Please Enter The Title: ");
        String title2 = input.next();
        System.out.println("Please Enter The Description: ");
        String description2 = input.next();
        System.out.println("Please Enter The New Start Date(yyyy-mm-dd): ");
        String startedAtString = input.next();
        
        SimpleDateFormat def = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date3 = def.parse(startedAtString);
        java.sql.Date sqlDate3 = new Date(date3.getTime()); 
        
        System.out.println("Please Enter The New End Date (yyyy-mm-dd): ");
        String endAtString = input.next();
        
        SimpleDateFormat def2 = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date4 = def2.parse(endAtString);
        java.sql.Date sqlDate4 = new Date(date4.getTime());
        
        System.out.println("Please Enter The Content: ");
        String content2= input.next();
        
        editController.updateByUser(taskId, title2, description2, sqlDate3, sqlDate4, content2);
        
       
   
       //editController.updateByUser(title2, description2, sqlDate3, sqlDate3, content2);
      
        
        break;

    case 5:
        //see all tasks
        System.out.println("All Tasks: \n");
         List<Task>  taskList = taskController.getList();
        
            
        for (Task task : taskList) {
          System.out.println("UserId: " + task.getUserId());
          System.out.println("Title: " + task.getTitle());
          System.out.println("Description: " + task.getDescription());
          System.out.println("CreatedAt: " + task.getCreatedAt());
          System.out.println("UpdatedAt: " + task.getUpdatedAt());
          System.out.println("PlannedStartDate: " + task.getPlannedStartDate());
          System.out.println("PlannedEndDate " + task.getPlannedEndDate());
          System.out.println("Content: " + task.getContent());
            System.out.println("\n");
         
                      }
        break;
        
    case 6: 
        System.out.println("Exiting Program...");
        System.exit(0);
         break;
         
         
    default :
        System.out.println("This is not a valid Menu Option! Please Select Another");
        break;

    }

    }
    }
    }
}
