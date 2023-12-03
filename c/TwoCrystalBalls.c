#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// Remember to add -lm to link the math libary when compiling to be able to use the math header.
// ex. "gcc TwoCrystalBalls.c -lm -o output"
int TwoCrystalBalls(int array[], int size){
    int jump_length = floor(sqrt(size));
    int i = jump_length; // you are setting the index to the sqrt, so thats where we will start
    printf("size %d\n",size);
    for(; i < size; i += jump_length){
        printf("loop at: %d\n", i);
        if (array[i] == 1){
            printf("found index: %d\n",i);
            break;
        }
    }

    i -= jump_length;

    for(int j = 0; j < jump_length && i < size; ++j, ++i){
        printf("j run: %d\n",j);
        if(array[i]){
            return i;
        }
    }

    return -1;
}


int main(void){
    int array[] = {0,0,0,0,0,0,0,1,1};
    int size = sizeof(array) / sizeof(array[0]);
    int result = TwoCrystalBalls(array,size);
    printf("result: %d\n", result);
    return 0;
}