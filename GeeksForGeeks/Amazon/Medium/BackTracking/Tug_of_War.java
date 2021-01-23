// https://www.geeksforgeeks.org/tug-of-war/

// Question Name - Tug of War

// Input arr = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20}
//
// Output
// {4, 100, 1, 23, 20} {3, 5, -3, 89, 54}
//
// Explination:-
// Both output subsets are of size 5 
// and sum of elements in both subsets 
// is same (148 and 148)
//


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Taking Input
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
        System.out.println(ans);
    }

    static int mindiff = Integer.MAX_VALUE;
    static String ans = "";

    public static void solve(int[] arr, int idx, ArrayList<Integer> set1, ArrayList<Integer> set2, int sumset1,
            int sumset2) {
        // Base Case
        if (arr.length == idx) {
            if (mindiff > Math.abs(sumset1 - sumset2)) {
                mindiff = Math.abs(sumset1 - sumset2); // Update Mindiff is Required
                ans = set1 + " " + set2; // Update ans is Required
            }
            return;
        }
        //Check for set1
        if (set1.size() < (arr.length + 1) / 2) {
            set1.add(arr[idx]);
            solve(arr, idx + 1, set1, set2, sumset1 + arr[idx], sumset2); // Add in sumset1
            set1.remove(set1.size() - 1); //Remove last element during Backtracking
        }
        //Check for set2
        if (set2.size() < (arr.length + 1) / 2) {
            set2.add(arr[idx]);
            solve(arr, idx + 1, set1, set2, sumset1, sumset2 + arr[idx]); // Add in sumset2
            set2.remove(set2.size() - 1); // Remove last element during Backtracking
        }

    }

}