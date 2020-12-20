#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    unsigned long long int n = 100000000000;

    unsigned int seq[3] = {1, 1, 1};

    int j = 0;

    for (unsigned long long int i = 0; i < n - 2; i++)
    {
        j = i % 3;
        if (j == 0)
        {
            seq[j] = ((seq[1] % 1000000007) + (seq[2] % 1000000007)) % 1000000007;
        }
        else if (j == 1)
        {
            seq[j] = ((seq[0] % 1000000007) + (seq[2] % 1000000007)) % 1000000007;
        }
        else
        {
            seq[j] = ((seq[1] % 1000000007) + (seq[0] % 1000000007)) % 1000000007;
        }
    }

    cout << seq[j] << "\n";

    return 0;
}