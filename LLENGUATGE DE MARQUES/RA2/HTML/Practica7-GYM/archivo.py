import math

peso = float(input("Introduce tu peso: "))
estatura = float(input("Introduce tu estatura (cm): "))

imc = round(peso / (estatura / 100) ** 2, 2)

print("Tu índice de masa corporal es", imc)