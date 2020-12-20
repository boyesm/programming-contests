#include <bits/stdc++.h>
using namespace std;

int sumOfVector(vector<int> vec)
{
    int sum = 0;
    int s = vec.size();

    for (int i = 0; i < s; i++)
    {
        sum += vec[i];
    }

    return sum;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int q_type;
    cin >> q_type;

    int n;
    cin >> n;

    vector<int> dm_speeds;
    vector<int> peg_speeds;
    int temp;

    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        dm_speeds.push_back(temp);
    }
    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        peg_speeds.push_back(temp);
    }

    vector<int> speeds;

    sort(dm_speeds.begin(), dm_speeds.end());
    sort(peg_speeds.begin(), peg_speeds.end());

    if (q_type == 2)
    {
        for (int i = 0; i < n; i++)
        {
            speeds.push_back(max(dm_speeds[n - i - 1], peg_speeds[i]));
        }
    }
    else
    {
        for (int i = 0; i < n; i++)
        {
            speeds.push_back(max(dm_speeds[i], peg_speeds[i]));
        }
    }

    cout << sumOfVector(speeds);

    return 0;
}