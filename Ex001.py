from cProfile import label

import matplotlib.pyplot as plt
import numpy as np

# x = [1, 2, 3, 4, 5]
# y = [1, 2, 3, 4, 5]
# plt.plot(x, y)
# plt.xlabel('x axis')
# plt.ylabel('y axis')
#
#
# x= [-5, -4, -3, -2, -1, 0, 1,2,3,4,5]
# # y= [i**2 for i in x]
# x = np.array(x)
# y = x ** 2
# plt.xlabel('X axis')
# plt.ylabel('Y axis')
# plt.plot(x,y)
# plt.axis([0, 10, 0, 30])
# plt.show()

# x = np.arange(-20, 20)
# y1 = 2 * x
# y2 = (1/3) * (x ** 2)+ 5
# y3 = -(x ** 2) - 5
# plt.plot(x, y1, 'g--')
# plt.plot(x, y2, 'r--')
# plt.plot(x, y3, 'b--')
# plt.axis([-20, 20,-30, 30])
#
# plt.show()

x = np.linspace(0, 2 * np.pi, 1000)
y1 = np.sin(x)
y2 = np.cos(x)
y3 = np.tan(x)
plt.plot(x, y1, label = 'Sin')
plt.plot(x, y2, label = 'Con')
plt.plot(x, y3, label = 'Tan')
plt.legend()
plt.axis([0, 2*np.pi, -2, 2])
plt.title('Sin-Con-Tan')

plt.savefig('Sin Cos Tan')
plt.show()