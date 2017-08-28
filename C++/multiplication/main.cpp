#include <bits/stdc++.h>

using namespace std;
int multHelper(int n, int c, int m){
    n = max(n,m);
    m = min(n,m);
    if(m == 0) return 0;
    if(m == 1) return n+c;
    if(m % 2 == 0)
        return multHelper(n + n,c, m >> 1);
    else
        return multHelper(n,n + c,m - 1);
}

int mult(int n, int m){
    return multHelper(n,0,m);
}
int main()
{
    cout << mult(7,9) << endl;
    return 0;
}
