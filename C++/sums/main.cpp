#include <iostream>
using namespace std;

int set1[] = {1,2,3};
int count1(int n){
   int c =0;
    if(n == 0)
        return 0;
    if( n < 0)
        return -1;
    int p;
    for(int i = 0; i < 3; i++){
        p = count1(n - set1[i]);
        if(p == 0)
            c += 1;
        else
            if(p > 0)
                c += p;
    }
    return c;
    }

int count2(int n){
    int c[n];
    c[0] = 0;
    int j;
    for( int i = 1; i <= n; i++){
        for(j = 0; j < 3; j++)
            if(i - set1[j] == 0)
                c[i]++;
            else
                if(i - set1[j] > 0)
                    c[i] += c[i - set1[j]];
    }
    return c[n];
}
int main()
{
    cout <<count2(4) << endl;
    return 0;
}
