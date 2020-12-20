#include <bits/stdc++.h>
using namespace std;

int d1;
int d2;
int d3;
int d4;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> d1;
    cin >> d2;
    cin >> d3;
    cin >> d4;

    if ((d1 == 8 || d1 == 9) && (d2 == d3) && (d4 == 8 || d4 == 9))
    {
        cout << "ignore";
    }
    else
    {
        cout << "answer";
    }

    return 0;
}