package com.mycompany.sqlproject;

import com.microsoft.sqlserver.jdbc.SQLServerResultSet;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class DatabaseTableModel extends AbstractTableModel {
    private ArrayList countNames = new ArrayList();
        private ArrayList columnTypes = new ArrayList();
        private ArrayList data = new ArrayList();
        
        private boolean editable;
        
        public DatabaseTableModel(boolean editable){
            this.editable = editable;
        }

        @Override
        public int getRowCount() {
            synchronized (data) {
                return data.size();
            }
        }

        @Override
        public int getColumnCount() {
            synchronized (countNames) {
                return countNames.size();
            }
        }
        
        @Override
        public Class getColumnClass(int column){
            return (Class)columnTypes.get(column);
        }

        @Override
        public String getColumnName(int column) {
            return (String)countNames.get(column);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            synchronized (data) {
                return ((ArrayList)data.get(rowIndex)).get(columnIndex);
            }
        }
        
        public boolean isEditable(){
            return editable;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            synchronized (data) {
                ((ArrayList)data.get(rowIndex)).set(columnIndex, aValue);
            }
        }
        
        public void setDataSource(ResultSet rs)
                throws Exception{
            data.clear();
            countNames.clear();
            columnTypes.clear();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for(int i = 0; i < columnCount; ++i){
                countNames.add(rsmd.getColumnName(i+1));
                Class type = Class.forName(rsmd.getColumnClassName(i+1));
                columnTypes.add(type);
            } 
            fireTableStructureChanged();
            int y = 0;
            while(rs.next()){
                ArrayList row = new ArrayList();
                for(int i = 0; i < columnCount; ++i){
                    
                    //System.out.println(columnTypes.get(i));
                    
                    if(columnTypes.get(i) == java.sql.Date.class)
                        row.add(rs.getDate(i+1));
                    else if(columnTypes.get(i) == java.math.BigDecimal.class)
                        row.add(rs.getBigDecimal(i+1));
                    else if(columnTypes.get(i) == java.lang.Double.class)
                        row.add(rs.getDouble(i+1));
                    else if(columnTypes.get(i) == java.lang.String.class)
                        row.add(rs.getString(i+1));
                    else if(columnTypes.get(i) == java.lang.Integer.class)
                        row.add(rs.getInt(i+1));
                    else
                        row.add(rs.getObject(i+1));
                }
                
                
                //System.out.println(++y);
                
                
                synchronized (data) {
                    data.add(row);
                    fireTableRowsInserted(data.size()-1, data.size()-1);
                }
            }
        } 
}
