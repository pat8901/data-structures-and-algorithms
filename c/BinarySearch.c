#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// Iterative version of a Binary Search
int BinarySearch(int array[], int key, int size){
    int lo = 0;
    int hi = size;
    
    // Be aware of your plus 1 and minus 1. in the while condition and if-else statements
    while (lo < hi) {
        int mid = lo + (hi-lo)/2; // The index
        if (key == array[mid]){
           return mid;
        }
        if(key < array[mid]){
            hi = mid;
        }
        else {
            lo = mid + 1;
        }
    }
    return -1;
}

int main(void){
    int array[] = {1,5,7,9,10,14};
    int size = sizeof(array) / sizeof(array[0]);
    int result = BinarySearch(array,9,size);
    //printf("result: %d\n",  BinarySearch(array, 7, size)); // When arrays are passed to a function they forget their size.
    // This is Ternary Operator. similar to if-else
    (result == -1) ? printf("The element was not found")
    : printf("The element was found at index %d\n", result);
    return 0;
}
