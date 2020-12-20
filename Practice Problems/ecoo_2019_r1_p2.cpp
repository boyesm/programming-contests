#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int r, t;
    string a, ci, tmps;
    char tmpc;
    map<char, string> dict;

    for (int p = 0; p < 10; p++)
    {
        cin >> r >> t >> a;

        for (int i = 0; i < r; i++)
        {
            cin >> tmpc >> tmps;
            dict.insert({tmpc, tmps});
        }

        for (int i = 0; i < t; i++)
        {
            ci = "";
            ci += dict[a[0]];
            ci += dict[a[a.length() - 1]];
            a = ci;
        }

        cout << a[0] << a[a.length() - 1] << " " << a.length() << "\n";
        dict.clear();
    }

    return 0;
}