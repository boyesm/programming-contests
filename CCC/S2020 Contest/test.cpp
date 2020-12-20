#include <bits/stdc++.h>
using namespace std;

bool is_integer(float k)
{
    return floor(k) == k;
}

vector<vector<int>> factor_pairs(float n)
{
    vector<vector<int>> pairs;
    float val;

    for (float i = 1; i <= n; i++)
    {
        val = n / i;
        if (is_integer(val))
        {
            pairs.push_back({i, val});
        }
    }

    return pairs;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    vector<vector<int>> pairs = factor_pairs(6);

    for (int i = 0; i < pairs.size(); i++)
    {
        for (int j = 0; j < pairs[i].size(); j++)
        {
            cout << pairs[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}