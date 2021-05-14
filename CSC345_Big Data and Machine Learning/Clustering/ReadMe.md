This work is about utilizing unsupervised learning to cluster data from the Fisher Iris dataset. I implemented the k-means and GMM clustering algorithms on some example data by adding my own code to a Jupyter notebook.  Packages used in this lab are:<i>numpy</i>, <i>matplotlib</i>, and <i>scikit-learn</i>.

## Task 2.1 Fisher Iris Dataset
The first task is to get used to the provided dataset and explore the observed features.  Both the data and labels are contained within numpy arrays. 
<ul>
  <li>Download Irisdata.npy and Irislabels.npy, and place them in working directory.</li>
  <li>Load the data using numpy, storing them in appropriate variables.</li>
  <li>Visualise Iris data with a matplotlib scatter plot, using Irislabels to color the scatterplot.<li>
</ul>


## Task 2.2 k-Means 
The second task is to cluster our data with k-means, using unsupervised clustering to attempt to identify groupings within the data in a data-driven way.  I used all of the feature dimension swithin the Iris dataset in order to cluster the observations we have into k clusters.
<ul>
  <li>Creat a new Markdown cell explaining the code that is to follow.</li>
  <li>Initialize an  instance of  a scikit-learn KMeans class. To do so, I need to import KMeans from sklearn.cluster.</li>
  <li>•Fit the model to Irisdata.</li>
  <li>Predict the cluster membership of the samples withinIrisdata.</li>
  <li>Produce a scatter plot from the results of the prediction. My predicted cluster IDs are unsupervised, so will not necessarily map to the same IDs withinIrislabels.</li>
  <li>Add the k cluster centroids of the model to your plot.</li>
  <li>Go back and tweak my KMeans model.  Consider the API and what arguments you could use to produce a better clustering model.  Re-run your cells to see if it improves.</li>
</ul>

## Task 2.3 – Gaussian Mixture Models

The third task is to cluster my Fisher Iris data with a GMM. For this task, I implemented the GMM algorithm in notebook using theGaussianMixture class of scikit-learn, clustering data with the posterior probabilities of g Gaussian distributions.
<ul>
  <li>Create a code cell, in which initialize an instance of a scikit-learn GaussianMixture class. To do so, I need to import GaussianMixture from sklearn.mixture.</li>
  <li>Fit the model to Irisdata.</li>
  <li>Predict the cluster membership of the samples within Irisdata.</li>
  <li>Produce a scatter plot from the results of the prediction. Here predicted cluster IDs are unsupervised, so will not necessarily map to the labels within Irislabels.</li>
  <li>Add the g gaussian means of the model to your plot.</li>
  <li>Predict the posterior probability of each component (Gaussian) given the observed data within Irisdata.</li>
  <li>Produce a scatter plot for each component of the GMM model. Within each scatterplot, plot the component’s posterior probabilities as the color intensity for each sample.This should result in g different plots.</li>
  <li>Go back and tweak your GaussianMixture model. Re-run cells to see if it improves.</li>
  
Files "Iris_data.npy", "Iris_labels.npy" and "ClusteringFromScratch.ipynb" were provided by lecturer Prof. Xianghua Xie
