The first two tasks look to classify a given sample into one of three different classes. The data includes a 13-dimensional multivariate chemical analysis of the wine, including things like the acidity and alcohol content. The labels are a numerical ID of whichcultivar created the wine (0, 1, 2). The following two tasks will utilise this 13-dimensional spaceto train models which predict the label.

## Task 4.1 – Multiclass SVM for Wine Data
This first task involves using a Support Vector Machine to predict classes labels on the Winedataset. Task here is to create, train and predict using an instance of the <i>sklearn.svm.SVC</i> object. Sklearn has many Support Vector Machine algorithms implemented, however I am interested in the classification task here, so I used the <i>SVC</i> object. 
<ul>
  <li>Load the full Wine dataset and divide it into a training and testing set.</li>
  <li>Use the <b>sklearn.preprocessing.StandardScaler</b> class to standardise the data.  First, fit the StandardScaler to the training data, and then apply to both the training and testing data using the <i>transform()</i> method.</li>
  <li>Create and train a multiclass SVM on the training set by creating an instance of the <i>sklearn.svm.SVC</i> class and the calling its <i>fit()</i> method.</li>
  <li>Predict labels for the testing set and report the accuracy of your model. To do this, you can use the model’s <i>score()</i> method, passing in the testing data and labels.</li>
  <li>Visualise the test data using a scatter plot.</li>
</ul>


## Task 4.2 – Neural Network for Wine Data
This task looks to apply the <b>Tensorflow</b> framework, and more specifically the <b>Keras</b> submodule to create a deep learning model, showing how layers can be connected to create the model.
<ul>
  <li>Use the same standardised training and testing set from Task 4.1</li>
  <li>Create and train a Tensorflow Fully Connected Neural Network on the training set.</li>
  <li>Predict labels for the testing set and report the accuracy of your model on the testing set.</li>
  <li>Visualise the test data using a scatter plot.</li>
</ul>

## Task 4.3 – Neural Network for Digit Recognition
<ul>
  <li>Load in the MNIST dataset.</li>
  <li>To use a fully connected neural network, there is need to first flatten the data so that is able to be passed into a Dense network.  To do this, use <i>np.reshape()</i> to reshape the training data into 60000-by-784, and the testing data into 10000-by-784.</li>
  <li>Normalise our data by dividing it by 255 (the maximum value in the original data).</li>
  <li>Create and train a <b>Tensorflow Fully Connected Neural Network</b> on the training set.</li>
  <li>Predict labels for the testing set and report the accuracy of your model on the testing set.</li>
  <li>•Plot your model’s training curves.</li>
</ul>


## Task 4.4 – Convolutional Neural Network for Digit Recognition
<ul>
  <li>Use the MNIST data as loaded before, with its original shape of <b>S-H-W</b>.</li>
  <li>To use a convolutional neural network, first expand the data so that it also has a channel dimension. As data is grayscale, I only need to add an additional axis in the last dimension of my data. To do this, use <i>np.expanddims()</i> to make training data 60000-28-28-1, and the testing data 10000-28-28-1.</li>
  <li>Normalise our data by dividing it by 255.</li>
  <li>Create and train a Tensorflow Convolutional Neural Network on the training set.</li>
  <li>Predict labels for the testing set and report the accuracy of your model on the testing set.</li>
  <li>Plot  model’s training curves.</li>
</ul>

Files "wineData.npy", "wineLabels.npy", "Sequential_Demo.ipynb" was provided by lecturer Prof. Xianghua Xie
