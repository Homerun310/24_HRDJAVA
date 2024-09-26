
import matplotlib.pyplot as plt
import numpy as np

(Fig, Ax) = plt.subplots(nrows=2, ncols=2)
x = np.random.rand(1000)
y = np.random.rand(1000)
Ax[0, 0].scatter(x, y)
x = np.arange(10) #x 축을 0 ~9
y = np.random.uniform(0, 10, 10)
Ax[0, 1].bar(x, y)
x = np.linspace(0, 10 ,100)
y = np.cos(x)
Ax[1, 0].plot(x, y)
y = np.eye(100)
Ax[1, 1].imshow(y)
# plt.scatter(x, y)
plt.show()
