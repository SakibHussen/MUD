package mud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonListener implements ActionListener {
      private JLabel label;
     private ImageIcon[] images;
      private int currentImage;
      
	public ButtonListener(JLabel label,ImageIcon[]images) {
		this.label=label;
		this.images=images;
		currentImage=0;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		currentImage=(currentImage +1)%images.length;
		label.setIcon(images[currentImage]);

	}

}
