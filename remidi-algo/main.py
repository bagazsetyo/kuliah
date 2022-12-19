# nomer 2
limit = 10
i = 1
while True:
    bilangan = int(input("Masukkan bilangan ke %d: " % i))
    print ("Bilangan yang anda masukkan adalah : ", bilangan)
    
    i += 1
    if i > limit:
        break

# nomer 3
bilangan = []
limit_bilangan = 3
i = 1

while True:
    bilangan.append(int(input("Masukkan bilangan ke %d: " % i)))
    print ("Bilangan yang anda masukkan adalah : ", bilangan)
    
    i += 1
    if i > limit_bilangan:
        break

print("Bilangan paling kecil adalah : ", min(bilangan))

# nomer 4
dari = -15
ke = 15

while dari <= ke:
    print(dari)
    dari += 1