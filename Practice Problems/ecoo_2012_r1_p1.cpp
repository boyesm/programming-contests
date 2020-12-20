#include <bits/stdc++.h>
using namespace std;

int main()
{
    // ios_base::sync_with_stdio(0);
    // cin.tie(0);

    string season_name;
    vector<string> team_names;
    vector<float> ts;
    vector<float> all_sa, all_ba;

    getline(cin, season_name);

    string st;
    int t;
    float f;

    for (int i = 0; i < 10; i++)
    {
        cin >> st;
        team_names.push_back(st);

        cin >> t;

        for (int j = 0; j < 6; j++)
        {
            cin >> t;
            ts.push_back(t);
        }

        f = (ts[2] / ts[0]);

        all_ba.push_back(f);

        f = (((ts[2] - (ts[3] + ts[4] + ts[5])) + ts[3] * 2 + ts[4] * 3 + ts[5] * 4) / ts[0]);

        all_sa.push_back(f);

        ts.clear();
    }

    cout << season_name << "\n";
    cout << "====================\n";

    for (int i = 0; i < 10; i++)
    {
        cout << team_names[i] << ": ";
        printf("%.3f", all_ba[i]);
        cout << " ";
        printf("%.3f", all_sa[i]);
        cout << "\n";
    }
    cout << "====================\n";

    return 0;
}