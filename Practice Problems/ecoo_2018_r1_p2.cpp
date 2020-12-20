#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, r, tmp, a, b, id;
    vector<vector<int>> rd;

    for (int v = 0; v < 10; v++) //************** chaneg back to 10!!!!!!!!!
    {
        cin >> n;
        for (int i = 0; i < n; i++)
        {
            cin >> id >> r;
            for (int j = 0; j < r; j++)
            {
                cin >> tmp;
                rd.push_back({tmp, id});
            }
        }

        sort(rd.begin(), rd.end());

        // for (int i = 0; i < rd.size(); i++)
        // {
        //     cout << rd[i][0] << " ";
        // }
        // cout << "\n";

        a = 0;
        set<int> ind;

        while (rd[0][0] == rd[a][0])
        {
            ind.insert(rd[a][1]);
            a++;
        }

        cout << rd[0][0] << " {";

        b = 0;

        for (auto x : ind)
        {
            if ((b > 0) && (b < ind.size()))
            {
                cout << ",";
            }
            cout << x;
            b++;
        }
        cout << "}\n";

        rd.clear();
    }

    return 0;
}