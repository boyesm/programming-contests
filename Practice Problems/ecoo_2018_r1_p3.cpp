#include <bits/stdc++.h>
using namespace std;

int x, y, z;

bool answer_key(int code, int answer)
{
    // cout << code << "\n";
    string pc = ""; // processed  code
    string ic = ""; // iterable code
    int t;

    ic = to_string(code);

    // even numbers
    for (int i = 0; i < ic.length(); i++)
    {
        t = ic[i] - '0';
        if (t % 2 == 0)
        {
            t += x;
            pc += to_string(t);
        }
        else
        {
            pc += ic[i];
        }
    }

    cout << code << " " << pc << " ";

    ic = pc;

    pc = "";

    //odd numbers
    for (int i = 0; i < ic.length(); i++)
    {
        t = ic[i] - '0';
        if (t % 2 == 1)
        {
            t -= y;
            if (t < 0)
                t = 0;
            pc += to_string(t);
        }
        else
        {
            pc += ic[i];
        }
    }

    cout << pc << " ";

    ic = pc;
    pc = "";

    //change zeros
    for (int i = 0; i < ic.length(); i++)
    {
        t = ic[i] - '0';
        if (t == 0)
        {
            pc += to_string(z);
        }
        else
        {
            pc += ic[i];
        }
    }

    cout << pc << " " << answer << "\n";

    if (pc == to_string(answer))
        return true;
    else
        return false;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, tmp;
    string tmps;
    vector<int> codes;
    vector<int> answers;
    bool mm;
    vector<bool> match;

    // get input

    cin >> n >> x >> y >> z;
    cout << x << " " << y << " " << z << "\n";

    for (int i = 0; i < n; i++)
    {
        cin >> tmp;
        codes.push_back(tmp);
    }

    cin >> tmps;

    for (int i = 0; i < n; i++)
    {
        cin >> tmp;
        cout << tmp << " ";
        answers.push_back(tmp);
    }

    cout << "\n";

    // process input

    for (int i = 0; i < n; i++)
    {
        //determine if code is mm

        mm = answer_key(codes[i], answers[i]);

        // store mm

        match.push_back(mm);
    }

    for (int i = 0; i < match.size(); i++)
    {
        cout << match[i] << " ";
    }

    return 0;
}

// FAIL: 4
// FAIL: 8
// FAIL: 4,8,13,15,17,20
// FAIL: 7,9,13,18
// FAIL: 3,11,13,17,18,20
// FAIL: 1,11,12,13
// FAIL: 3,7
// MATCH
// FAIL: 2,3,4
// FAIL: 1,2