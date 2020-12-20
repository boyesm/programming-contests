#include <bits/stdc++.h>
using namespace std;

map<char, char> key;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    // store input

    string decoded;
    string encoded;
    string encoded_message;

    getline(cin, decoded);
    getline(cin, encoded);
    getline(cin, encoded_message);

    // build decoder

    for (int i = 0; i < decoded.length(); i++)
    {
        key.insert({encoded[i], decoded[i]});
    }

    // decode message

    string decoded_message = "";

    for (int i = 0; i < encoded_message.length(); i++)
    {
        if (key.count(encoded_message[i]) == 1)
        {
            decoded_message += key[encoded_message[i]];
        }
        else
        {
            decoded_message += ".";
        }
    }

    cout << decoded_message << "\n";

    return 0;
}