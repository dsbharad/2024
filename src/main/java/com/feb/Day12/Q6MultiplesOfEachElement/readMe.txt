====================================================================================================
Problem Description
----------------------------------------------------------------------------------------------------
	Given 2 arrays of integers A and B,
	
	Return a 2D array of integers such that i-th row of the array contains list of values in A such that A[j]%B[i]==0 in A in sequential order
====================================================================================================
Problem Constraints
----------------------------------------------------------------------------------------------------
	1 <= |A| <= 10^3
	1 <= |B| <= 10^3
	1 <= A[i] <= 10^5
	1 <= B[i] <= 10^5
====================================================================================================	
Input Format
----------------------------------------------------------------------------------------------------
	The two arguments A and B are arrayList of integers.
	
	ArrayList<Integer> A, ArrayList<Integer> B
====================================================================================================	
Output Format
----------------------------------------------------------------------------------------------------
	Return a nested arrayList of integers.
====================================================================================================
Example Input
----------------------------------------------------------------------------------------------------
	Input 1:	A = [1, 2, 3, 4]
				B = [1, 2]
	Input 2:	A = [2, 5, 9, 3, 8]
				B = [3, 2]
====================================================================================================	
Example Output
----------------------------------------------------------------------------------------------------
	Output 1:	[ [1, 2, 3, 4 ], [ 2, 4] ]
	Output 2:	[ [9, 3 ], [ 2, 8] ]
====================================================================================================