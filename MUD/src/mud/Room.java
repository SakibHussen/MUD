package mud;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Room {
	private String name;
	ArrayList<Item>items= new ArrayList();
	ArrayList<Exit> exits= new ArrayList();
	ArrayList<Mob>mobs=new ArrayList();
	ArrayList<Player>players=new ArrayList();
     private MUD m;
     private int imageIndex;
	public void setMobs(ArrayList<Mob> mobs) {
		this.mobs = mobs;
	}
//constructor
	public Room(String name,int imageIndex) {
		this.name=name;
		this.imageIndex=imageIndex;
	}
	//constructor end
	
	public int getImageIndex() {
		return imageIndex;
	}
	public void setImageIndex(int imageIndex) {
		this.imageIndex=imageIndex;
	}
	
	public void addItem(Item item) {
	    	items.add(item);
	    }
	
    public String getItemList() {
    	String it="";
    	for(Item item:items) {
    	   it=it+ item.getName()+"\n ";
    	   
    			
    		}
    		return it;
    	
    }
   
//    //another approach 
//    public ArrayList<String>getItem(){
//    	ArrayList<String>itemList=new ArrayList<String>();
//    	for(Item item:items) {
//    		itemList.add(item.getName());
//    		return itemList;
//    	}
//    	return null;
//    }
    
    
    //get room name
    public String getRoomName() {
    	return name;
    }
    public Room getRoom(String dir) {
    	
    	for(Exit e: exits) {
    		if(e.getDirection().equals(dir) ){
    			return e.toRoom;
    		}
    	}
    	return null;
    	
    }
    //display item inside the room
   public Item giveItem(String itemName) {
	   for(Item item:items) {
		   if(item.getName().equals(itemName))
		   return item;
		   
	   }
		   return null;
	  
   }
   public void addExit(Exit exit) {
	   exits.add(exit);
   }
   public String getExitsList() {
	   String exit="";
	   for(Exit e: exits) {
		   exit= exit+ " "+e.getDirection();
		  
	   }
	   return exit;
   }
   public void addMob(Mob mob) {
	   mobs.add(mob);
   }
   public String getMobName() {
	   if (mobs.isEmpty()) {
	        return "";  // Return an empty string if there are no mobs
	    }

	    StringBuilder name = new StringBuilder();
	    for (Mob mob : mobs) {
	        name.append(mob.getName()).append(" ");
	    }
	    return name.toString().trim();
   }
  public String getPlayerName() {
	  String name="";
	  for(Player p:players) {
		  name=name+p.getName();
	  }
	  return name;
  }
 
   
   public void removeItem(Item item) {
	   items.remove(item);
   }
 
   public void removeMob(Mob mob) {
	   mobs.remove(mob);
   }
   
   public ArrayList<Mob> getMobs() {
	return mobs;
}

//   public synchronized void kill(String mob) {
//	   
//	
//	        for (Mob m : mobs) {
//	            if (mob.equals(m.getName().trim())) {
//	                mobs.remove(m);
//	                //m.setMobKilled(true);
//	                return;  // Assuming there's only one matching mob
//	            }
//	        }
//	   
//	}

//public void setMobs(Mob mob) {
//	// TODO Auto-generated method stub
//	for(Mob m:mobs) {
//		m.getName();
//	}
//}


   public synchronized void kill(String mobName) {
	   
	   try {
		   for (Mob m : mobs) {
		        if (mobName.equals(m.getName().trim())) {
		        	//System.out.println("Mob name              "+mobName);
		            mobs.remove(m);
		             m.setMobKilled(true);
		             
		             //System.out.println("        "+m.isMobKilled());
		             m.stopMob();
		            break; // Break after removing the first matching mob
		        }
		    }
	   }finally {
		
	   }
	   
	}





   
}
