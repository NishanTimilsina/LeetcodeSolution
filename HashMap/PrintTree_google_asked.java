import java.io.*;
import java.util.*;
import java.util.Map;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
  class Relation{
  
  String parent;
  String child;
  
  public  Relation(String Parent,String Child){
  
    parent = Parent;
    child = Child;
  }
  
};

class Solution {
  public static void main(String[] args) {

    List<Relation> list = new ArrayList<Relation>();
    list.add(new Relation("animal","mamal"));
    list.add(new Relation("animal","bird"));
    list.add(new Relation("lifeform","animal"));
    list.add(new Relation("cat","lion"));
    list.add(new Relation("mamal","cat"));
    list.add(new Relation("animal","fish"));

    
    
    /*
    
    need to print this  tree structure
    
    lifeform
      animal
        mamal
         cat
          lion
        bird
        fish
    
    */

    printListTree(list);
  }
  
  
  
  public static void printListTree(List<Relation> list){
  
    //1. create hash map first
    
    //lifefrom -[animal]
    //animal - [mamal,bird,fish]
    //mamal- [cat]
    //[cat-[lion]
    
    HashMap<String,List<String>> map  = new HashMap<String,List<String>>();
    HashSet<String> childs = new HashSet<String>();
    
    for(Relation relation: list){
    
      childs.add(relation.child);
      
      if(map.containsKey(relation.parent)){
      
          map.get(relation.parent).add(relation.child);
      }else{
        
        List<String> newL = new ArrayList<>();
        newL.add(relation.child);
        map.put(relation.parent,newL);
    
    }
  }
      
    //2. find root of the tree
    //put all child in set and check key of map in that set , if not thats the root  
      
      String root = "";
    
     for(String s: map.keySet()){
            
       if(!childs.contains(s)){
         root = s;
         break;
       }
     
     } 
      
     //3. call bfs and print
      
     bfs(root,0,map);    
    
  }
  
    public static void bfs(String root, int level,HashMap<String,List<String>> map){
  
      for(int i=0;i<level;i++){
      
        System.out.print("\t");
      }
      
      System.out.println(root);
      
      List<String> list;
      
      if(map.containsKey(root)){
      
        list = map.get(root);
        
      }else{  
      return;
      }
      
      for(String s: list){
      
        bfs(s,level+1,map);
      
      }
      
  } 
  
}
