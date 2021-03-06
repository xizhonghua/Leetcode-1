/**
 * Problem Statement: 
 * Link:
 * Time:
 * Ref: http://answer.ninechapter.com/solutions/combination-sum-ii/
 * 
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 */


public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
       
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        //special case
        if(num.length<1) return rnt;
         
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(num);
        int start = 0;
        
        //dfs find all combinations
        dfs(num, target, start, tmp, rnt);
        
        return rnt;
    }
    
    public void dfs(int[] num, int sum, int start, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> rnt){
        
        //terminate condition
        if(sum==0){
            rnt.add(new ArrayList<Integer>(tmp));
        }
        if(start==num.length || sum<0)
            return;
        
        //TODO: discuss with Hua  
        int prev = -1;
        for(int i=start; i<num.length; i++){
            if(num[i]!=prev){
                tmp.add(num[i]);
                dfs(num, sum-num[i], i+1, tmp, rnt);
                prev = num[i];
                tmp.remove(tmp.size()-1);
            }
        }
       
    }
}


////////////////////////////////////////////////////////
//Round 2: 12/31/2014
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int sum = 0;
        int index = 0;
        int[] used = new int[num.length];
        findCombination(num, used,target,sum, index, tmp, rnt);
        return rnt;
    }
    
    //dfs find all solutions
    public void findCombination(int[] num, int[] used, int target, int sum, int index, ArrayList<Integer> tmp, 
    ArrayList<ArrayList<Integer>> rnt){
        
        //terminate cases
        if(sum==target){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(index==num.length || sum>target) return;
        
        
        for(int i=index; i<num.length; i++){
            
            //case1: has duplicate numbers, and previous number is not used
            if(i>0 && num[i-1]==num[i] && used[i-1]==0){
            }
            //Case 2:dfs
            else{
                used[i] = 1;
                tmp.add(num[i]);
                findCombination(num, used, target, sum+num[i],i+1, tmp, rnt);
                used[i] = 0;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
