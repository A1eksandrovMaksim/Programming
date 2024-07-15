package com.mycompany.sqlproject.DAOs;

import com.mycompany.sqlproject.DatabaseTableModel;
import com.mycompany.sqlproject.exceptions.WrongNumberOfArgumentsException;

/**
 *
 * @author Maksim
 */
public interface ObjectDAO {
    public void selectAllAndInsertIntoTable(DatabaseTableModel dtm) throws Exception;
    public int insert(Object[] src)throws WrongNumberOfArgumentsException, Exception;
    public int update(Object[] src, Object[] dst)throws WrongNumberOfArgumentsException, Exception;
    public int delete(Object[] src)throws WrongNumberOfArgumentsException, Exception;
}
