package mainapplication.controller;

import java.sql.Date;
import java.util.ArrayList;
import mainapplication.dao.EditDao;
import mainapplication.model.Edit;

/**
 *
 * @author SERGEN
 */
public class EditController {

    private EditDao editDao;

    public EditController(EditDao editDao) {
        this.editDao = editDao;
    }

    public void create(Edit edit) {
        editDao.create(edit);
    }

    public void update(Edit edit) {
        editDao.update(edit);
    }

    public void delete(Edit edit) {
        editDao.delete(edit);
    }

    public ArrayList<Edit> getList() {
        return editDao.getList();
    }

    
    
    public Edit get(int id) {
        return editDao.get(id);
    }
//    
    public void updateByUser(  int taskId, String title, String description, Date actualStartDate, Date actualEndDate, String content) {
        
        editDao.updateByUser(taskId, title, description, actualStartDate, actualEndDate, content);

    }
//    
//     public void updateByUser( String title, String description, Date actualStartDate, Date actualEndDate, String content) {
//        editDao.updateByUser( title, description, actualStartDate, actualEndDate, content);
//
//    }
//    
     public Edit checktaskId(int taskId){
       return editDao.checktaskId(taskId);
     }

}
