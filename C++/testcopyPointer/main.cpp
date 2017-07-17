#include <iostream>
#include <stdlib.h>
using namespace std;

int main()
{
    int * a = (int *) malloc(sizeof(int));
    int * b = (int *) malloc(sizeof(int));
    *a = 5;
    *b = *a;
    //the copied pointers will have the same address in memory
    cout << a<<"\n"<<b;

    return 0;
}
