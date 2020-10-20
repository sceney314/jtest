package forkjoin;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FKTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");

        Set<Map.Entry<String, String>> entry = map.entrySet();
        System.out.println(entry);

        int a = 0x02;

        System.out.println(a);
        Acad acad = new Acad();
        if (acad.isName()){
            System.out.println("默认 true");
        }else {
            System.out.println("默认 false");
        }
    }
}

@Data
class Acad{
    private boolean name;
}
