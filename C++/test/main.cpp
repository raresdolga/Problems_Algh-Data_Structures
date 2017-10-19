//Problem        : Funfair Tickets
//Language       : C++
//Compiled Using : g++
//Version        : GCC 4.9.1
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

#include <iostream>
#include <string>
#include <algorithm>
#include <climits>

using namespace std;
int n, last, i;
int cost[] = {1, 60,3600,1440};
int ticket[] = {2,5,20,50};
long long time;
int v[1000001];
int near(long long t){
    for(int i = 3; i >=0; i--){
        if(v[i]/t > 1)
            return i;
    }
}
int costF(long  long t){
    int bigger = near(t);
    int smaller = 0;
    if(bigger > 0)
        smaller = bigger - 1;
    return min(ticket[])
}
int main() {
    cin >> n;
    for(i = 0; i < n; i++){
        cin>> time;
    }

    return 0;
}
