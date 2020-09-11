## Elementary Sorting Algorithms

https://www.toptal.com/developers/sorting-algorithms

https://www.bigocheatsheet.com/

https://www.youtube.com/channel/UCIqiLefbVHsOAXDAxQJH7Xw

#### 1. Bubble Sort - Time Complexity O(N^2) / Space Complexity O(1)

* **Summary**:
Compare every element with the next element and if the first element is
 larger than the next one, then swap them, if not, then continue with the
  next element. When we are done with the first iteration, the max element will
   be on the last position or (N-1). When we iterate again, the second max will
    be on the N-2 position etc. until all elements get sorted.
    
    * **N** is the number of elements in the list

* **Big O**
    * Time Complexity O(N^2) - avg. and worst case scenario
    * Space Complexity O(1) - inline sorting

* **Useful When**  
    * The datasets are VERY small
    * The space is VERY limited => O(1) and the time doesn't matter
    * When the elements are nearly sorted => time complexity can be
     close to O(N)
     
* **Slow in case of:**
     - Random Ordered Elements
     - Elements Sorted in Reversed Order
     - When there are many duplicated elements
     
* **Fast in case of:**
     - Nearly sorted elements

#### 2. Selection Sort

* **Summary**:
Scanning for the smallest item and placing it on the first position.
On the next iteration, starting from the second position, scanning for the
 second smallest item and so on until we reach the last position.
 
 * **Big O**
     * Time Complexity O(N^2) - best, avg. and worst case scenario
     * Space Complexity O(1) - inline sorting
 
 * **Useful When**  
     * The space is VERY limited => O(1) and the time doesn't matter
     * Even in the best case scenario, the time complexity is O(N^2)
     * Bubble Sort is better than Selection Sort

#### 3. Insertion Sort

* **Summary**:
Start with the first element and compare with the next one, if it's larger than
 the second, then swap their places. Go with the third element, if less than the
  second, leave it where it is. Then go with the fourth element, if larger than
   the third, leave where it is, otherwise compare with the elements left of
    the third and swap until you find the right place.
    
* **Useful When**  
    * The datasets are VERY small
    * The space is VERY limited => O(1) and the time doesn't matter
    * When the elements are nearly sorted => time complexity can be close to
     O(N)
    * Better than Bubble Sort