def list_length(L):
    if L:
        return 1 + list_length(L[1:])
    return 0

def list_length2(L):
    return list_length2_helper(L)

def list_length2_helper(L, n = 0):

    if L:
        return list_length2_helper(L[1:], n+1)
    return n

def list_length3(L):
    n = 0
    for i in L:
        n += 1
    return n

def vowel(word):
    
    vowels = "aeiouAEIOU"
    if word:
        if word[0] in vowels:
            return  1 + vowel(word[1:])
        else:
            return vowel(word[1:])
    else:
        return 0
    
def vowel2(word):
    return vowel2_helper(word)

def vowel2_helper(word):
    vowels = "aeiou"
    if word:
        if word[0].lower() in vowels:
            return 1 + vowel2_helper(word[1:])
        else:
            return vowel2_helper(word[1:])
    else:
        return 0

def vowel3(word):
    vowels = "aeiouAEIOU"
    n = 0
    for i, letter in enumerate(word):
        if letter in vowels:
            n += 1
    return n

def binary(n):
    def binary_helper(n,prefix = ""):
        if n == 0:
            return [prefix]
        else:
            result = []
            if prefix == "" or prefix[-1] == "1":
                result.extend(binary_helper(n-1,prefix + "0"))
            result.extend(binary_helper(n-1, prefix + "1"))
            return result
    return binary_helper(n)

def binary2(n,c):
    def binary2_helper(n,c, prefix = ""):
        if n == 0:
            return [prefix]
        else:
            result = []
            ones = len([n for n in prefix if n == "1"])
            if prefix == "" or ones < c:
                result.extend(binary2_helper(n-1, c, prefix + "1"))
            result.extend(binary2_helper(n-1, c, prefix + "0"))
            return result

    return binary2_helper(n,c)

    
def binary_strings_hw(n, c):
    return binary_strings_hw_helper(n, c)


def binary_strings_hw_helper(n, c, prefix = "", hw_so_far=0):
    if n == 0 and hw_so_far <= c:
        return [prefix]
    else:
        results = []
        if hw_so_far < c:
            results.extend(binary_strings_hw_helper(n - 1, c, prefix + "1", hw_so_far + 1))
        results.extend(binary_strings_hw_helper(n - 1, c, prefix + "0", hw_so_far))
        return results

L = ["1", "2", "3", "asda", ["dwad",[123]]]
S = "wadad jndn312" #2 vowels
S2 = "aeiouAEIOU"
print(list_length(L))
print(list_length2(L))
print(list_length3(L))
print(vowel(S))
print(vowel2(S2))
print(vowel3(S))
print(binary(3))
print(binary2(4,2))
print(binary_strings_hw(4,2))