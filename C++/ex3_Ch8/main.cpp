#include <bits/stdc++.h>
using namespace std;

vector<int> read(){
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    int n,a;
    cin >> n;
    vector<int> input;
    for(int i = 0; i < n; i ++){
        cin >> a;
        input.push_back(a);
    }
    return input;
}

//values are distinct
int magicIndex_BinarySearch(vector<int> values){
    int i = 0;
    int j = values.size() - 1;
    int middle;
    int aux;
    while(i <= j){
        middle = (i + j)/2;
        if(values[middle] > middle){
            middle = min(middle - 1, values[middle]);
            for(int k = i; k <= middle; k++)
                if(values[k] == k)
                    return k;
            aux = j;
            i = (i + j)/2 + 1;
        }
        else if(values[middle] < middle){
            middle = max(middle + 1, values[middle]);
            for(int k = middle; k <= aux; k++)
                if(values[k] == k)
                    return k;

             j = (i + j)/2 - 1;
        }
        else {
            return middle;
        }
    }
    return -1;
}

//if values are not distinct
int magicIndex_NotDistinct(vector<int> values, int i, int j){
    if(i < j)
        return -1;
    int middle = (i + j)/2;
    int val = values[middle];
    if(val == middle)
        return middle;
    int left = min(val, middle - 1);
    int l = magicIndex_NotDistinct(values,i,left);
    if(l >= 0)
        return l;
    int right = max(val, middle + 1);
    int r = magicIndex_NotDistinct(values,right,j);
    if(r >= 0)
        return r;

}

int main()
{
    vector<int> values = read();
    int magicIndex = magicIndex_NotDistinct(values,0,values.size() - 1);
    if(magicIndex == -1)
        cout << "There is no magic index" << "\n";
    else
        cout << magicIndex;
    return 0;
}
