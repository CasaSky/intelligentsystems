import numpy as np
from tensorflow.keras.datasets import fashion_mnist
from autoencoder_keras_custom import Autoencoder
import matplotlib.pyplot as plt

# Import data
(x_train, _), (x_test, _) = fashion_mnist.load_data()

# Prepare input
x_train = x_train.astype('float32') / 255.
x_test = x_test.astype('float32') / 255.
x_train = x_train.reshape((len(x_train), np.prod(x_train.shape[1:])))
x_test = x_test.reshape((len(x_test), np.prod(x_test.shape[1:])))

# Keras implementation
autoencoder = Autoencoder(x_train.shape[1], 32)
autoencoder.train(x_train, 256, 50) # train the autoencoder with the training data
reconstructed_imgs = autoencoder.getReconstruction(x_test) # generate output prediction of new data after encoding and decoding - compression and reconstruction
# The result is the ability of data reconstruction that the network learned after training it 

# Keras implementation results
plt.figure(figsize=(20, 4))
for i in range(10):
    # Original
    subplot = plt.subplot(2, 10, i + 1)
    plt.imshow(x_test[i].reshape(28, 28))
    plt.gray()
    subplot.get_xaxis().set_visible(False)
    subplot.get_yaxis().set_visible(False)

    # Reconstruction
    subplot = plt.subplot(2, 10, i + 11)
    plt.imshow(reconstructed_imgs[i].reshape(28, 28))
    plt.gray()
    subplot.get_xaxis().set_visible(False)
    subplot.get_yaxis().set_visible(False)
plt.show()

