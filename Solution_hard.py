q = int(input()) #number of queries 
for i in range(q):
    a = input()
    b = input()
    printed = True
    adict = {}
    bdict = {}
    for p in a:
        adict[p] = 1
    for p in b:
        bdict[p] = 1
    for p in adict:
        if p in bdict: #checks if a and b have any letters in common
            printed = False
            break
    if(printed):
        print('-1')
    else:
        s = ''
        testS = ''
        #finding all substrings of a and b
        substrA = [a[m: n] for m in range(len(a))for n in range(m + 1, len(a) + 1)]
        substrB = [b[m: n] for m in range(len(b))for n in range(m + 1, len(b) + 1)]
        # creates all possible combinations and checks if they are palindromes   
        for j in substrA:
            for k in substrB:
                testS = j+k
                if(testS==testS[::-1]): #compares testS to its reverse (palindrome?)
                    if(len(testS)>len(s)):
                        s = testS
                    elif(len(testS) == len(s) and testS<s):
                        s = testS
        if(s!=''):
            print(s)
#By Issifu