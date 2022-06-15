package com.alexisvc.netflix_clone;

import javax.swing.SwingUtilities;

import com.alexisvc.netflix_clone.templates.HomeTemplate;

public class App{
    public static void main( String[] args ){
    	
    	Runnable runApp = new Runnable(){
			@Override
			public void run() {
			HomeTemplate homeNetflix = new HomeTemplate();
			homeNetflix.setVisible(true);
			}
    	};
    	
    	SwingUtilities.invokeLater(runApp);
    	
    }
}
