import java.util.Arrays;
import java.util.HashMap;

public class main {

    public static void main(String[] args){
        System.out.println(reverseInParentheses("asdfasdfsad((((adfasdfasdf)))"));
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        a = rotateImage(a);
        System.out.println(Arrays.toString(a[0]) + " ");
        System.out.println(Arrays.toString(a[1])+ " ");
        System.out.println(Arrays.toString(a[2]));

        ListNode<Integer> node = new ListNode<>(3);

        ListNode<Integer> head = node;

        node.next = new ListNode<>(1);

        node = node.next;

        node.next = new ListNode<>(2);

        node = node.next;

        node.next = new ListNode<>(3);

        node = node.next;

        node.next = new ListNode<>(4);

        node = node.next;

        node.next = new ListNode<>(5);

        ListNode<Integer> found = removeKFromList(head, 3);

        while (found != null){
            System.out.println(found.value);
            found = found.next;
        }


    }

    public boolean permut(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        int[] letters = new int[256];

        char[] s_array = s1.toCharArray();
        for(char c: s_array){
            System.out.println(c);
            letters[c]++;
        }

        for(int i = 0; i<s2.length(); i++){
            int c = (int) s2.charAt(i);
            if(--letters[c]<0){
                System.out.println(letters[c]);
                return false;
            }
        }

        return true;
    }


    public static boolean permutationStrings(String s1, String s2){

        if(s1.length() != s2.length()){
            return false;
        }

        HashMap<Character, Integer> hash = new HashMap<>();

        int count;
        int len = s1.length();

        for(int i = 0; i<len; i++){
            if(hash.containsKey(s1.charAt(i))){
                count = hash.get(s1.charAt(i));
                hash.replace(s1.charAt(i), ++count);
            }
            else{
                hash.put(s1.charAt(i), 1);
            }
        }

        for(int i = 0; i<len; i++){
            if(!hash.containsKey(s2.charAt(i))){
                return false;
            }
            if(hash.get(s2.charAt(i)) == 0){
                return false;
            }

            count = hash.get(s2.charAt(i));
            hash.replace(s2.charAt(i), --count);
        }
        return true;
    }

    public static String reverseInParentheses(String inputString) {

        int countOpen = 0;

        for(int i = 0;i<inputString.length(); i++){
            if(inputString.charAt(i) == '('){
                countOpen++;
                System.out.println(countOpen);
            }
        }
        return "a";
    }

    boolean areSimilar(int[] a, int[] b) {

        if(a.length != b.length){
            return false;
        }

        HashMap<Integer, Integer> hash = new HashMap<>();

        int count = 0;
        int len = a.length;

        for(int i = 0; i<len; i++){
            if(hash.containsKey(a[i])){
                count = hash.get(a[i]);
                hash.replace(a[i], ++count);
            }
            else{
                hash.put(a[i], 1);
            }
        }

        for(int i = 0; i<len; i++){
            if(!hash.containsKey(b[i])){
                return false;
            }
            if(hash.get(b[i]) == 0 ){
                return false;
            }

            count = hash.get(b[i]);
            hash.replace(b[i], --count);
        }

        return true;
    }

    boolean areSimilar2(int[] a, int[] b){

        int count = 0;
        int len = a.length;
        int elem1 = 0;
        int elem2 = 0;
        int elem11 = 0;
        int elem22 = 0;

        for(int i = 0; i<len; i++){
            if(a[i] != b[i]){
                count++;
                if(elem1 == 0){
                    elem1 = a[i];
                    elem2 = b[i];
                }
                else if(elem11 == 0){
                    elem11 = a[i];
                    elem22 = b[i];
                }
            }
        }
        if((count != 0 && count < 2) || count > 2){
            return false;
        }
        if(elem1 != elem22){
            return false;
        }
        return true;
    }

    int firstDuplicate(int[] a) {

        HashMap<Integer, Integer> hash = new HashMap<>();

        int count = 0;
        int len = a.length;

        for(int i = 0; i<len; i++){
            if(hash.containsKey(a[i])){
                count = hash.get(a[i]);
                hash.replace(a[i], ++count);
                if(count == 2){
                    return a[i];
                }
            }
            else{
                hash.put(a[i], 1);
            }
        }
        return 1;
    }


    char firstNotRepeatingCharacter(String s) {

        if(s.length() == 1){
            return s.charAt(0);
        }
        else if(s.length() == 0){
            return '_';
        }

        HashMap<Character, Integer> hash = new HashMap<>();

        int count = 0;
        int len = s.length();

        for(int i = 0; i<len; i++){
            if(hash.containsKey(s.charAt(i))){
                count = hash.get(s.charAt(i));
                hash.replace(s.charAt(i), ++count);
            }
            else{
                hash.put(s.charAt(i), 1);
            }
        }

        for(int i = 0; i<len; i++){
            if(hash.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }

        return '_';
    }

    public static int[][] rotateImage(int[][] a) {
        if(a[0].length == 1){
            return a;
        }

        int len = a.length;

        if(len%2 == 1){
            len = (len/2) + 1;
        }

        int temp;
        int temp2;
        int i2 = 0;

        for(int i = 0; i<len; i++){
            temp = a[i][len-1];
            a[i][len-1] = a[i][0];
            temp2 = a[len-(i+1)][len-1];
            a[len-(i+1)][len-1] = temp;
            temp = a[len-(i+1)][0];
            a[len-(i+1)][0] = temp2;
            a[i][0] = temp;

            i2++;

        }

        /*temp = a[0][len-1];
        a[0][len-1] = a[0][0];
        temp2 = a[len-1][len-1];
        a[len-1][len-1] = temp;
        temp = a[len-1][0];
        a[len-1][0] = temp2;
        a[0][0] = temp;*/


        //for(int i = 0; i<a.length; i++){

        //}
        return a;
    }

    // Definition for singly-linked list:
     public static class ListNode<T> {
        ListNode(T x) {
        value = x;
        }
        T value;
        ListNode<T> next;

    }

    public static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {

        ListNode<Integer> found = new ListNode<>(null);

        if(l.value == k){
            l = l.next;
        }

        found = l;

        if(l != null){

            while(l.next != null){
                if(l.value == k){
                    l = l.next;
                }

                if(l.next.value == k && l.next.next != null){
                    l.next = l.next.next;
                }

                l = l.next;
            }
            return found;
        }

        return l;
    }
}







