# import package numpy
import numpy

# inisisasi array
number = numpy.arange(1, 51)

print (number)
# loop number 
for i in number:
    # cek jika number habis dibagi 3 dan 5
    if i % 3 == 0 and i % 5 == 0:
        print("FizzBuzz")
    # cek jika number habis dibagi 3
    elif i % 3 == 0:
        print("Fizz")
    # cek jika number habis dibagi 5
    elif i % 5 == 0:
        print("Buzz")
    # selain itu tampikan number
    else:
        print(i)