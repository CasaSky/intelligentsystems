#Praktikum - Intelligente Systeme

##First lab: Practicing Constraints as a type of searching algorithms
- What are constraints?
- For which problems are constraints useful
- How to use constraints in order to solve some problems
- Describing some search algorithms that play an important role in constraints : Backpropagation 

##Second lab: Practicing Unsupervised learning as a type of maching learning algorithms
- machine learning defines a learning process of a machine that refers to a specific sort of algorithms; Algorithms that changes itself over time as it is exposed to data.
That self-modification describes the training process.
- Unsupervised learning is an approach of machine learning where the training data set does not contain any labels.
Unsupervised learning algorithms learn how to reconstruct the input while finding structure in the data. 
For example: grouping or clustering of data points

###Implementing the DBSCAN Algorithm for data clustering in java
DBSCAN: Density-based spatial clustering of applications with noise: It groups points together that has many nearby neighbors(Core and Border points). Ignores all points whose nearest neighbors are too far away(low-density regions)
Clustering is a process for grouping similar objects together. It is a way of searching for similarity in the data.
It describes how an agent learns to find structure, pattern or similarity in the data in order to categorize them.
It is an approach which relates similarity with distance. Two elements in a search space are similar together when the distance between them is small.

Each cluster found defines a high density region in the search space.

The algorithm input consists of three parameters.
- A set of points that has to be clustered
- Neighborhood distance
- minimum number of points required to form a dense region

##Third lab: Practicing Text Mining [Text Clustering] in order to turn text into data for analysis via application of Natural Language Processing
- What is text mining? What is natural language processing?
- What is Text Clustering? How Text Clustering works? 
- Describing and using the most common natural language processing tasks in order to prepare data before aplying a clustering algorithm
- Tokenizer - Stemmer - Tf-idf
- Text representation:
    1. Preparing documents: 
        How many words are used? Splitting document in words -> Tokenizing
        Normalizing: Basic shape -> Lemmatizing or Stamm -> Stemming
    2. Feature Vector:
        Features/Term are vectors
        Dimension is the number of terms
        Each vector describes a point in dimension space
        Similarity of documents are found with the distance or destination or measure of importance of the points 
