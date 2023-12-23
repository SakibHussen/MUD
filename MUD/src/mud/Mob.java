package mud;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JTextArea;

public class Mob implements Runnable{
	
	ArrayList<Player>players=new ArrayList();
	ArrayList<Mob>mobs=new ArrayList();
	ArrayList<String>Mitem=new ArrayList();
	private String name;
	private Room currentRoom;
	private  MUD m;

    //private String formattedItemList;
	List<GUI>gui= new ArrayList();
	
	 private boolean isMobKilled;

//	   public boolean isKilled() {
//	        return isMobKilled;
//	    }



	  public  boolean running = true;

	    public void stopMob() {
	        running = false;
	    }
	    public void notifyChanges() {
	    	for(GUI g:gui) {
	    		g.notified();
	    	}
	    }

	public Mob(String name, Room currentRoom,MUD m) {
		this.name = name;
		this.currentRoom = currentRoom;
		this.m=m;
	 
      //  this.formattedItemList=formattedItemList;
		// this.g= g;

	}

	public boolean isMobKilled() {
		return isMobKilled;
	}

	public void setMobKilled(boolean isMobKilled) {
		this.isMobKilled = isMobKilled;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 public void startMobThread() {
	        Thread mobThread = new Thread(this);
	        mobThread.start();
	    }

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
       
		while (!m.isGameOver() && !isMobKilled()) {
			System.out.println("Inside the Mob loop    "+this.getName());
			
		
            try {
				Thread.sleep(5000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            m.lock();
            ArrayList<String> options = new ArrayList();
			options.add("go");
			options.add("get");
		    options.add("drop");
			options.add("go");
       
       
           
			Random random = new Random();
			int randomNumber = random.nextInt(options.size());
			String randomText = options.get(randomNumber);
			
			switch (randomText) {
			 
				 
			 
			case "go":
				
				 String dir = this.getCurrentRoom().getExitsList().trim();
				 String [] dirArray=dir.split("\\s+");
				 int dirLength= dirArray.length;
				 if(dirLength>0) {
					 Random random3= new Random();
					 int randomExit=random3.nextInt(dirLength);
					 String direction=dirArray[randomExit];
			
					 this.go(direction);
				 }else {
					 System.out.println("********");
				 }
			//north +south 
				 
				
			   
				// System.out.println("The mov is moved to: "+this.getCurrentRoom().getRoomName());
				  // String roomItem=this.getName();
				   // formattedItemList.replace(roomItem,"  ");
				    
				   	  
				break;

			case "get":
				  String item= this.getCurrentRoom().getItemList();
				  String [] itemArray=item.trim().split("\\s+");
				  int arrayLength= itemArray.length;
				  if(arrayLength>0) {
					  Random random2= new Random();
					 int randomItem=random2.nextInt(arrayLength);
					 String selectedItem= itemArray[randomItem];
					 get(selectedItem);
				  }
	
				break;
				
			case "drop":
				String itemToRemove=this.getMobItemList();
				String [] itemArray1=itemToRemove.trim().split("\\s+");
				int arrayLength2=itemArray1.length;
				if(arrayLength2>0) {
					 Random random3= new Random();
					 int randomItem=random3.nextInt(arrayLength2);
					 String dropItem = itemArray1[randomItem];
					 drop(dropItem);
				}
                    
				break;
			}
			
			//m.unlock();
		    if (isMobKilled()) {
		       // System.out.println("The Mob " + getName() + " is Dead");
		        this.stopMob();
		       
		        break; // Exit the loop after killing the mob
		    } 
		    m.unlock();
		}
		// m.unlock();
		
		
	}

	private void drop(String dropItem) {
		// TODO Auto-generated method stub
		Mitem.remove(dropItem);
		//System.out.println("The Drop Item     is: "+dropItem);
		
	}


	private void get(String selectedItem) {
		// TODO Auto-generated method stub
		Mitem.add(selectedItem);
		//System.out.println("The item is: "+selectedItem);
	}
	
	private String getMobItemList() {
		String it="";
		for (String m:Mitem) {
			it=it+m;
		}
		return it;	
	}


	public synchronized boolean go(String direction) {
		// TODO Auto-generated method stub


			Room previousRoom = this.currentRoom;// red + green
			
			previousRoom.removeMob(this);
			
			this.currentRoom = previousRoom.getRoom(direction); 
			// Move to the new room
			//System.out.println("######this.currentRoom"+this.currentRoom.getRoomName());
			if(this.currentRoom!=null){
				this.currentRoom.addMob(this); 
				if("Messi".equals(this.getName()) && "Cabinet Room".equals(this.currentRoom.getRoomName())) {
					m.setGameOver(true);
				   m.playerTerminate();
				   m.playerTerminate1();
				}
				try {
					m.setTextAreaText("Mob in "+this.currentRoom.getRoomName()+" Name "+this.currentRoom.getMobName()+"\n");
					m.setTextAreaText1("Mob in "+this.currentRoom.getRoomName()+" Name "+this.currentRoom.getMobName()+"\n");
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return true;
			}
			
			return false;
}

}
