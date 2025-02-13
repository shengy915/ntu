structure = [[[7], 1, [9]], 3, [[8], 2, [4]]]

def numOfNodes(t:list):
    #base case
    if len(t) == 1:
        return 1
    
    #recursive case
    else:
        left = numOfNodes(t[0])
        right = numOfNodes(t[2])
        return left + right + 1
    return False


def sumNodes(t:list):
    if len(t) == 1:
        return t[0]
    else:
        left_val = sumNodes(t[0])
        right_val = sumNodes(t[2])
        return (left_val + right_val + t[1])
    return False

def maxNodes(t:list):
    if len(t) == 1:
        value = t[0]
        return value
    else:
        value = t[1]
        left_max = maxNodes(t[0])
        right_max = maxNodes(t[2])
        if left_max > value:
            value = left_max
        if right_max > value:
            value = right_max
        return value
    return False

def minNodes(t:list):
    if len(t) == 1:
        value = t[0]
        return value
    else:
        value = t[1]
        left_min = minNodes(t[0])
        right_min = minNodes(t[2])
        if left_min < value:
            value = left_min
        if right_min < value:
            value = right_min
        return value

def mirror(t:list):
    if len(t) == 1:
        return t
    else:
        left = mirror(t[0])
        right = mirror(t[2])
        temp = left
        left = right
        right = temp
        return [left,t[1],right]

def print_structure(t:list, level):
    
    if len(t)==1:
        print(level * " " , t[0])
    else:
        print_structure(t[0], level + 1)
        print(level * " " , t[1])
        print_structure(t[2], level + 1)


print(structure)
no_of_nodes = numOfNodes(structure)
print(no_of_nodes)
total = sumNodes(structure)
print(total)
max_value = maxNodes(structure)
print(max_value)
min_value = minNodes(structure)
print(min_value)
mirrored = mirror(structure)
print(mirrored)
print_structure(structure, 0)