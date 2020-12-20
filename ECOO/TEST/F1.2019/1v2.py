file = open("DATA11.txt", "r")

for j in range(10):
    N = file.readline()
    N = int(N)
    output = []
    for emailN in range(N):
        input = file.readline().lower()
        email = input.split("@")
        emailUserName = email[0]
        emailDomain = email[1]

        emailUserName = emailUserName.split("+")
        emailUserName = emailUserName[0]

        i = 0
        while i < len(emailUserName):
            if emailUserName[i] == ".":
                emailUserName = emailUserName[0: i] + emailUserName[i + 1:]
            else:
                i += 1
        finalEmail = emailUserName + "@" + emailDomain

        def checkOutput(output, finalEmail):
            outputLength = len(output)
            for i in range(outputLength):
                if output[i] == finalEmail:
                    return;
            output.append(finalEmail)

        checkOutput(output, finalEmail)
    print(len(output))


