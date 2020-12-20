#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        int num;
        char charac;

        cin >> num;
        cin >> charac;

        string out(num, charac);

        cout << out << "\n";
    }

    return 0;
}