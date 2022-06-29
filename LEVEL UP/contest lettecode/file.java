class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        long min=Integer.MAX_VALUE;
        long left=0;
        long right=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
        }
        int y = 0;
        int n=nums.length;
        for (int i = 0; i < nums.length; i++) {
            left+=nums[i];
            right=sum-left;
            long main = Math.abs(left / (i + 1) - (i == n-1 ? 0 : right / (n -i - 1)));
            if(min>main)
            {
                min=main;
                y=i;
            }
        }
        return y;
    }
}

class Solution {
    public int countPrefixes(String[] words, String s) {
        int c=0;
        int i=0;
        while(i<s.length())
        {
          String ans=s.substring(0,i+1);
          for(int j=0;j<words.length;j++)
          {
              if(ans.equals(words[j]))c++;
          }
          ans+=s.charAt(i);
            i++;
        }
        return c;
    }
    
}

class Solution {
    public String removeDigit(String number, char digit) {
        ArrayList<String>ans=new ArrayList<>();
        for(int i=0;i<number.length();i++)
        {
            if(number.charAt(i)==digit)
            {
                ans.add(number.substring(0,i)+number.substring(i+1));
            }
        }
        Collections.sort(ans);
        return ans.get(ans.size()-1);
    }
}

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<String>map=new HashSet<>();
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            StringBuilder sb=new StringBuilder();
            c=0;
            
            for(int j=i;j<nums.length ;j++)
            {
                sb.append(nums[j]+" ");
                if(nums[j]%p==0) c++;
                if(c>k)break;
                
                map.add(sb.toString());
            }
        }
        return map.size();
    }

}


// 2262. Total Appeal of A String

// The appeal of a string is the number of distinct characters found in the string.

// For example, the appeal of "abbca" is 3 because it has 3 distinct characters: 'a', 'b', and 'c'.
// Given a string s, return the total appeal of all of its substrings.

// A substring is a contiguous sequence of characters within a string.

 

// Example 1:

// Input: s = "abbca"
// Output: 28
// Explanation: The following are the substrings of "abbca":
// - Substrings of length 1: "a", "b", "b", "c", "a" have an appeal of 1, 1, 1, 1, and 1 respectively. The sum is 5.
// - Substrings of length 2: "ab", "bb", "bc", "ca" have an appeal of 2, 1, 2, and 2 respectively. The sum is 7.
// - Substrings of length 3: "abb", "bbc", "bca" have an appeal of 2, 2, and 3 respectively. The sum is 7.
// - Substrings of length 4: "abbc", "bbca" have an appeal of 3 and 3 respectively. The sum is 6.
// - Substrings of length 5: "abbca" has an appeal of 3. The sum is 3.
// The total sum is 5 + 7 + 7 + 6 + 3 = 28.

class Solution {
    public long appealSum(String s) {
        int n=s.length();
        long h=0,base=0;
        int ch[]=new int[26];
        for(int i=0;i<26;i++)
            ch[i]=-1;
        for(int i=0;i<n;i++)
        {
            base=base+i-ch[s.charAt(i)-'a'];
            ch[s.charAt(i)-'a']=i;
            h+=base;
         
            System.out.println(h);
                
        }
        return h;
    }
}

// 905. Sort Array By Parity

// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

// Return any array that satisfies this condition.

 

// Example 1:

// Input: nums = [3,1,2,4]
// Output: [2,4,3,1]
// Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] % 2 == 1 && nums[j] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
                i++;
            } 
            else if(nums[i]%2==1)
            {
                j--;
            }else{
                i++;
            }
        }
        return nums;
    }
}
// 2265. Count Nodes Equal to Average of Subtree

// Input: root = [4,8,5,0,1,null,6]
// Output: 5
// Explanation: 
// For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
// For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
// For the node with value 0: The average of its subtree is 0 / 1 = 0.
// For the node with value 1: The average of its subtree is 1 / 1 = 1.
// For the node with value 6: The average of its subtree is 6 / 1 = 6.
class Solution {
    int count=0;
    public static class pair{
        int d;
        int data;
        pair(int d,int data)
        {
            this.d=d;
            this.data=data;
        }
        
    }
    public int averageOfSubtree(TreeNode root) {
        averageOfSubtre(root);
        return count;
    }
    public pair averageOfSubtre(TreeNode root) {
        if(root==null)
        {
            pair p=new pair(0,0);
            return p;
        }
         
        pair l= averageOfSubtre(root.right);
        pair r=averageOfSubtre(root.left);
        int sumnode=l.d+r.d+root.val;
        int sum=l.data+r.data+1;
        if(sumnode/sum==root.val)
        {
            count++;
        }
        pair p=new pair(sumnode,sum);
        return p;
        
     }
}

2273. Find Resultant Array After Removing Anagrams
// Input: words = ["abba","baba","bbaa","cd","cd"]
// Output: ["abba","cd"]
// Explanation:
// One of the ways we can obtain the resultant array is by using the following operations:
// - Since words[2] = "bbaa" and words[1] = "baba" are anagrams, we choose index 2 and delete words[2].
//   Now words = ["abba","baba","cd","cd"].
// - Since words[1] = "baba" and words[0] = "abba" are anagrams, we choose index 1 and delete words[1].
//   Now words = ["abba","cd","cd"].
// - Since words[2] = "cd" and words[1] = "cd" are anagrams, we choose index 2 and delete words[2].
//   Now words = ["abba","cd"].
// We can no longer perform any operations, so ["abba","cd"] is the final answer.

class Solution {
    public List<String> removeAnagrams(String[] words) {
        String ans="";
        ArrayList<String>main=new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            char[]arr=words[i].toCharArray();
            Arrays.sort(arr);
            String temp=new String(arr);
            if(!ans.equals(temp))
            {
                main.add(words[i]);
            }
            ans=temp;
        }
        return main;
    }
}
2274. Maximum Consecutive Floors Without Special Floors
// Input: bottom = 2, top = 9, special = [4,6]
// Output: 3
// Explanation: The following are the ranges (inclusive) of consecutive floors without a special floor:
// - (2, 3) with a total amount of 2 floors.
// - (5, 5) with a total amount of 1 floor.
// - (7, 9) with a total amount of 3 floors.
// Therefore, we return the maximum number which is 3 floors.

class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int c=-(int)1e9;
        c=Math.max(c,special[0]-bottom);
        for(int i=1;i<special.length;i++)
        {
            c=Math.max(c,special[i]-special[i-1]-1);
        }
        c=Math.max(c,top-special[special.length-1]); 
        return c;
    }
}

2275. Largest Combination With Bitwise AND Greater Than Zero

class Solution {
    public int largestCombination(int[] candidates) {
        int[] ans = new int[32];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < candidates.length; j++) {
                if (((candidates[j] >> i) & 1) == 1) ans[i]++;
            }
        }
        int max = -(int) 1e9;
        for (int i = 0; i < ans.length; i++) {
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}

//2269. Find the K-Beauty of a Number
class Solution {
    public int divisorSubstrings(int num, int k) {
        String str="";
        str+=num;
        int c=0;
        int m=0;
        for(int i=0;i<str.length()-k+1;i++){
            
            String ans=str.substring(i,i+k);
           if(Integer.parseInt(ans)!=0 && num%Integer.parseInt(ans)==0)c++;
        }
        return c;
    }
}
    
2270. Number of Ways to Split Array
// Input: nums = [10,4,-8,7]
// Output: 2
// Explanation: 
// There are three ways of splitting nums into two non-empty parts:
// - Split nums at index 0. Then, the first part is [10], and its sum is 10. The second part is [4,-8,7], and its sum is 3. Since 10 >= 3, i = 0 is a valid split.
// - Split nums at index 1. Then, the first part is [10,4], and its sum is 14. The second part is [-8,7], and its sum is -1. Since 14 >= -1, i = 1 is a valid split.
// - Split nums at index 2. Then, the first part is [10,4,-8], and its sum is 6. The second part is [7], and its sum is 7. Since 6 < 7, i = 2 is not a valid split.
// Thus, the number of valid splits in nums is 2.
class Solution {
    public int waysToSplitArray(int[] nums) {
        if (nums.length == 1) return 0;
        long[] l = new long[nums.length];
        long[] r = new long[nums.length];
        r[0] = nums[0];
        int c = 0;
        for (int i = 1; i < nums.length; i++) {
            r[i] = r[i - 1] + nums[i];
        }
        l[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            l[i] = l[i + 1] + nums[i];
            //System.out.println(sum[i]+" ");
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (r[i] >= l[i + 1]) c++;
        }

        return c;
    }
}

//2278. Percentage of Letter in String
class Solution {
    public int percentageLetter(String s, char letter) {
        int c=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==letter)c++;
        }
        long ans=(c*100/s.length());
        
        return (int)ans;
    }
}
//2279. Maximum Bags With Full Capacity of Rocks
// Input: capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
// Output: 3
// Explanation:
// Place 1 rock in bag 0 and 1 rock in bag 1.
// The number of rocks in each bag are now [2,3,4,4].
// Bags 0, 1, and 2 have full capacity.
// There are 3 bags at full capacity, so we return 3.
// It can be shown that it is not possible to have more than 3 bags at full capacity.
// Note that there may be other ways of placing the rocks that result in an answer of 3.
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int c=0;
        for(int i=0;i<capacity.length;i++)
        {
            capacity[i]-=rocks[i];
        }
        Arrays.sort(capacity);
         for(int i=0;i<capacity.length &&additionalRocks>0 ;i++)
        {
            if(capacity[i]<=additionalRocks)c++;
             additionalRocks-=capacity[i];
             
        }
        return c;
    }
}
//2280. Minimum Lines to Represent a Line Chart
class Solution {
    public int minimumLines(int[][] stock) {
        int n = stock.length,res = 0;
        Arrays.sort(stock,(a,b) -> a[0] - b[0]);
        
        for(int i=0;i<n-1;++i){
            if(i == n-2){res++; continue;} // it's not part of previous line and there is no next line
                int x1 = stock[i+1][1] - stock[i][1] , x2 = stock[i+2][1] - stock[i+1][1];
                int y1 = stock[i+1][0] - stock[i][0] , y2 = stock[i+2][0] - stock[i+1][0];
				// Cross Multiplication 
				// x1/y1 != x2/y2 can be written as x1 * y2 != x2 * y1
                if(x1 * y2 != x2 * y1) res++;
        }
        return res;
    }
}
// Longest Binary Subsequence Less Than or Equal to K
// Input: s = "1001010", k = 5
// Output: 5
// Explanation: The longest subsequence of s that makes up a binary number less than or equal to 5 is "00010", as this number is equal to 2 in decimal.
// Note that "00100" and "00101" are also possible, which are equal to 4 and 5 in decimal, respectively.
// The length of this subsequence is 5, so 5 is returned.

class Solution {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        int p = 0;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                sum += Math.pow(2, p);
                p++;
                if (sum <= k) {
                    count++;
                } else {
                    return count;
                }
            } else {
                p++;
            }
        }
        return count;
    }
}

