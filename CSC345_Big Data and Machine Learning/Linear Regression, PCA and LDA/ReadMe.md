This work is about utilizing Linear Regression for continuous value prediction. It also looks at Principal Component Analysis and Linear Discriminant Analysis for feature dimension reduction. Here is implementation of these algorithms on some example training data, before then carrying out the methods on a testing dataset. The packages to use in this lab sheet are <i>numpy</i>,<i>matplotlib</i> and <i>scikit-learn</i>.

## Task 3.1 – Linear Regression with sklearn

This first task involves using Linear Regression to fit a predictive regression model to a collectionof observed datapoints.  To do this you will need to utilise <b>LinearRegression</b> class from within <i>sklearn.linear</i> model. There is the data in the form of two numpy arrays, <i>xvalues.npy</i> and <i>yvalues.npy</i>. 
<i>xvalues.npy</i> corresponds to the regular variable, the magnitude along the x-axis. </i>yvalues.npy</i> corresponds to the target variable.  In <b>Linear Regression</b> model I intend to provide <i>xvalues.npy</i> and <i>yvalues.npy</i> to train my model. Then, given a previously unseen value of x, I want to predict a corresponding yvalue. To achieve this goal I first loaded in data and visualise <b>x values</b> against <b>y values</b>.  I initialised a LinearRegression object and train the model on the observed data. As Linear Regression is a supervised approach I must provide targets, therefore when calling <i>yourfit()</i> function you need to pass both the data (x) and the targets (y).  We will then predict anoutput <b>yvalue</b> for an unseen value of x.
<ul>
  <li>Load <i>xvalues.npy</i> and <i>yvalues.npy</i>, and visualise the data with a scatter plot.</li>
  <li>Create a LinearRegression object from sklearn.</li>
  <li>Fit the LinearRegression object to the data, given the targets.</li>
  <li>Load test <i>xvalues.npy</i> and predict the <b>y values</b> for each of the <b>x values</b> within test <i>xvalues.npy</i>. </li>
  <li>Plot the training data x and y values using a scatter plot.  On the same figure, plot the test x and predicted ˆy values using matplotlib’s plot method. Label the axes appropriately.</li>
</ul>


## Task 3.2 – Principle Component Analysis with sklearn
The second task is to use Principal Component Analysis to reduce the dimensionality of the Wine Dataset. Overall, what was done is: divide the dataset into a training and  testing set, utilise a <b>sklearn.decomposition.PCA</b> object to reduce the dimensionality to two principle components,and then visualise the data in the new principle component space. 
<ul>
  <li>Load <i>wineData.npy</i> and <i>wineLabels.npy</i>, inspect the data, and visualise it.</li>
  <li>Divide the data and labels into two sets: training and testing. Use slicing here to select some proportion of the data and assign them into two separate variables <i>train_data</i> and <i>test_data</i>. Use the same indices to slice your labels and create train labels test labels, make sure that the data and labels still match.  A common split in literatureis 80% training to 20% testing.</li>
  <li>Produce a scatter plot which shows your train: test split. Remember to colour them based on their respective labels. Plot feature 0 against feature 1.</li>
  <li>Initialise a <b>PCAobject</b>, with an input argument to the constructor which will only keep the first 2 principle components.  This will reduce dimensionality from 13 features, to 2.</li>
  <li>Fit the <b>PCAmodel</b> to the training data.</li>
  <li>Apply the dimensionality reduction transform to the training data.  This takes in my 13-dimensional data and reduces it down to 2 dimensions.</li>
  <li>Apply the dimensionality reduction transform to the testing data.</li>
  <li>Visualise the reduced-dimensionality training and testing data, using a scatter plot.  Don’t forget to use different markers for the two sets, and to colour the markers with the labels.</li>
</ul>


## Task 3.3 – Linear Discriminant Analysis with sklearn
The third task is to use Linear Discriminant Analysis to reduce the dimensionality of the WineDataset. This time we will be using a supervised technique to reduce dimensionality. In this task I used the same train: test split I have identified in task 3.2. LDA can also be used for class prediction, and has apredict method, but I used it for dimensionality reduction in this task by calling the transform method.
<ul>
  <li>Create a <i>sklearn.discriminantanalysis.LinearDiscriminantAnalysis</i> object. Again provide an argument to the constructor which will only keep the first 2 components.</li>
  <li>Fit the model to the training data and training labels.  Notice that unlike with PCA, there is need to provide the class labels for our training data.</li>
  <li>Apply the dimensionality reduction transform to the training data.</li>
  <li>Apply the dimensionality reduction transform to the testing data.</li>
  <li>Visualise the reduced-dimensionality training and testing data, using a scatter plot.  Don’t forget to use different markers for the two sets, and to colour the markers based on the labels.
</ul>

## Task 3.4 – Principal Component Analysis by hand

The fourth task is to implement Principal Component Analysis by hand. I performed the Singular Value Decomposition and project the data into the new principal component space,before visualising the data in the reduced dimensionality space. In this task I used the same train: test split you have identified in task 3.2.
<ul>
  <li>Mean-centre the training data. To do this, you should identify the mean vector of the training data, and subtract that vector from the samples in the training data. Save this mean vector, it will be needed later for centring the test data.</li>
  <li>Calculate the Singular Value Decomposition of the mean-centred training data. This can be donr with <i>numpy.linalg.svd()</i>, which returns the variables <b>u,s</b> and <b>vh</b>.</li>
  <li>Project your data into a 2-dimensional Principle Component space.</li>
  <li>Visualise your projected training and testing data with a scatter plot.</li>
</ul>



Files "x_values.npy", "y_values.npy", "test_x_values.npy", "wineData.npy", "wineLabels.npy" and "LinearRegressionAndLDAFromScratch.ipynb"  were provided by Prof. Xianghua Xie
