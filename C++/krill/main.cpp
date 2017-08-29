#include <bits/stdc++.h>
using namespace std;
string binary(int l, int r, double k, int x, int y){
   int m;
   double nr;
   double frac;
   while( l <= r ){
    m = (int)(l + r)/2;
    nr =  k * m;
    if( x <= nr && y >= nr){
        return "YES";
    }
    frac = nr - (int) nr;
    if(nr < x ){
        l = m + 1;
    }
    else if(nr > y){
        r = m -1;
    }

   }
    return "NO";
}
void test(){
	long long a,b,c,d,e,found=0;
	cin>>a>>b>>c>>d>>e;
	for(long int i=c;i<=d;i++)
	{
		long long val=i*e;
		if(val<=b && val>=a)
		{
			found=1;
			break;
		}
	}
	if(found==0)
	cout<<"NO"<<endl;
	else
	cout<<"YES"<<endl;
}
int main()
{
    int l,r,x,y;
    double k;
    cin >>l>>r>>x>>y>>k;
    /*if(l * k > y || r *k < x){
        cout << "NO";
    }*/
    //else{
        cout<<binary(l,r,k,x,y);
       //test();
    //}

    return 0;
}
