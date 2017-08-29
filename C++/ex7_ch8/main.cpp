#include <bits/stdc++.h>

using namespace std;

vector<string> perm(char current[], int sz){
    vector<string> param;
    string c;
    c.push_back(current[sz - 1]);
   if(sz == 1){
        //cout<<(current[0])<<"\n";

        param.push_back(c);
        return param;
    }
    vector<string> old = perm(current,sz -1);
    int j;
    string temp;
    for(int i  = 0; i < old.size(); i++){
        for(j = 0; j <= (old.at(i)).size(); j++){
            temp = old.at(i);
            param.push_back(temp.insert(j,c));
        }

    }
    return param;
 }
int main()
{
    string a;
    cin >> a;
    char c[a.size()+1];
    strcpy(c,a.c_str());
    /*for(int i = 0; i < a.size(); i++)
        cout<<c[i];
    cout<<"\n";*/
    vector<string> permutations = perm(c,a.size());
    for(int i = 0; i < permutations.size(); i++){
        cout<<permutations.at(i)<<"\n";
    }
    cout << permutations.size();
    return 0;
}
