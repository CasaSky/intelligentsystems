#Praktikum - Intelligente Systeme

##First lab: Practicing Constraints
- What are constraints?
- For which problems are constraints useful
- How to use constraints in order to solve some problems

##Second lab: Practicing Unsupervised learning as a type of maching learning algorithms
- machine learning defines a learning process of a machine that refers to a specific sort of algorithms; Algorithms that changes itself over time as it is exposed to data.
That self-modification describes the training process.
- Unsupervised learning is an approach of machine learning where the training data set does not contain any labels.
Unsupervised learning algorithms learn how to reconstruct the input while finding structure in the data. 
For example: grouping or clustering of data points

###In the first part of this practice we are going to implement the DBSCAN Algorithm for data clustering in java
DBSCAN: Density-based spatial clustering of applications with noise: It groups points together that has many nearby neighbors(Core and Border points). Ignores all points whose nearest neighbors are too far away(low-density regions)
Clustering is a process for grouping similar objects together. It is a way of searching for similarity in the data.
It describes how an agent learns to find structure, pattern or similarity in the data in order to categorize them.
It is an approach which relates similarity with distance. Two elements in a search space are similar together when the distance between is small.

Each cluster found defines a high density region in the search space.

The algorithm input consists of three parameters.
- A set a points that has to be clustered
- Neighborhood distance
- minimum number of points required to form a dense region

###In the second part of this practice we are going to implement the autoencoder artificial neural network in python using Keras API
Autoencoders are a special type of neural network which are able to utilize techniques of supervised learning for unsupervised learning.
The nature of an autoencoder is to learn how to encode information (representation) in order to compress data, typically of dimensionality reduction or feature extraction
An autoencoder has two parts: 
- Encoding the input data for data reduction. The code describes the important features of the input data.
- Decryption of the generated code in the encoding part in order to produce the reconstruction of the data.
The main work of autoencoders is to learn how to generate from compressed data an output that closely match to the original input.


Backpropagation algorithm is the fastest way to update weights in the ANNs
It uses partial derivates of the cost function for each weight - ∂C/∂w. Where C is the cost function (to calculate the error)
For example quadratic cost function, or mean squared error function
c(w,b) = (1 / 2n) * Sigmax||y(x) - a||²
Where n is the total number of inputs, x individual input, y(x) is the disered output,
a is the vector of actual outputs from the network when x is input
After application of backpropagation
C = (1 / n) * Sigmax Cx