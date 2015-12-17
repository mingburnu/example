package tw.leonchen.oop.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestHashMapEx1 {

	public static void main(String[] args) {
		Map map1 = new HashMap();
        
		map1.put("1st", "mary");
        map1.put("2nd", "john");
        map1.put("3rd", "Louis");
        map1.put("3rd", "Jacky");
        map1.put(null, null);
        
        Set keys = map1.keySet();
        Collection values = map1.values();
        Set mapping = map1.entrySet();
        
        System.out.println("keys:" + keys);
        System.out.println("values:" + values);
        System.out.println("mapping:" + mapping);
        
	}
}
