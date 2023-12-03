#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Linear search algorithm to find a value given a key. O(n)
int LinearSearch(int key)
{
    int a[] = {0, 1, 2, 3, 4, 5};
    int result = 0;
    int length = sizeof(a) / sizeof(a[0]); // Way to calculate the size of an array when you dont know
    printf("Length of array: %d\n", length);

    for (int i = 0; i <= length; i++)
    {
        if (i == key)
        {
            result = 1;
            break;
        }
    }
    return result;
}

int main(int key)
{
    int result = LinearSearch(2);
    printf("result: %d\n", result);

    return 0;
}