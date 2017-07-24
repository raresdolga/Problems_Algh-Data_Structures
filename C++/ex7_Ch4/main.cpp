#include <bits/stdc++.h>
using namespace std;
typedef struct Node {
    vector<int> neigh;
} node_t;
int nrNodes;
vector<node_t> arr;
void read() {
    freopen("input.txt","r",stdin);
    freopen("input.txt","w",stdin);
    cin>>nrNodes;
    cin.get();
    int i = 0;
    int a;
    string line;
    node_t temp;
    while(i < nrNodes) {
        getline(cin,line);
        istringstream f(line);
        //dummy variable;
        arr.push_back(temp);
        while(f >>a) {
            arr[i].neigh.push_back(a);
        }
        i++;
    }
}
int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
