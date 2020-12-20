#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int value_array[6];
    int val_a = 0;
    int val_b = 0;

    for (int i = 0; i < 6; i++)
    {
        cin >> value_array[i];
    }

    for (int i = 0; i < 3; i++)
    {
        val_a += value_array[i] * (3 - i);
        val_b += value_array[i + 3] * (3 - i);
    }

    if (val_a > val_b)
    {
        cout << "A";
    }
    else if (val_a < val_b)
    {
        cout << "B";
    }
    else
    {
        cout << "T";
    }
    return 0;
}