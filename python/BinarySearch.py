import numpy as np
import math
"""
Python implementation of the classic iteritive version 
of Binary Search
"""

def BinarySearch(array,key):
    low = 0
    high = len(array)
   
    while low < high:
        mid = math.floor(low + (high-low)/2) 
        print(f"mid: {mid}")
        if (array[mid] == key):
            return mid
        if array[mid] < key:
            low = mid + 1
        if array[mid] > key:
            high = mid - 1
    
    
def testBinarySearch():
    array = createArray()
    print(BinarySearch(array,29))
    

def createArray():
    array = np.array([1,2,3,7,9,12,17,18,20,26,29,59,67])
    return array

testBinarySearch()