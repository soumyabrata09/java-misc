/**
 * 
 */
package com.sam09.org.swingComponents;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 * @author Sam
 *
 */
public class tabbedPaneConstruct {

	private String title;
	 JTabbedPane tpane ;
//	public tabbedPaneConstruct(JScrollPane jsp, String title) {
//		tpane = new JTabbedPane();
//		this.setTitle(title);
//		tpane.addTab(getTitle(), jsp);
//	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	//Singleton patter "Double Checked Locking Mechanism"
	private static volatile tabbedPaneConstruct tabbedPaneConstructInstance ;
	public static tabbedPaneConstruct getInstance() {
		if(tabbedPaneConstructInstance == null ) {
			synchronized(tabbedPaneConstruct.class) {
				if( tabbedPaneConstructInstance == null ) {
					tabbedPaneConstructInstance = new tabbedPaneConstruct();
				}
			}
			//return tabbedPaneConstructInstance;
		}
		return tabbedPaneConstructInstance;
	}
	
	public JTabbedPane getTabbledPane(JScrollPane jsp1, JScrollPane jsp2, String title) {
		tpane = new JTabbedPane();
		setTitle(title);
		tpane.addTab( getTitle(), jsp1);
		tpane.addTab( getTitle(), jsp2);
		return tpane;
	}
}
