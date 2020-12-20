#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        string input;
        cin >> input;
        string output = "";
        char tempchar = input[0];
        int tempint = 0;

        for (int j = 0; j <= input.length(); j++)
        {
            if (tempchar == input[j] && j != input.length())
            {
                tempint++;
            }
            else
            {
                ostringstream oss;
                oss << tempint;
                output += (oss.str() + " " + tempchar + " ");

                tempchar = input[j];
                tempint = 1;
            }
        }
        cout << output << "\n";
    }

    return 0;
}