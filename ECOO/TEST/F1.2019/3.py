file = open("DATA31.txt", "r")
input = file.readline().split(' ')

N = int(input[0])
M = int(input[1])
ribbon = []
loc = []
dir = []

for i in range(N * 3 - 2):
    if i < (N - 1):
        ribbon.append(0)
    elif i < 2 * N - 1:
        ribbon.append(1)
    else:
        ribbon.append(0)

for i in range(M):
    line = file.readline().split(' ')
    loc.append(int(line[0]))
    dir.append(str(line[1].split('\n')[0]))

max = 1
for i in range(M):
    P = loc[i] - 1 + (N - 1)
    if dir[i] == 'L':
        for j in range(P - (N - 1)):
            ribbon[P + j] += ribbon[(N - 1) + j]
            ribbon[(N - 1) + j] = 0
            if ribbon[P + j] > max:
                max = ribbon[P + j]
    else:
        for j in range(len(loc) + P - N):
            ribbon[(N - 1) + j] += ribbon[P + j + 1]
            ribbon[P + j + 1] = 0
            if ribbon[(N - 1) + j] > max:
                max = ribbon[(N - 1) + j]
    counter = 0
    for i in ribbon:
        if i != 0:
            counter += 1
    N = counter

print(str(N) + ' ' + str(max))