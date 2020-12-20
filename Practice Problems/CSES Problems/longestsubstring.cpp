#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    // string input = "AAAAAAAAAAAAAAAAA";
    string input;
    long int big = 0;
    long int temp = 1;

    cin >> input;

    for (int i = 0; i < input.length(); i++)
    {
        if (input.length() == 1)
        {
            big = 1;
        }
        else if (input[i] == input[i - 1])
        {
            temp++;
        }
        else
        {
            if (temp > big)
            {
                big = temp;
            }
            temp = 1;
        }
    }

    if (temp > big)
    {
        big = temp;
    }

    cout << big;

    return 0;
}