package mud;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;

public class Player {
	private ArrayList<Item>item=new ArrayList();
	ArrayList<Mob>mobs=new ArrayList();
	private Room currentRoom;
	private String name;
	//private Item itemName;
	public Player(Room currentRoom,String name) {
		this.currentRoom=currentRoom;
		this.name=name;

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String look() { 
		String l="In: "+ this.getRoomName() +"\n";
		l=l+ "Holding: " +this.getItemList()+"\n";
		
		l=l+"In Room: "+this.getRoomItemList()+"\n";
		l=l+"The Mob:"+this.getCurrentRoom().getMobName()+"\n";
		
	//	System.out.println("The Mob position"+this.getCurrentRoom().getMobName());
		l= l+"Exits: "+this.getRoomExistList()+"\n";
		return l;
	}

	public Boolean getItem(String item) {
		Item itemName=currentRoom.giveItem(item);
		if(itemName!=null) {
			addItem(itemName);
			this.currentRoom.removeItem(itemName);
			
			return true;
		}
		else {
			return false;
		}
	}

	public Boolean kill(String mob) {

		String[] mobInRoom = this.currentRoom.getMobName().split("\\s+");
		System.out.println(Arrays.toString(mobInRoom));
		String item = this.getItemList().trim();

		for (String mobName : mobInRoom) {
			if (mob.equals(mobName.trim())) {
				if (!item.isEmpty()) {
					if (item.contains("sword".trim())) {
						currentRoom.kill(mobName);
						// System.out.println("The mob "+mobName);
						// System.out.println(currentRoom.kill(mobName));
						return true;
					} else if ("Messi".equals(mobName) && !item.contains("sword".trim())) {
						return false;
					} else if ("halland".equals(mobName) && item.contains("fork".trim())) {
						return false;
					} else {
						return true;
					}

				}

			}
		}

		return false;

	}
	
	private String getRoomExistList() {
		return currentRoom.getExitsList();
	}
	private String getRoomItemList() {
		return currentRoom.getItemList();
	}
	public Room getCurrentRoom() {
		return currentRoom;
	}
	public String getRoomName(){
		return this.currentRoom.getRoomName();
	}
	
	
	public void addItem(Item item) {
		this.item.add(item);
	}

	public String getItemList() {
		String itemList=" ";
		for(Item currentItem:item) {
			itemList=itemList+ currentItem.getName().trim()+",";


		}
		return itemList;

	}
	public Boolean dropItem(String itemName) {
		itemName=itemName.toLowerCase();
		for(Item currentItem: item) {
			if(currentItem.getName().toLowerCase().equals(itemName)) {
				item.remove(currentItem);
                currentRoom.addItem(currentItem);
                return true;
			}
			

		}

		return false;
	}
	
	
	public Boolean go(String dir) {
		
		if(this.getCurrentRoom().getExitsList().contains(dir)) {
			this.currentRoom= currentRoom.getRoom(dir);
	
		
			return true;
		}
		return false;
	}
	

}
