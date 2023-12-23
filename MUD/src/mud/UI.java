package mud;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UI {
	private Player p;
	private JTextField input;
	private JTextArea display;
	private JLabel label;
	private JFrame frame;
	private ImageIcon[] images;
	private int currentImage = 0;
	private String formattedItemList;
	private JLabel itemLabel;
	private JLabel itemLabel1;
	private JLabel itemLabel2;
	private Mob m1;
	private MUD m;

	// private JList<String>items;
	// private ButtonListener buttonListener;
	public UI(Player p, JTextField input, JTextArea display, JLabel label, ImageIcon[] images, String formattedItemList,
			JLabel itemLabel3, JLabel itemLabel22, JLabel itemLabel12, MUD m, JFrame frame) {

		this.p = p;
		this.input = input;
		this.display = display;
		this.label = label;
		this.images = images;
		this.formattedItemList = formattedItemList;
		this.itemLabel = itemLabel3;
		this.itemLabel2 = itemLabel22;
		this.itemLabel1 = itemLabel12;
		this.m = m;
		this.frame = frame;
		// this.m1=m1;
		// this.buttonListener = buttonListener;

		input.addActionListener(e -> {
			JTextField source = (JTextField) e.getSource();
			String inputText = source.getText().trim();

			run(inputText);
			source.setText("");

			// Clear the input field
		});
	}

	public void run(String inputText) {

		Boolean running = true;
		if (inputText.length() == 0) {
           
		} else {
			Scanner s = new Scanner(inputText);

			String command = s.next();
			// String direction=s.next();

			String item;
			String mob;

			// m.lock();

			switch (command) {

			case "exit":
				running = false;
				m.setGameOver(true);
				frame.dispose();
				break;
			// m.unlock();
			case "go":

				String direction = s.next();
				if (!p.go(direction)) {

					display.append("No exit that way! \n");
				} else {
					//currentImage = (currentImage + 1) % images.length;
					currentImage=p.getCurrentRoom().getImageIndex();
					label.setIcon(images[currentImage]);
					String roomItem = " ";
					// itemList.addElement(p.getCurrentRoom().getItemList());
                     
					roomItem = p.getCurrentRoom().getItemList().replace("  ", " \n");

					// display.append(mobPosition+"Mob is here!");
					formattedItemList = roomItem + " \n";

					// display.append(formattedItemList);
					itemLabel.setText(formattedItemList);
					String exits = p.getCurrentRoom().getExitsList();
					itemLabel2.setText(exits);

				}

				break;

			case "look":

				display.append(p.look());

				break;

			case "get":

				item = s.next();
				if (!p.getItem(item)) {
					display.append("Couldn't get " + item);
				} else {
					formattedItemList = formattedItemList.replace(item, " ");

					itemLabel.setText(formattedItemList);
					itemLabel1.setText(item);
				}

				break;
			case "drop":
				item = s.next();
				if (!p.dropItem(item)) {
					display.append("Couldn't drop " + item);
				} else {
					formattedItemList += " " + item;
					itemLabel.setText(formattedItemList);
					String playerCurrentItem = item.replace(item, " ");
					itemLabel1.setText(playerCurrentItem);
				}
				break;

			case "kill":

				mob = s.next().trim();

				if (!p.kill(mob)) {

					display.append("No Mob found in that Room! " + mob);
				} else {
					// formattedItemList = formattedItemList.replace(mob, " ");

					/// itemLabel.setText(formattedItemList);


					m.setGameOver(true);
                
                        
                    if("Biden".trim().equals(p.getName())) {
                    	m.setGameOver(true);
                        m.playerTerminate1();
                        display.setText(" ");
                        display.append(p.getName()+" is the Winner!");
                        
                    }else if("Trump".trim().equals(p.getName())){
                    	m.setGameOver(true);
                    	m.playerTerminate();
                        display.setText(" ");
                        display.append(p.getName()+" is the Winner!");
                    }
					//frame.dispose();
					// System.out.println(" "+m.isGameOver());

					running = false;

				}

				break;

			default:
				display.append("Unrecognized command\n");
			}
			// m.unlock();

		}
	}

}
