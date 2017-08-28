#include<bits/stdc++.h>
using namespace std;
int k = 0;
int path[1001][1001];

void afis(int arr[101][101], int r, int c){
    int i = 0; int j = 0;
    for(i = 1; i <= r+1; i++){
        for(j = 1; j <= c+1; j++)
            cout<< arr[i][j]<< " ";
    cout << "\n";
    }
}

void border(int arr[101][101], int r, int c){
    int i;
    for(i = 0; i <= c + 1; i++)
        arr[0][i] = 999999;

    for(i = 1; i <= r; i++)
        arr[i][0] = 999999;

    for(i = 1; i <= r; i++)
        arr[i][c+1] = 999999;

    for(i = 0; i <= c + 1; i++)
        arr[r][i] = 999999;

}

void find_p2(int arr[101][101], int i, int j, int r, int c){
   border(arr,r,c);
    while( i <= r)
    {
        j = 1;
        while(j <= c){
            cout<<"I: "<< i<< " ";
            cout<< "J: "<<j << " ";
            if(arr[i][j + 1] > arr[i + 1][j]){
                arr[i + 1][j] = arr[i][j] + 1;
                i+= 1;
            }
            else {
                 arr[i][j + 1] = arr[i][j] + 1;
                 j += 1;
            }
        }
        i++;
        cout << "\n";
    }
    cout<< "\n";
   afis(arr,r,c);
     i = r ;
    j = c;
   while(i > 0 && j > 0){
        cout << i << " "<< j<< "\n";
    if( i - 1 > 0 && j- 1 > 0){
        if(arr[i - 1][j] < arr[i][j -1])
            i --;
        else
            j--;
     }
     else
        if(i - 1 > 0)
            i --;
        else
            j --;
   }

}


void find_p(int arr[101][101], int r, int c){
    find_p2(arr,0,0,r,c);
    int j = c;
    int i = r;
   while(i > 0 && j > 0){
        cout << i + 1 << " "<< j + 1<< "\n";
    if( i - 1 > 0 && j- 1 > 0){
        if(arr[i - 1][j] < arr[i][j -1])
            i --;
        else
            j--;
     }
     else
        if(i - 1 > 0)
            i --;
        else
            j --;
   }
}


int main()
{
    int r,c, i, j;
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    cin >>r>>c;
    int a[101][101];
    for(i = 1; i <= r; i++)
        for(j = 1; j <= c; j++)
            cin>>a[i][j];
    find_p2(a,1,1,r,c);
    return 0;
}
