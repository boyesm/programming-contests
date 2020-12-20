#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t, n, cur_boxes, cur_box_life;
    char eb;

    for (int j = 0; j < 10; j++)
    {
        cin >> t >> n;

        cur_boxes = 0;
        cur_box_life = 0;

        for (int i = 0; i < n; i++)
        {
            cin >> eb;
            if (eb == 'B')
                cur_boxes++;

            if (cur_box_life <= 0)
            {
                if (cur_boxes > 0)
                {
                    cur_boxes--;
                    cur_box_life = t;
                }
            }
            if (cur_box_life > 0)
            {
                cur_box_life--;
            }
        }

        cout << ((cur_boxes * t) + cur_box_life) << "\n";
    }

    return 0;
}