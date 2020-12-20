#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int a;
    int b;
    int n;
    int t;
    string input;
    cin >> t;

    for (int i = 0; i < t; i++)
    {
        cin >> a;
        a += 1;
        cin >> b;
        cin >> n;

        int guess = round((b - a) / 2);
        cout << guess;

        for (int j = 0; j < n; j++)
        {
            cin >> input;
            if (input == "CORRECT")
            {
                break;
            }
            else if (input == "TOO_SMALL")
            {
                guess = round((guess + a) / 2);
                cout << guess;
            }
            else if (input == "TOO_BIG")
            {
                guess = round
                            cout
                        << guess;
            }
        }
    }

    return 0;
}