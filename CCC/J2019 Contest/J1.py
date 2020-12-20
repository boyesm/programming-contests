scoreList = []

for n in range(2):
    j = 3
    score = 0
    while(j > 0):
        score += j*int(input())
        j-=1
    scoreList.append(score)

if int(scoreList[0]) > int(scoreList[1]):
    print("A")
elif int(scoreList[0]) < int(scoreList[1]):
    print("B")
else:
    print("T")
