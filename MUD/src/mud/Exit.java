package mud;

import java.util.function.Predicate;

public class Exit {
 private String description;
 public Room toRoom;
 private String direction;
 
 public Exit(String description, Room toRoom, String direction) {
	 this.description=description;
	 this.toRoom= toRoom;
	 this.direction= direction;
 }

public String getDirection() {
	return direction;
}


 

}
