import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<Character, Integer> map = new ConcurrentHashMap<>();
        String string = "hello boss";

        for (Character character : string.toCharArray()) {

            /** This below code is not thread safe (since it is non-atomic), tough map is concurrent,
             * but multiple threads can access it and race condition can occur.
            if(!map.containsKey(character)) {
                map.put(character, 1);
            } else {
                int value = map.get(character);
                map.put(character, value + 1);
            }**/

            map.put(character, map.getOrDefault(character, 1) + 1); //Atomic operation
        }
    }
}