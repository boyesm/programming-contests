#include <bits/stdc++.h>
using namespace std;

vector<int> f;

void factors(int n)
{
    for (int x = 2; x * x <= n; x++)
    {
        while (n % x == 0)
        {
            f.push_back(x);
            n /= x;
        }
    }

    cout << f.size();

    for (auto x : f)
    {
        cout << x << "\n";
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    // long long int p = 600851475143;

    factors(1000000);

    // int largestP = f[f.size() - 1];
    // cout << largestP;

    return 0;
}