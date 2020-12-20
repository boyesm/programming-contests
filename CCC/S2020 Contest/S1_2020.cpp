#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    double highest_speed = 0.0;

    // get input

    int n;
    cin >> n;

    double temp1;
    double temp2;

    vector<vector<double>> st_vals;

    for (int i = 0; i < n; i++)
    {
        cin >> temp1;
        cin >> temp2;
        st_vals.push_back({temp1, temp2});
    }

    sort(st_vals.begin(), st_vals.end());

    double cur_v = 0;

    for (int i = 0; i < n - 1; i++)
    {
        cur_v = abs((st_vals[i + 1][1] - st_vals[i][1]) / (st_vals[i + 1][0] - st_vals[i][0]));

        highest_speed = max(cur_v, highest_speed);
    }

    cout << highest_speed;

    return 0;
}