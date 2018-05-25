package com.sks.interview2018;

public class InterviewQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
 * UBER Telephonic round
 * 
 */
//This is the text editor interface. 
//Anything you type or change here will be seen by the other person in real time.
//Assumption: 
 // Single Car
//(k,v) storager data structure
//Ops: put, previous

//20, "location3"
//10, "location1"
//15, "location2"

//10 => "location1"
//14 => "location1"
//16 => "location2"
//20 => "location3"
//100 => "location3"

Class Node{
 public Node left;
 public int ts;
 public String loc;
 public Node right;
 
 public Node(int ts, String loc){
     this.ts = ts;
     this.loc = loc;
 }
}

Class BSTOperations(){
 Node root;
 // Insert
 public void insert(int ts, String loc){
     if(root === null){
         root = new Node(ts, loc);
     } else {
         insert(root,  ts,  loc)
     }
     
 }
 public void insert(Node p, int ts, String loc){
     if(p = null)
         return;
         
     if(ts < p.ts && p.left == null){
         p.left = new Node(ts, loc); 
     }
     if(ts > p.ts && p.righ == null){
          p.right = new Node(ts, loc); 
     }
     
     if(p.ts == ts){
         //TODO: Throexception: Duplicate
     }
     else if( ts < p.ts){
         insert(p.left, ts, loc);
     } else {
          insert(p.right, ts, loc);
     }
     
 }
 
 
 //      10
 //        20
 //      14
 //    12  15
 
 // Previous
 public Node previous(Node  p, int ts){
     if(p ==null){
         return null;
     }
     if(p.left == null)
     {
         return null;
     }
     if(ts<p.ts){
         return max(p.left);
     } else {
         return min(p.right);
     }
 }
 
 // 
 public Node max(Node p){
     if(p == null){
         return null;
     }
     whiel(p.right != null){
         p = p.right;
     }
     return p;
 }
 
}


// OOTB Java approach

NavigationalMap<Integer, String> tsLocMap = new TreeMap<Integer, String>();
tsLocMap.put(k,v);

public String getLocaltionBasedOnTS(int ts){
 // Exaclty found in Map
 String loc = tsLocMap.get(ts);
 if(loc!=null && !"".equals(loc){
     return loc;
 }
 // Get the prev 
 int tsPrev = tsLocMap.prev();
 return tsLocMap(tsLocMap.prev());
}


// PayPal Telephonic
/**
 * Given a nested list of integers, return the sum of all integers in the
 * list weighted by their depth.
 *
 * Example 1: Given the list {{1, 1}, 2, {1, 1}} the function should return 10
 * (four 1's at depth 2, one 2 at depth 1).
 *
 * Example 2: Given the list {1, {4, {6}}} the function should return 27
 * (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3).
 
 L = {1, {4, {6}}}
 
getDepthSum(L,1)
sum = 0 2    
      {1, {4, {6}}}
      /    |
      1    {4, {6}}
      
       
 */

interface NestedList {
   boolean isList();
   int getInteger();
   List<NestedList> getList();
}

public int getDepthSum(NestedList input){
   // Boundary condition
   if(input==null)
   {
       return 0;
   } else {
       // Overloaded method
       return getDepthSum(input, 0);
   }

}

public int getDepthSum(NestedList input, int depth){
   int sum =0;
   // Base Condition
   if(!input.isList()){
       int n = input.getInteger();
       sum+=(n*depth);
   } else{
       // Recursion
       for(NestedList nl: input.getList()){
           depth++;
           sum+=getDepthSum(nl, depth);
       }
  }
  return sum;
}


