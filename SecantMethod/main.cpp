/*#include <bits/stdc++.h>

using namespace std;

int f(double x){
    // define the function here
    double y = (-1)*pow(x,2) + 5;
    return y;
}

int secantMethod(int repetitions, double a, double b){
    // start from 0 or a random number- which might yield better results
    double xs = 0;
    for(int i = 0; i < repetitions; i++){
        xs = b - ((f(b)*(b - a))/(f(b) - f(a)));
        a = b;
        b = xs;
    }
    return xs;
}

int main()
{
    cout << secantMethod(5,7,9) << endl;
    return 0;
}*/
//newton rapson
// C++ program for implementation of Newton Raphson Method for
// solving equations
#include<bits/stdc++.h>
#define EPSILON 0.01
using namespace std;

// An example function whose solution is determined using
// Bisection Method. The function is x^3 - x^2  + 2
double func(double x)
{
    //return (-285)*pow(x,6) + 41*pow(x,5) + 74*pow(x,4)+ 123*pow(x,3) + 90*pow(x,2) + 55*x - 11;
    //return 20*pow(x,3) + 5* pow(x,2) -8*x -20;
    return 96000 *x *pow((1 + x), 60) - 1028.61*pow((1 + x),60) - 1028.61 + 97662.97*x;
}

// Derivative of the above function which is 3*x^x - 2*x
double derivFunc(double x)
{
    //return (-1710)*pow(x,5) + 205*pow(x,4) + 296*pow(x,3) + 369*pow(x,2) + 180*x + 55;
   //return 60*pow(x,2) - 10*x - 8;
   return 9600*pow((1 + x), 60) + 576000*x*pow((1 + x), 59) - 61716.6*pow((1 + x), 59) + 97662.97;
}

// Function to find the root
void newtonRaphson(double x, int n)
{
    double h = func(x) / derivFunc(x);
    while (abs(h) >= EPSILON)
   // for(int i = 0; i <= n; i++)
    {
        h = func(x)/derivFunc(x);

        // x(i+1) = x(i) - f(x) / f'(x)
        x = x - h;
        cout << x << "\n";
    }

    cout << "The value of the root is : " << x;
}

// Driver program to test above
int main()
{
    double x0 = 0.4; // Initial values assumed
    cout << func(1.09) << "\n";// << func(1.09368)/pow(1.09368, 6)<<"\n";
    newtonRaphson(x0, 100);
    return 0;
}
