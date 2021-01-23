// https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/

// Find Maximum size rectangle binary sub-matrix with all 1's in a matrix
//
//Input:
// 0 1 1 0
// 1 1 1 1
// 1 1 1 1
// 1 1 0 0

// Output :
// 8

// Explanation : 
// The largest rectangle with only 1's is from 
// (1, 0) to (2, 3) which is
// 1 1 1 1
// 1 1 1 1 

class Java {
    public int maxArea(int matrix[][], int row, int col) {

        // Check for first Column
        int area = maxRectHist(row, col, matrix[0]);

        // Check for another Column
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
            int maxx = maxRectHist(row, col, matrix[i]);
            area = Math.max(maxx, area); // Update area if it is smaller than maxx
        }

        return area; // Retuen answer
    }

    public int maxRectHist(int row, int col, int[] a) {

        Stack<Integer> st = new Stack<Integer>();// Create Stack
        int max_area = 0;
        int idx = 0;
        while (idx < col) {
            // Stack is empty or current elemnt is greater than top elt.
            if (st.empty() || a[st.peek()] <= a[idx]) {
                st.push(idx++);
            }
            // Stack is not empty or current elemnt is smaller than top elt.
            else {
                int i, top = st.pop();// Top element in stack
                i = idx;
                if (!st.empty()) {
                    i = idx - st.peek() - 1;
                }
                max_area = Math.max(max_area, a[top] * i);// Calculate Max Area
            }
        }
        // if Stack is not empty
        while (!st.empty()) {
            int i, top = st.pop(); // Top element in stack
            i = idx;
            if (!st.empty()) {
                i = idx - st.peek() - 1;
            }
            max_area = Math.max(max_area, a[top] * i);// Calculate Max Area
        }
        return max_area;
    }
}
