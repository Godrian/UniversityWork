## Part I

SCENARIO:
We are given the following knowledge base of travel information

KB:
byCar(auckland,hamilton).
byCar(hamilton,raglan).
byCar(valmont,saarbruecken).
byCar(valmont,metz).
byTrain(metz,frankfurt).
byTrain(saarbruecken,frankfurt).
byTrain(metz,paris).
byTrain(saarbruecken,paris).
byPlane(frankfurt,bangkok).
byPlane(frankfurt,singapore).
byPlane(paris,losAngeles).
byPlane(bangkok,auckland).
byPlane(losAngeles,auckland).

PROBLEM:
Write a predicate travel/2 which determines whether it is possible to travel from one place to another by ‘chaining together’ car, train, and plane journeys.For example, program answers ‘yes’ to the query travel(valmont,raglan).


## Part II
SCENARIO:
By using travel/2 from previous part to query the database, find out that it is possible to go from Valmont to Raglan. What is want is to know what is the route to get from Valmont to Raglan.

KB:
byCar(auckland,hamilton).
byCar(hamilton,raglan).
byCar(valmont,saarbruecken).
byCar(valmont,metz).
byTrain(metz,frankfurt).
byTrain(saarbruecken,frankfurt).
byTrain(metz,paris).
byTrain(saarbruecken,paris).
byPlane(frankfurt,bangkok).
byPlane(frankfurt,singapore).
byPlane(paris,losAngeles).
byPlane(bangkok,auckland).
byPlane(losAngeles,auckland).

PROBLEM:
Write a predicate travel/3 which tells how to go (the path, not the means) from one place to another.


## Part III
SCENARIO:
In the KB, there is direct trains from A to B. But, it is also reasonable to assume that one also has a direct train from B to A.

KB:
directTrain(saarbruecken,dudweiler).
directTrain(forbach,saarbruecken).
directTrain(freyming,forbach).
directTrain(stAvold,freyming).
directTrain(fahlquemont,stAvold).
directTrain(metz,fahlquemont).
directTrain(nancy,metz).

PROBLEM:
Write a predicate to represent that where there is a train connection A to B, there is also a train connection from B to A. Write a predicate route/3 which gives a list of towns that are visited by taking the train from one town to another.
