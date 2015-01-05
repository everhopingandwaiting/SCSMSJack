package scsms.jc.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.*;


public class ButtonTable extends AbstractCellEditor implements TableCellRenderer,ActionListener, TableCellEditor{

	private static final long serialVersionUID = 1L;
	private JButton button =null;
	public ButtonTable(){
		button = new JButton("ȷ������");
		button.addActionListener(this);
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "��Ⱦ��ѧ��", "��Ϣ", JOptionPane.OK_OPTION);

	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return button;
	}
}