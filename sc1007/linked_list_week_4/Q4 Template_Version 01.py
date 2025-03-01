class ListNode:
    def __init__(self, num):
        self.num = num
        self.next = None

def printList(head):
    cur = head
    while cur is not None:
        print(cur.num, end=" ")
        cur = cur.next
    print()

def findNode(head, index):
    if head is None or index < 0:
        return None
    cur = head
    while index > 0:
        cur = cur.next
        if cur is None:
            return None
        index -= 1
    return cur

def insertNode(ptrHead, index, value):
    newNode = ListNode(value)
    if ptrHead is None:
        return newNode
    if index == 0:
        newNode.next = ptrHead
        return newNode
    cur = ptrHead
    prev = None
    count = 0
    while cur is not None and count < index:
        prev = cur
        cur = cur.next
        count += 1
    if prev is not None:
        prev.next = newNode
        newNode.next = cur
    return ptrHead

def deleteList(ptrHead):
    cur = ptrHead
    while cur is not None:
        temp = cur.next
        cur.next = None 
        cur = temp
    return None

def duplicateReverse(head, ptrNewHead):
    # write your code here #
    cur = head
    new_head = None
    new_tail = head
    prev = None
    index = 0
    dupe_head = None
    if head.next == None:
        ptrNewHead.append(head)
        return
    
    while cur != None:
        item = cur.num
        dupe_head = insertNode(dupe_head, index, item)
        index += 1
        cur = cur.next

    cur = dupe_head
    while cur != None:
        
        new_head = cur
        if prev == None:
            prev = cur
            cur = cur.next
            prev.next = None

        else:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp

    ptrNewHead.append(new_head)

if __name__ == "__main__":
    head = None
    dupRevHead = [None]
    
    print("Enter a list of numbers, terminated by any non-digit character:")
    print("Enter any non-digit character to finish input:")
    try:
        while True:
            item = int(input())
            head = insertNode(head, 0, item)  
    except ValueError:
        pass

    print("\nBefore duplicateReverse() is called:")
    print("The original list:", end=" ")
    printList(head)
    
    duplicateReverse(head, dupRevHead)
    
    print("\nAfter duplicateReverse() was called:")
    print("The original list:", end=" ")
    printList(head)
    print("The duplicated reverse list:", end=" ")
    printList(dupRevHead[1])
    
    head = deleteList(head)
    dupRevHead[0] = deleteList(dupRevHead[0])