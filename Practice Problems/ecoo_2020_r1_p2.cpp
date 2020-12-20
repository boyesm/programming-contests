#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t, n, m, p, q, all;
    cin >> t;

    string iname;
    map<string, int> item_id;

    for (int i = 0; i < t; i++)
    {
        cin >> n;
        vector<vector<int>> items[101];

        for (int j = 0; j < n; j++)
        {
            cin >> m;
            for (int x = 0; x < m; x++)
            {
                cin >> iname >> p >> q;
                item_id.insert({iname, item_id.size()});
                items[item_id[iname]].push_back({p, q});
            }
        }

        for (int j = 0; j < n; j++)
        {
            sort(items[j].begin(), items[j].end());
        }

        cin >> all;
        p = 0;

        for (int j = 0; j < all; j++)
        {
            cin >> iname >> q;
            for (int x = 0; x < items[item_id[iname]].size(); x++)
            {
                if (q - items[item_id[iname]][x][1] >= 0)
                {
                    p += (items[item_id[iname]][x][1] * items[item_id[iname]][x][0]);
                    q -= items[item_id[iname]][x][1];
                }
                else
                {
                    p += q * items[item_id[iname]][x][0];
                    q = 0;
                }
            }
        }
        cout << p << "\n";
        item_id.clear();
        for (int k = 0; k < 101; k++)
        {
            items[k].clear();
        }
        }

    return 0;
}