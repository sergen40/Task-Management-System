package mainapplication;

import java.text.ParseException;
import java.util.List;
import mainapplication.controller.ToDoListController;
import mainapplication.controller.UserController;
import mainapplication.dao.ToDoListDao;
import mainapplication.dao.UserDao;
import mainapplication.model.ToDoList;
import mainapplication.model.User;
import mainapplication.view.ViewLayer;

/**
 *
 * @author Rita
 */


public class MainApplication {

    public static void main(String[] args) throws ParseException {
        
        ViewLayer viewlayer;
        viewlayer = new ViewLayer();   
        viewlayer.displayMenu();
//
//        
//          
//        UserDao userDao = new UserDao();
//        UserController userController = new UserController(userDao);
//        
//        List<User> userList = userController.getList();
//        
//        for (User user : userList) {
//            System.out.println(user.getfirstName());
//        }
//        System.out.println("----------");
//        
//        System.out.println(userController.get(1).getfirstName());
//
//        TaskDao taskDao = new TaskDao();
//        TaskController taskController = new TaskController(taskDao);
//
//       
//        System.out.println("----------");
//
//        System.out.println(taskController.get(1).getTitle());
//    }
//}
        
        
//         ToDoListDao toDoListDao = new ToDoListDao();
//        ToDoListController todolistController = new ToDoListController(toDoListDao);
//        
//
//        List<ToDoList> todolistList = todolistController.getList();
//
////        for (ToDoList todolist : todolistList) {
////            System.out.println(todolist.getTitle());
////        }
////        System.out.println("----------");
////
////        System.out.println(todolistController.get(9).getTitle());
    }
}
