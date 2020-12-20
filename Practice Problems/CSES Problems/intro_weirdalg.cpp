#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    long long int x;

    cin >> x;

    while ( x != 1 ) {
        cout << x << " ";
        x = ( x%2 == 0 ) ? ( x/2 ) : ( (x*3)+1 );
    }
    cout << x << " ";
    return 0;
}