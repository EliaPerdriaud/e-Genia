/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extend;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author etien
 */
public class UserListCellRenderer extends DefaultTableCellRenderer {
    
  public UserListCellRenderer() {
    super();
  }
 @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    Component component = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
    
    setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(208, 208, 208)));
    
    return component;
  }
 
}