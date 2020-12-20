#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, m, d, tmp, tld, c_shirts;

    for (int j = 0; j < 10; j++)
    {
        tld = 0;
        cin >> n >> m >> d;
        c_shirts = n;

        vector<int> a(d + 1, 0);

        for (int i = 0; i < m; i++)
        {
            cin >> tmp;
            a[tmp] += 1;
        }

        for (int i = 1; i <= d; i++)
        {
            if (c_shirts <= 0)
            {
                tld++;
                c_shirts = n;
            }
            if (a[i] > 0)
            {
                n += a[i];
                c_shirts += a[i];
            }
            c_shirts--;
            // cout << c_shirts << " n: " << n << "\n";
        }

        cout << tld << "\n";
    }

    return 0;
}