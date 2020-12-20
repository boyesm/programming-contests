#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    int input;

    n = getchar_unlocked();

    int ref[n];
    int odd[n-1];

    for ( int i = 0; i < n-1; i++ ) {

        while ( true ) {
            
            input = getchar_unlocked();
            if ( isspace(input) ) {
                break;
            }
            odd[i] += odd[i]*10 + input;

        }
    }

    sort(odd, odd+n-1);

    for ( int j = 0; j < n; j++ ) {

        ref[j] = j+1;

    }

    for ( int k = 0; k < n; k++ ) {

        if ( ref[k] != odd[k] ) {

            cout << k+1;
            break;

        }

    }

    return 0;
}