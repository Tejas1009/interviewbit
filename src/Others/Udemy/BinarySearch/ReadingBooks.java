package Others.Udemy.BinarySearch;

import java.util.Arrays;

/*
Allocate minimum number of pages
Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.
Example :


Input : pages[] = {12, 34, 67, 90}
        m = 2
Output : 113
Explanation:
There are 2 number of students. Books can be distributed
in following fashion :
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student
      2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student
      2 with 67 + 90 = 157 pages
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student
      1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113.

The idea is to use Binary Search. We fix a value for the number of pages as mid of current minimum and maximum. We initialize minimum and maximum as 0 and sum-of-all-pages respectively. If a current mid can be a solution, then we search on the lower half, else we search in higher half.
Now the question arises, how to check if a mid value is feasible or not? Basically, we need to check if we can assign pages to all students in a way that the maximum number doesn’t exceed current value. To do this, we sequentially assign pages to every student while the current number of assigned pages doesn’t exceed the value. In this process, if the number of students becomes more than m, then the solution is not feasible. Else feasible.
Below is an implementation of above idea.

 */
public class ReadingBooks {

    public static int minPages(int books[], int k) {
        int res = 0;
        int s = 1, e = Arrays.stream(books).sum();
        while (s <= e) {
            int mid = (s + e) / 2;
            if (isPossible(books, mid, k)) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }

    private static boolean isPossible(int books[], int sep, int total_students) {
        int student_required = 1, sum_pages = 0;
        for (int i = 0; i < books.length; i++) {
            sum_pages += books[i];
            if (books[i] > sep) return false;
            if (sum_pages > sep) {
                sum_pages = books[i];
                student_required++;
            }
            if (student_required > total_students) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int books[] = {10, 15, 20, 30};
        System.out.println(minPages(books, 2));
    }
}
