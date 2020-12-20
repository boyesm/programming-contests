#include <bits/stdc++.h>
using namespace std;

vector<vector<string>> subs(3);

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string value;

    for (int i = 0; i < 3; i++)
    {
        cin >> value;
        subs[i].push_back(value);
        cin >> value;
        subs[i].push_back(value);
    }

    for (int i = 0; i < subs.size(); i++)
    {
        for (int j = 0; j < subs[i].size(); j++)
        {
            cout << subs[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}