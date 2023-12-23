package mud;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MUD {
	
 private boolean isGameOver;
private  ReentrantLock lock= new ReentrantLock();
private Mob mob;
private GUI gui;
private GUI gui1;
private Player player1;
private Player player2;
private JTextArea textArea;

public void lock() {
	lock.lock();
}
public void unlock() {
	lock.unlock();
}
public void setGUI(GUI gui) {
    this.gui = gui;
}





public void setMobKilled() {
	
}

public boolean isGameOver() {
	return  isGameOver;
}

public void setGameOver(boolean isGameOver) {
	
    this.isGameOver=isGameOver;
}
	



public MUD() {
	
	
	Room r = new Room("Red Room",0);
	Room g = new Room("Green Room",1);
	
	Room c = new Room("Cabinet Room",2);
	Room ch = new Room("Central Hall Room",3);
	Room d = new Room("Dinning Room",4);
	Room o = new Room("Oval Office",5);
	
	Room s = new Room("Sitting Room",6);
	Room vp = new Room("Vice president",7);
	
	Exit e1= new Exit("Red To Green Room",g,"north");
	Exit e9=new Exit("Red Room To VP Office",vp,"south" );
	Exit e11=new Exit("Red Room To Sitting Room",s,"west" );
	Exit e13=new Exit("Red Room To Central Hall",ch,"east" );
	
	
	Exit e2= new Exit("Green To Red Room",r,"south");
	Exit e3=new Exit("Green to Oval Room",o,"north");
	Exit e5=new Exit("Green Room To Dinning Room",d,"west" );
	Exit e7=new Exit("Green Room To Cabinet Room",c,"east" );
	
	
	Exit e4=new Exit("Oval Room  to Green",g,"south");
	Exit e6=new Exit("Dinning Room To Green Room",g,"east" );
	Exit e8=new Exit("Cabinet Room To Green Room",g,"west" );
	
	Exit e10=new Exit("VP Office To Red Room",r,"north" );
	Exit e12=new Exit("Sitting Room To Red Room ",r,"east");
	Exit e14=new Exit("Central Hall To Red Room",r,"west");
	
	
	
	
	
	player1= new Player(r,"Biden");
	player2= new Player(g,"Trump");
	
	
	
	  Mob mob= new Mob("saka",r,this);
	  Mob mob2= new Mob("halland",g,this);
	 Mob mob3= new Mob("Messi",vp,this);

	
	
	
	
	  
	Item sword= new Item("sword");
	Item fork= new Item("fork");
	Item knife= new Item("knife");
	
	d.addItem(knife);
	s.addItem(fork);
	vp.addItem(sword);
	ch.addItem(knife);
	o.addItem(fork);
	r.addItem(sword);
	
	
	
	r.addExit(e1);
	r.addExit(e9);
	r.addExit(e11);
	r.addExit(e13);
	
	g.addExit(e2);
	g.addExit(e3);
	g.addExit(e5);
	g.addExit(e7);
	
	o.addExit(e4);
	d.addExit(e6);
	c.addExit(e8);
	vp.addExit(e10);
	s.addExit(e12);
	ch.addExit(e14);
	
	
	
	r.addMob(mob);
	g.addMob(mob2);
	//p.addItem(knife);
   
	

	
	mob2.startMobThread();
	mob.startMobThread();
	mob3.startMobThread();		
	
	 gui=new GUI(player1,this);
	gui1= new GUI(player2,this);
	 
	

}

public synchronized void setTextAreaText(String text) {
   gui.setTextAreaText(text);
}
public synchronized void setTextAreaText1(String text) {
	   gui1.setTextAreaText(text);
	}
public void playerTerminate() {
	gui.terminate();
}
public void playerTerminate1() {
	gui1.terminate();
}

public static void main(String[] args) {
	/*
	 System.out.println(p.dropItem("knife"));//true
		System.out.println(p.dropItem("knife"));//false
		System.out.println(p.getItem("knife"));//true
		System.out.println("player Item:\n"+p.getItemList());//spoon,knife
		System.out.println("Red Room Item: "+r.getItemList());//spoon,knife
		System.out.println(p.getRoomName());//Red Room
		System.out.println(p.go("north"));//true
		System.out.println(p.getRoomName());//green room
		System.out.println("Green Room  Item:\n"+g.getItemList());//green room item:
		System.out.println(p.dropItem("spoon"));//true
		System.out.println("Green Room  Item:\n"+g.getItemList());//spoon
		p.go("south");
		System.out.println(p.getRoomName());
		p.go("south");//false
		System.out.println(p.getRoomName());
	*/
	
	new MUD();
	
	
}

}
