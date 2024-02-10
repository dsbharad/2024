====================================================================================================
Problem Description
----------------------------------------------------------------------------------------------------
	Given a 2D integer array A, return the transpose of A.
	The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
====================================================================================================
Problem Constraints
----------------------------------------------------------------------------------------------------
	1 <= A.size() <= 1000
	1 <= A[i].size() <= 1000
	1 <= A[i][j] <= 1000
====================================================================================================	
Input Format
----------------------------------------------------------------------------------------------------
	First argument is a 2D matrix of integers.
	ArrayList<ArrayList<Integer>> A
====================================================================================================	
Output Format
----------------------------------------------------------------------------------------------------
	You have to return the Transpose of this 2D matrix.
	ArrayList<ArrayList<Integer>>
====================================================================================================
Example Input
----------------------------------------------------------------------------------------------------
	Input 1:	A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
	Input 2:	A = [[1, 2],[1, 2],[1, 2]]
====================================================================================================	
Example Output
----------------------------------------------------------------------------------------------------
	Output 1:	[[1, 4, 7], [2, 5, 8], [3, 6, 9]]
	Output 2:	[[1, 1, 1], [2, 2, 2]]
====================================================================================================
Accepted Answer:
----------------------------------------------------------------------------------------------------
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;
import java.util.Iterator;
public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> response = new ArrayList<>();
        int colSize= A.get(0).size();
        for(int row=0; row<colSize; row++){
            response.add(new ArrayList<>());
        }
        for(int row=0; row<A.size(); row++){
            for(int col=0; col<colSize; col++){
                response.get(col).add(A.get(row).get(col));
            }
        }
        return response;
    }
}

====================================================================================================