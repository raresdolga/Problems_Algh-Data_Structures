#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b){
    while(a != b){
        if( a > b) a = a - b;
            else
                b = b - a;
    }
    return a;
}
int countWays(int n, int val []){
    if(n == 0) return 1;
    int s = 0, maxi = 0, aux = 0;
    for(int i = 3; i >=0; i--){
        if((n - val[i] >= 0)){
          aux = n/val[i];
          maxi = n - val[i]*aux;
          s+= 1 + countWays(maxi,val);
        }
    }
    return s;
}

int main(){
    int n, val [5] = {1,5,10,25};
    cin >>n;
    cout << countWays(n,val);
}
