public class main {

    public static void main(String[] args){

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
                return false;
            }
        }
        
        return true;
    }
}
