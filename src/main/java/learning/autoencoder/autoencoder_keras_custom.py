from tensorflow.keras.layers import Dense, Input # Type of layers
from tensorflow.keras.models import Model # Represents the array of keras layers

class Autoencoder(object):
    
    def __init__(self, inout_dim, encoded_dim): 
        print("\nInOutDim: %.2f%%" % (inout_dim))
        print("\nEncodedDim: %.2f%%" % (encoded_dim))
        input_layer = Input(shape=(inout_dim,)) # Set input vector on the input layer
        hidden_layer = Dense(encoded_dim, activation='relu')(input_layer) # Add two layers: input layer and hidden layer
        output_layer = Dense(784, activation='sigmoid')(hidden_layer) # Add two layers: a hidden layer as input layer and an output layer with 784 neurons
        
        self._autoencoder_model = Model(input_layer, output_layer) # Set the autoencoder network 
        
        # Configures the main network for training
        self._autoencoder_model.compile(optimizer='adam', loss='binary_crossentropy')
        
    # train the network for a given number of iterations on the dataset
    # encode, reconstruct, calculate error, backpropagate the error -> Minimize reconstruction error overal several epochs
    # Params
    # input_train: Numpy array of training data 
    # input_train: Numpy array of target (label) data: same as first param because we are using unsupervised learning
    # epochs: Number of iterations to train the network - One epoch is an iteration over the entire x, y data provided
    # batch_size: Number of samples per gradient update
    def train(self, input_train, batch_size, epochs):
        self._autoencoder_model.fit(input_train, 
                                    input_train,
                                    epochs = epochs,
                                    batch_size=batch_size)
     
    # Generates output predictions for the input samples.
    # image: The input data, as Numpy array
    # batch_size: default is 32
    # return numpy array of predictions
    def getReconstruction(self, image):
        reconstruced_image = self._autoencoder_model.predict(image)
        return reconstruced_image