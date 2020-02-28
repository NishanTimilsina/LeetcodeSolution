//https://leetcode.com/problems/word-ladder/

class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set = new HashSet<String>();
        for(String s:wordList){
            set.add(s);
        }
        if(!set.contains(endWord)){
            return 0;
        }
        
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String current_str = queue.poll();
                char[] current_char_arr = current_str.toCharArray();
                for(int j=0;j<current_char_arr.length;j++){      
                    char backup_char = current_char_arr[j];
                    for(char c='a';c<'z';c++){
                        if(current_char_arr[j]==c){continue;}
                        current_char_arr[j]=c;
                        String modifystr = new String(current_char_arr);
                        if(modifystr.equals(endWord)){return level+1;}
                        if(set.contains(modifystr)){queue.offer(modifystr);set.remove(modifystr);}
                    }
                    current_char_arr[j]=backup_char;
                }
            }
            level++;
        }
        return 0;
    }
}
