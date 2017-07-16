#include <iostream>
using namespace std;

long change [100], n,m,t[52][252];
    void read()
    {
        cin>>n>>m;
        int i = 0;
        for(i = 1; i <= m; i++)
            cin>>change[i];
            for(i = 1; i <= n; i++)
                t[0][i] = 0;
            for(i = 1; i <= m; i++)
                t[i][0] = 0;
    }
    long long possibilities()
    {
        int i,j;
        for(i = 1; i <= m; i++)
            for(j = 1; j <= n; j++)
            {
             if(change[i] > j )
                    t[i][j] = t[i-1][j];
                else
                    if(change[i] == j)
                        t[i][j] = 1+ t[i-1][j];

                else{
                    t[i][j] = t[i][j - change[i]] + t[i-1][j];
                }
            }
            return t[m][n];
    }

int main()
{
    read();
    cout <<possibilities() << endl;
    return 0;
}
