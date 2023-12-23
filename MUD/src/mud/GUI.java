

package mud;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class GUI implements observer {
	private Player p;
   private Mob mob;
   private JLabel itemLabel;
   private String formattedItemList;
   private JTextArea textArea;
   private JFrame frame;
	public GUI(Player p,MUD m){

          this.p=p;
          
		 frame= new JFrame("This is a simple Game");
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());
		
    
		JPanel panel= new JPanel();
		//p1 which wiil add to frame's west
		
		
		
		JPanel panel1= new JPanel();
		panel1.setLayout(new BorderLayout());
		
		JLabel label= new JLabel("Room Item");
	
	String roomItem = p.getCurrentRoom().getItemList();
//		
//		
//		
//		String mobName=mob.getName();
//		roomItem+=mobName;
//		
//		
	String formattedItemList = roomItem.replace(" "," \n");
		
		JLabel itemLabel = new JLabel();
		//updateFormattedItemList();
		itemLabel.setText(formattedItemList);
		
		
		
		
		
		
		
		
		
		JLabel label2= new JLabel("   Player Item");
		String playerItem = p.getItemList();
		String formattedItemList1 ="  "+playerItem;
		
		JLabel itemLabel1 = new JLabel();
		itemLabel1.setText(formattedItemList1);
		
		
		
		JLabel label3= new JLabel("   Exit list");
		String playerExit = p.getCurrentRoom().getExitsList();
		String formattedItemList2 ="  "+playerExit.replace(", ", "\n");
		
		JLabel itemLabel2 = new JLabel();
		itemLabel2.setText(formattedItemList2);
		
		//DefaultListModel itemList= new DefaultListModel<>();
		//String roomItem=p.getCurrentRoom().getItemList();
		
		 // itemList.addElement(roomItem);
		//JList<String>item=new JList(itemList);
		
		
		//adding  JCombox
		
		
		
		
		//adding exit button
		JButton button1=new JButton("Exit");
		button1.addActionListener(e->
		//frame.dispose()
		System.exit(0));
				
		 
		
		ImageIcon[] images= new ImageIcon[8];
		images[0]=new ImageIcon("images/RedRoom.png");
		images[1]=new ImageIcon("images/GreenRoom.png");
		images[2]= new ImageIcon("images/CabinetRoom.png");
		images[3]= new ImageIcon("images/CentralHall.png");
		images[4]= new ImageIcon("images/DinningRoom.png");
		images[5]= new ImageIcon("images/OvalOffice.png");
		images[6]= new ImageIcon("images/SittingHall.png");
		images[7]= new ImageIcon("images/VicePresidentOffice.png");
		int index=p.getCurrentRoom().getImageIndex();
		JLabel picture= new JLabel(images[index]);
		
		
		
		
		JTextField input = new JTextField(15);
		
		
		
		 textArea = new JTextArea(10, 20);
		textArea.setEditable(false);
	    
		JScrollPane display = new JScrollPane(textArea);
		
		//button.addActionListener(new ButtonListener(picture, images));
		
		panel.setLayout(new BorderLayout());
		panel.add(button1,BorderLayout.NORTH);
		panel.add(picture,BorderLayout.CENTER);
		panel.add(input,BorderLayout.WEST);
		panel.add(display,BorderLayout.EAST);
		// panel1 
		//panel1.add(label);
		//panel1.add(itemLabel);
		//panel1.add(label2);
	
// adding item to the frame
		panel.add(panel1,BorderLayout.SOUTH);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.setBorder(new LineBorder(Color.black));
		panel1.add(panel2,BorderLayout.WEST);
		
		panel2.add(label,BorderLayout.NORTH);
		panel2.add(itemLabel,BorderLayout.CENTER);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		panel3.setBorder(new LineBorder(Color.black));
		panel1.add(panel3,BorderLayout.CENTER);
		panel3.add(label2,BorderLayout.NORTH);
		panel3.add(itemLabel1,BorderLayout.CENTER);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
		panel4.setBorder(new LineBorder(Color.black));
		panel1.add(panel4,BorderLayout.EAST);
		panel4.add(label3,BorderLayout.NORTH);
		panel4.add(itemLabel2,BorderLayout.CENTER);
		
		
		frame.add(panel,BorderLayout.NORTH);
		
		//frame.add(panel2,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);

		UI ui= new UI(p,input,textArea,picture,images,formattedItemList,itemLabel,itemLabel2,itemLabel1,m,frame);
		
		
		
}
	private void updateFormattedItemList() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notified() {
		// TODO Auto-generated method stub
		
	}
	  public synchronized void setTextAreaText(String text) {
	        textArea.setText(text);
	    }

public void terminate() {
	frame.dispose();
}

}


























//package mud;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.GridLayout;
//import java.util.concurrent.locks.ReentrantLock;
//
//import javax.swing.AbstractButton;
//import javax.swing.DefaultListModel;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.border.LineBorder;
//
//public class GUI implements observer {
//	private Player p;
//   private Mob mob;
//   private JTextArea itemLabel;
//  
//   private String formattedItemList;
//	public GUI(Player p,MUD m,Mob mob ){
//
//          this.p=p;
//           this.mob=mob;
//		JFrame frame= new JFrame("This is a simple Game");
//		
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(new BorderLayout());
//		
//    
//		JPanel panel= new JPanel();
//		//p1 which wiil add to frame's west
//		
//		
//		
//		JPanel panel1= new JPanel();
//		panel1.setLayout(new BorderLayout());
//		panel1.setBorder(new LineBorder(Color.BLACK));
//		JLabel label= new JLabel("Room Item");
//		label.setHorizontalAlignment(SwingConstants.CENTER);
//		label.setBorder(new LineBorder(Color.BLACK));
//	String roomItem = p.getCurrentRoom().getItemList();
////		
////		
////		
////		String mobName=mob.getName();
////		roomItem+=mobName;
////		
////		
//	String formattedItemList = roomItem.replace(" "," \n");
//		
//	itemLabel = new JTextArea();
//		//updateFormattedItemList();
//		itemLabel.setText(formattedItemList);
//		itemLabel.setBorder(new LineBorder(Color.BLACK));
//		  itemLabel.setEditable(false);
//		
//		
//		
//		
//		
//		
//		
//		JLabel label2= new JLabel("   Player Item");
//		label2.setHorizontalAlignment(SwingConstants.CENTER);
//		label2.setBorder(new LineBorder(Color.BLACK));
//		String playerItem = p.getItemList();
//		String formattedItemList1 ="  "+playerItem.replace(", ", "\n");
//		
//		JTextArea itemLabel1 = new JTextArea();
//		itemLabel1.setBorder(new LineBorder(Color.BLACK));
//		itemLabel1.setText(formattedItemList1);
//		  itemLabel1.setEditable(false);
//		
//		
//		JLabel label3= new JLabel("   Exit list");
//		label.setHorizontalAlignment(SwingConstants.CENTER);
//		label3.setBorder(new LineBorder(Color.BLACK));
//		String playerExit = p.getCurrentRoom().getExitsList();
//		String formattedItemList2 ="  "+playerExit.replace(", ", "\n");
//		
//		JTextArea itemLabel2 = new JTextArea();
//		itemLabel1.setBorder(new LineBorder(Color.BLACK));
//		itemLabel2.setText(formattedItemList2);
//	  itemLabel2.setEditable(false);
//		
//		//DefaultListModel itemList= new DefaultListModel<>();
//		//String roomItem=p.getCurrentRoom().getItemList();
//		
//		 // itemList.addElement(roomItem);
//		//JList<String>item=new JList(itemList);
//		
//		
//		//adding  JCombox
//		
//		
//	JLabel label4= new JLabel("MOB IN ROOM ");
//	JTextField vilan= new JTextField();
//	vilan.setEditable(false);
//	String mobName=p.getCurrentRoom().getMobName();
//	//vilan.add(mobName);
//		
//		//adding exit button
//		JButton button1=new JButton("Exit");
//		button1.addActionListener(e->
//		//frame.dispose()
//		System.exit(0));
//				
//		 
//		
//		ImageIcon[] images= new ImageIcon[2];
//		images[0]=new ImageIcon("images/istockphoto-1186848444-612x612.jpg");
//		images[1]=new ImageIcon("images/istockphoto-1270434349-612x612.jpg");
//		JLabel picture= new JLabel(images[0]);
//		
//		
//		
//		
//		JTextField input = new JTextField(15);
//		
//		
//		
//		JTextArea textArea = new JTextArea(10, 20);
//		textArea.setEditable(false);
//		JScrollPane display = new JScrollPane(textArea);
//		
//		//button.addActionListener(new ButtonListener(picture, images));
//		
//		panel.setLayout(new BorderLayout());
//		panel.setBorder(new LineBorder(Color.BLACK));
//		
//		panel.add(button1,BorderLayout.NORTH);
//		panel.add(picture,BorderLayout.CENTER);
//		panel.add(input,BorderLayout.WEST);
//		panel.add(display,BorderLayout.EAST);
//		// panel1 
//		//panel1.add(label);
//		//panel1.add(itemLabel);
//		//panel1.add(label2);
//	
//// adding item to the frame
//		panel.add(panel1,BorderLayout.SOUTH);
//		
//		JPanel panel2 = new JPanel();
//		panel2.setLayout(new BorderLayout());
//		panel2.setBorder(new LineBorder(Color.black));
//		panel1.add(panel2,BorderLayout.NORTH);
//		
//		panel2.add(label,BorderLayout.WEST);
//		
//		panel1.add(itemLabel,BorderLayout.WEST);
//		
//		JPanel panel3 = new JPanel();
//		panel3.setLayout(new BorderLayout());
//		panel3.setBorder(new LineBorder(Color.black));
//		panel3.add(label4,BorderLayout.WEST);
//		panel3.add(vilan,BorderLayout.CENTER);
//		
//		
//		panel1.add(panel3,BorderLayout.SOUTH);
//		panel2.add(label2,BorderLayout.CENTER);
//		panel1.add(itemLabel1,BorderLayout.CENTER);
//		
//		
//		panel2.add(label3,BorderLayout.EAST);
//		panel1.add(itemLabel2,BorderLayout.EAST);
//		
//		
//		frame.add(panel,BorderLayout.NORTH);
//		
//		//frame.add(panel2,BorderLayout.CENTER);
//		frame.pack();
//		frame.setVisible(true);
//
//		UI ui= new UI(p,input,textArea,picture,images,formattedItemList,itemLabel,itemLabel2,itemLabel1,m,frame);
//		
//		
//		
//}
//
//	@Override
//	public void notified() {
//		// TODO Auto-generated method stub
//		
//		   updateFormattedItemList();
//	        itemLabel.setText(formattedItemList);
//			
//		
//			
//	}
//
//	   private void updateFormattedItemList() {
//	        String roomItem = p.getCurrentRoom().getItemList();
//	        String mobName = p.getCurrentRoom().getMobName();
//	        System.out.println("   %%%7^76676  "+mobName);
//	        formattedItemList = roomItem + mobName;
//	        formattedItemList = formattedItemList.replace(" ", " \n");
//	    }
//
//	
//}
