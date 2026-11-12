import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

         //Using Frequency array
        int[] freq = new int[26];

        for(int i = 0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        } 

        for(int count : freq){
            if(count > 0) return false;
        }

      //  return true;


        //Sorting approach
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        //return Arrays.equals(arr1, arr2);

        //USING 1 MAP
        Map<Character, Integer> map  = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char ch : t.toCharArray()){

            if(!map.containsKey(ch)){
                return false;
            }
            map.put(ch, map.get(ch) - 1);

            if(map.get(ch) < 0){
                return false;
            }
        }

       // return true;
        
        //USING 2 MAPS
        // Map<Character, Integer> s1 = new LinkedHashMap<>();
        // for(int i=0; i<s.length();i++){
        //     s1.put(s.charAt(i), s1.getOrDefault(s.charAt(i),0)+1);
        // }
        // Map<Character, Integer> s2 = new LinkedHashMap<>();
        // for(int i=0; i<t.length();i++){
        //     s2.put(t.charAt(i), s2.getOrDefault(t.charAt(i),0)+1);
        // }
        // return s1.equals(s2);

        //Using Java streams
        Map<Character, Long> m1 = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<Character, Long> m2 = t.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c-> c, Collectors.counting()));
        return m1.equals(m2);
    }
}