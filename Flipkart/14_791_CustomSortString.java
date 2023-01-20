class Solution {
    public String customSortString(String S, String T) {
        
        int[] counts = new int[26];
        
        for(char c : T.toCharArray()){
            counts[c - 'a']++;
        }
        
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i<S.length(); i++){
            while(counts[S.charAt(i) -'a']-- > 0){
                res.append(S.charAt(i));
            }
        }
        
        for(int i = 0; i<counts.length; i++){
            while(counts[i]-- > 0){
                res.append((char)(i + 'a'));
            }
        }
        
        return res.toString();
    }
}
