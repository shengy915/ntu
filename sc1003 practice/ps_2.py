import numpy as np
import matplotlib.pyplot as plt
import matplotlib.image as mpimg

def change_brightness(image,value):
    new_image = image.copy()
    
    for i in range(image.shape[0]):
        for j in range(image.shape[1]):
            R, G, B = new_image[i, j]
            new_image[i, j, :] = np.clip([R + value, G + value, B + value], 0, 255)

    return new_image

def change_contrast(image,value):
    r, c, rgb = image.shape
    total_pixels = r * c

    rgb_values = image.reshape(-1, rgb)

    F = (259 * (value + 255)) / (255 * (259 - value))

    RGB_values = np.zeros_like(rgb_values)

    for i in range(total_pixels):
        R, G, B = rgb_values[i]
        new_R = int(F * (R - 128) + 128)
        new_G = int(F * (G - 128) + 128)
        new_B = int(F * (B - 128) + 128)
        RGB_values[i,:] = np.clip([new_R, new_G, new_B], 0, 255)

    new_image = RGB_values.reshape(r, c, rgb)

    return new_image

def grayscale(image):
    r, c, rgb = image.shape
    
    total_pixels = r * c

    rgb_values = image.reshape(-1, rgb)

    new_image = np.zeros_like(image)

    for i in range(total_pixels):
        R, G, B = rgb_values[i]
        value = 0.3 * R + 0.59 * G + 0.11 * B
        new_image[i // c, i % c, 0] = value
        new_image[i // c, i % c, 1] = value
        new_image[i // c, i % c, 2] = value

    return new_image

def blur_effect(image):
    r, c, rgb = image.shape

    K = np.array([[0.0625,0.125,0.0625],[0.125,0.25,0.125],[0.0625,0.125,0.0625]])

    new_image = image.copy()

    for i in range(1,r-1):
        for j in range(1,c-1):
            for k in range(rgb):
                M = image[i-1:i+2, j-1:j+2]
                blur_pixel = np.sum(M[:,:,k] * K)
                new_image[i,j,k] = np.clip(blur_pixel, 0, 255)

    return new_image

def edge_detection(image):
    r, c, rgb = image.shape

    K = np.array([[-1,-1,-1],[-1,8,-1],[-1,-1,-1]])

    new_image = image.copy()

    for i in range(1,r-1):
        for j in range(1,c-1):
            for k in range(rgb):
                M = image[i-1:i+2, j-1:j+2]
                edge = np.sum(M[:,:,k] * K)
                new_image[i,j,k] = np.clip(edge+128, 0, 255)

    return new_image

def embossed(image):
    r, c, rgb = image.shape

    K = np.array([[-1,-1,0],[-1,0,1],[0,1,1]])

    new_image = image.copy()

    for i in range(1,r-1):
        for j in range(1,c-1):
            for k in range(rgb):
                M = image[i-1:i+2, j-1:j+2]
                embossed = np.sum(M[:,:,k] * K)
                new_image[i,j,k] = np.clip(embossed+128, 0, 255)

    return new_image

def rectangle_select(image, x, y):
    selected_area = 1
    unselected_area = 0

    mask = np.full(image.shape[:2], unselected_area, dtype=int)
    xx,yx = x
    xy,yy = y

    mask[yx:yy+1, xx:xy+1] = selected_area

    return mask

def colour_distance(first_pixel, second_pixel):

    delta_R = first_pixel[0] - second_pixel[0]
    delta_G = first_pixel[1] - second_pixel[1]
    delta_B = first_pixel[2] - second_pixel[2]

    r = (first_pixel[0] + second_pixel[0]) / 2

    colour_distance = np.sqrt((2+r/256)* (delta_R ** 2) + 4 * (delta_G ** 2) + (2+(255-r)/256) * (delta_B ** 2))
    return colour_distance

def magic_wand_select(image, x, thres):
    r, c, rgb = image.shape

    selected_area = 1
    unselected_area = 0

    mask = np.full(image.shape[:2], unselected_area, dtype=int)
    x1 = image[x[1], x[0]]

    stack = [x]
    while stack:
        x,y = stack.pop()

        if mask[y, x] == selected_area:
            continue

        if colour_distance(image[y,x], x1) <= thres:
            mask[y, x] = 1
            if x > 0:
                stack.append((x - 1, y))
            if x < c - 1:
                stack.append((x + 1, y))
            if y > 0:
                stack.append((x, y - 1))
            if y < r - 1:
                stack.append((x, y + 1))
    print(mask)
    return mask

def compute_edge(mask):
    rsize, csize = len(mask), len(mask[0])
    edge = np.zeros((rsize,csize))
    if np.all((mask == 1)): return edge
    for r in range(rsize):
        for c in range(csize):
            if mask[r][c]!=0:
                if r==0 or c==0 or r==len(mask)-1 or c==len(mask[0])-1:
                    edge[r][c]=1
                    continue

                is_edge = False
                for var in [(-1,0),(0,-1),(0,1),(1,0)]:
                    r_temp = r+var[0]
                    c_temp = c+var[1]
                    if 0<=r_temp<rsize and 0<=c_temp<csize:
                        if mask[r_temp][c_temp] == 0:
                            is_edge = True
                            break

                if is_edge == True:
                    edge[r][c]=1

    return edge

def save_image(filename, image):
    img = image.astype(np.uint8)
    mpimg.imsave(filename,img)

def load_image(filename):
    img = mpimg.imread(filename)
    if len(img[0][0])==4: # if png file
        img = np.delete(img, 3, 2)
    if type(img[0][0][0])==np.float32:  # if stored as float in [0,..,1] instead of integers in [0,..,255]
        img = img*255
        img = img.astype(np.uint8)
    mask = np.ones((len(img),len(img[0]))) # create a mask full of "1" of the same size of the laoded image
    img = img.astype(np.int32)
    return img, mask

def display_image(image, mask):
    # if using Spyder, please go to "Tools -> Preferences -> IPython console -> Graphics -> Graphics Backend" and select "inline"
    tmp_img = image.copy()
    edge = compute_edge(mask)
    for r in range(len(image)):
        for c in range(len(image[0])):
            if edge[r][c] == 1:
                tmp_img[r][c][0]=255
                tmp_img[r][c][1]=0
                tmp_img[r][c][2]=0

    plt.imshow(tmp_img)
    plt.axis('off')
    plt.show()
    print("Image size is",str(len(image)),"x",str(len(image[0])))

def menu():
    img = np.array([])
    mask = np.array([])
    while True:
        choice1 = input("What do you want to do?\ne - exit\nl - load a picture\n\nYour choice: ")
        if choice1 == "e":
            print("Quitting Program now...")
            break
        elif choice1 == "l":
            while True:
                file_name = input("Please enter a filename (pathname): ")
                try:
                    img, mask = load_image(file_name)
                    print("Loading image from file...")
                    if img.size > 0:
                        display_image(img, mask)
                        sub_menu(img, mask)
                    else:
                        print("Image could not be loaded. Please try loading again.")
                    break
                except FileNotFoundError:
                    print("Filename could not be found. Please re-enter another filename.")
    
        else:
            print("Please enter a choice limited to the options provided only.")


def sub_menu(image, mask):
    while True:
        choice2 = input("What do you want to do?\ne - exit\nl - load a picture\ns - save the current picture\n1 - adjust brightness\n2 - adjust contrast\n3 - apply grayscale\n4 - apply blur\n5 - edge detection\n6 - embossed\n7 - rectangle select\n8 - magic wand select\n\nYour choice: ")
        if choice2 == "e":
            print("Exiting sub_menu and returning to menu...")
            return True

        elif choice2 == "l":
            file_name = input("Please enter a filename (pathname): ")
            try:
                img, mask = load_image(file_name)
                print("Loading image from file...")
                if img.size > 0:
                    display_image(img, mask)
                else:
                    print("Image could not be loaded. Please try loading again.")
                    break
            except:
                    print("Filename could not be found. Please re-enter another filename.")

        elif choice2 == "s":
            filename = input("Please enter the filename of the file you would like to save:")
            save_image(filename, image)

        elif choice2 == "1":
            while True:
              try:
                value = int(input("Please enter a brightness value ranging from -255 to +255: "))
                if value < -255 or value > 255:
                  print("Brightness value must be between -255 and 255. Please re-enter value.")
                else:
                  break
              except ValueError:
                print("A non-integer value was entered. Please re-enter value.")
            new_image = change_brightness(image, value)
            
            image = np.where(mask[..., None] == 1, new_image, image)
            
            display_image(image, mask)
            

        elif choice2 == "2":
            while True:
              try:
                value = int(input("Please enter a contrast value ranging from -255 to +255: "))
                if value < -255 or value > 255:
                  print("Contrast value must be between -255 and 255. Please re-enter value.")
                else:
                  break
              except ValueError:
                print("A non-integer value was entered. Please re-enter value.")
            new_image = change_contrast(image, value)
            
            image = np.where(mask[..., None] == 1, new_image, image)
            
            display_image(image, mask)

        elif choice2 == "3":
            new_image = grayscale(image)
                        
            image = np.where(mask[..., None] == 1, new_image, image)
            
            display_image(image, mask)

        elif choice2 == "4":
            image = blur_effect(image)
                        
            image = np.where(mask[..., None] == 1, image, image)
            
            display_image(image, mask)

        elif choice2 == "5":
            image = edge_detection(image)
                        
            image = np.where(mask[..., None] == 1, image, image)
            
            display_image(image, mask)

        elif choice2 == "6":
            image = embossed(image)
                        
            image = np.where(mask[..., None] == 1, image, image)
        
            display_image(image, mask)

        elif choice2 == "7":
            if image.size == 0:
                print("There is no image loaded. Please try loading again.")

            while True:
                try:
                    xx = int(input("Enter x coordinate of top left pixel position x: "))
                    yx = int(input("Enter y coordinate of top left pixel position x: "))
                    xy = int(input("Enter x coordinate of bottom right pixel position y: "))
                    yy = int(input("Enter y coordinate of bottom right pixel position y: "))
                    if xx > xy:
                        xx, xy = xy, xx
                    if yx > yy:
                        yx, yy = yx, yy
                    x = (xx,yx)
                    y = (xy,yy)
                    
                    mask = rectangle_select(image,x,y)
                    break
                except ValueError:
                    print("A non-integer value was entered. Please re-enter value.")

        elif choice2 == "8":
            while True: 
                try:
                    x = int(input("Enter x coordinate: "))
                    y = int(input("Enter y coordinate: "))
                    thres = int(input("Enter threshold: "))
                    
                    if x<0 or y<0 or x>=image.shape[1] or y>=image.shape[0]:
                        print("You entered invalid coordinates. Please re-enter the coordinates.")
                        continue
                    
                    a = (x,y)
                    mask = magic_wand_select(image, a, thres)
                    break
                
                except ValueError:
                    print("A non-integer value was entered. Please re-enter value.")

        else:
            print("Please enter a choice limited to the options provided only.")

if __name__ == "__main__":
    menu()