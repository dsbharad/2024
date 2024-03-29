====================================================================================================
Problem Description
----------------------------------------------------------------------------------------------------
	You are provided with an integer array A. Return another array B of size same as that of A such that B[i] = A[i]3 for 1 <= i <= |A| (1 based indexing).
====================================================================================================
Problem Constraints
----------------------------------------------------------------------------------------------------
	1 <= |A| <= 10^6
	1 <= A[i] <= 10^6
====================================================================================================	
Input Format
----------------------------------------------------------------------------------------------------
	The first and only argument is an integer array A.
	ArrayList<Integer> A
====================================================================================================	
Output Format
----------------------------------------------------------------------------------------------------
	Return array B.
	ArrayList<Long> 
====================================================================================================
Example Input
----------------------------------------------------------------------------------------------------
	Input 1:	A=[2, 6, 8, 1]
	Input 2:	A=[5]
====================================================================================================	
Example Output
----------------------------------------------------------------------------------------------------
	Output 1:	[8, 216, 512, 1]
	Output 2:	[125]
====================================================================================================
Accepted Answer:
----------------------------------------------------------------------------------------------------
import java.util.stream.IntStream;
import java.lang.Math;
import java.lang.Double;
public class Solution {
    public ArrayList<Long> solve(ArrayList<Integer> A) {
        ArrayList<Long> response = new ArrayList<>();
        IntStream.range(0,A.size()).forEach(index->{
            response.add( Long.valueOf(A.get(index)) * Long.valueOf(A.get(index)) * Long.valueOf(A.get(index)) );
        });
        return response;
    }
}


====================================================================================================