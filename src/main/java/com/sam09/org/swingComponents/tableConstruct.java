/**
 * 
 */
package com.sam09.org.swingComponents;

import java.awt.Color;
import java.awt.Frame;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Sam
 *
 */

/*
 * following the guidelines of the "double checked locking" thread-safe singleton approach
 * */
public class tableConstruct {
	
	private static volatile tableConstruct frameConstructInstance ;
	
	public static tableConstruct getInstance() {
		if(frameConstructInstance == null ) {
			synchronized(tableConstruct.class) {
				if(frameConstructInstance == null ) {
					frameConstructInstance = new tableConstruct();
				}
			}
		}
		return frameConstructInstance;
	}
	
	public Frame getFrameTest(Map<Integer, Integer> hmap) {
		JFrame frame= new JFrame() ;
		
		//implementing JTable 
		JTable table = new JTable( map_TO_JTable(hmap) );
		table.setBackground(Color.orange);
		table.setBounds(100,100,100,100);
		JScrollPane jsp = new JScrollPane(table);
		frame.add(jsp);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}

	private TableModel map_TO_JTable(Map<?, ?> hmap) {
		DefaultTableModel model = new DefaultTableModel(
				new Object [] {" Element "," Occurrence "},0
				);
		for(@SuppressWarnings("rawtypes") Map.Entry mpentry : hmap.entrySet())
			model.addRow(new Object[] {mpentry.getKey(),mpentry.getValue()} );
		return model;
	}

	public JScrollPane geTable(Map<?, ?> hashMap) {
		
		JTable table =new JTable(map_TO_JTable( hashMap));
		table.setBackground(Color.ORANGE);
		JScrollPane jsp = new JScrollPane(table);
		return jsp;
	}
	
}
