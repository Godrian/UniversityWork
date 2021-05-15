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

travel(X,Y) :-
    byPlane(X,Y),
    write('Yes').
travel(X,Y) :-
    byTrain(X,Y),
    write('Yes').
travel(X,Y) :-
    byCar(X,Y),
    write('Yes').

travel(X,Y):-
    byPlane(X,Z),
    travel(Z,Y).
travel(X,Y) :-
    byTrain(X,Z),
    travel(Z,Y).
travel(X,Y):-
    byCar(X,Z),
    travel(Z,Y).

/* - Yes, you can get from valmont to raglan
 * - 9 first places where you cna get to from Valmont:
 *  Saarbrucken
 *  Metz
 *  Frankfurt
 *  Paris
 *  Bangkok
 *  Singapore
 *  Auckland
 *  Hamilton
 *  Raglan
 *
 *  - Problem with searching futher is that some results are the same as
 *  prvious.
 */

/*    PART II        */

travel(X,Y,[X,Y]) :-
    byCar(X,Y).
travel(X,Y,[X,Y]) :-
    byPlane(X,Y).
travel(X,Y,[X,Y]) :-
    byTrain(X,Y).

travel(X,Y,[X|L]) :-
    byCar(X,Z),
    travel(Z,Y,L).
travel(X,Y,[X|L]) :-
    byPlane(X,Z),
    travel(Z,Y,L).
travel(X,Y,[X|L]) :-
    byTrain(X,Z),
    travel(Z,Y,L).

/*
    - Yes, you can travel from Valmont to Paris through Metz
    - Routes from Valmont to Los Angeles:
        - Valmont --> Saarbruecken --> Paris --> Los Angeles
        - Valmont --> Metz --> Paris --> Los Angeles
*/

/*    PART III       */



directTrain(saarbruecken,dudweiler).
directTrain(forbach,saarbruecken).
directTrain(freyming,forbach).
directTrain(stAvold,freyming).
directTrain(fahlquemont,stAvold).
directTrain(metz,fahlquemont).
directTrain(nancy,metz).

reverseTrain(A,B) :- directTrain(B,A).

route(X,Y,[X,Y]) :-
    directTrain(X,Y).
route(X,Y,[X,Y]) :-
    reverseTrain(X,Y).
route(X,Y,[X|L]) :-
    reverseTrain(X,Z),
    route(Z,Y,L).
route(X,Y,[X|L]) :-
    directTrain(X,Z),
    route(Z,Y,L).


/*
 * - Route from Forbach to Metz :
 *    Forbach -> Freyming -> St Avold -> Fahlquemont -> Metz
 *
 * - Forbach and Dudwiler are conncted through Saarbruecken
 * - If Dudweiler is final destination or city from where travel starts,
 * all cities are connected through Saarbruecken
 * dudwiler -> forbach
 * dudwiler -> freyming
 * dudwiler -> fahlquemont
 * dudwiler -> st Avold
 * dudwiler -> metz
 * dudwiler -> nancy
 */





/*      PART IV      */

part4(D,F,B,C) :-
    X is D^F,
    write('kk'),
    \+ A is X,
    write('far'),
    C is A^B.

part42(D,F,B,C) :-
    C is A^B,
    \+ A is X,
    X is D^F.


/* Rules: Rule 1. A ^ B => C
 *        Rule 2. \+X => A
 *        Rule 3. D ^ F => X
 *
 * M0: D,F,B
 *
 * 1. Hypothesis C
 * 2. Memory check - C is not in M0.
 * 3. (Top down) Rule 1 with C.
 * 4. Conditions of rule 1, A and B as new hypothesis.
 * 5. A is not in M0. Cannot hypothesis not good.
 * 6. Find rule with A - rule 2
 * 7. Conditions of rule 2, \+ X as new hypothesis.
 * 8. Memory check, no X in memory; rule with X as a head - rule 3.
 * 9. \+X holds
 * 9. Conditions to X are D and F
 * 10. Memeory check, there are D and F
 * 11. Rule 3 is always true so, cannot proceed further as negation as
 * failure cannot be accesed when previous rule proceeds as true.
 * 12. Rule 3 is true, so I cannot go Rule 2.
 * 13. As I cannot go to rule 2, I cannot get value A
 * 14. Without variable A, I cannot get value C from rule 1.
 *

*/
