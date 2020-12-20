#include <bits/stdc++.h>
using namespace std;

void modOut( int i, int n, string out ) {

    if ( i % n == 0 ) {

        return out;

    }

    return "";

}


int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int numArray[2] = { 3, 5 };
    string wordArray[2] = { "Fizz", "Buzz" };

    for ( int i = 0; i <= 100; i++ ) {

        string output = "";
        
        for ( int j = 0; j < wordArray.length; j++ ){

            output += modOut( i, numArray[j], wordArray[j]);

        }



    }





    return 0;
}