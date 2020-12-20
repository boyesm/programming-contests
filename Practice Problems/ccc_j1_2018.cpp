#include <bits/stdc++.h>
using namespace std;

int dig1;
int dig2;
int dig3;
int dig4;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> dig1;
    cin >> dig2;
    cin >> dig3;
    cin >> dig4;

    if ((dig1 == 8 || dig1 == 9) && (dig2 == dig3) && (dig4 == 8 || dig4 == 9))
    {
        cout << "ignore\n";
    }
    else
    {
        cout << "answer\n";
    }

    return 0;
}