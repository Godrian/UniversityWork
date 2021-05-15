## Task 1

Suppose have the following DCG:
s --> foo,bar,wiggle.
foo --> [choo].
foo --> foo,foo.
bar --> mar,zar.
mar --> me,my. 
me --> [i].
my --> [am].
zar --> blar,car.
blar --> [a].
car --> [train].
wiggle --> [toot].
wiggle --> wiggle,wiggle.

Write down the ordinary Prolog rules that correspond to these DCG rules; that is, write down the rules that use difference lists, since these correspond to DCG rules.

## Task 2

In this exercise, take a basic DCG and revise it so that it can generate a parse tree. Modify the following basic DCG:
s --> np,vp.
np --> det,n.
vp --> v,np.
det --> [the].
det --> [a].
n --> [woman].
n--> [man].
v --> [hire].

The form of the queries is:

?-s(Tree,S,[]).

Where S is the input, [] is used for the difference list, and Tree is the output parse tree.

## Task 3

Take the answer for the parse tree grammar from exercise 2 above and augment the grammar to accept the following (A)-(C).

A. Subject-verb agreement. It is common in languages that the subject and verb of the sentenceagree in number: if the subject is in a plural form, then the verb is in a plural form; if the subject is in a singular form, then the verb is in a singular form. See examples below. In the grammar above, there are singular nouns and verbs in the singular form. The task is to add plural noun forms (women, men) and a plural verb form (hire). The grammar should accept the following as grammatical:
<ul>
  <li>The women hire the man</li>
  <li>The woman hires a woman</li>
  <li>A man hires the women</li>
</ul>
But should not be accepted as grammatical, i.e., are not accepted by the parser:
<ul>
  <li>A man hire the woman</li>
  <li>The women hires the men</li>
</ul>

B. No object-verb agreement. While there is subject-verb number agreement, there is no object-verb number agreement; that is, all of the following are grammatical:
<ul>
  <li>A man hires the woman</li>
  <li>A man hires the women</li>
  <li>The men hire the woman</li>
  <li>The men hire the women</li>
</ul>

C. Determiner-common noun number agreement. In addition, note that the indefinite determiner a can only combine with singular nouns, the definite determiner the can combine with singular or plural nouns, and two can only combine with plural nouns. The following are grammatical:
<ul>
  <li>A man hires the woman</li>
  <li>The man hires the woman</li>
  <li>The men hire the woman</li>
  <li>Two women hire a man</li>
</ul>

While the following are not grammatical:
<ul>
  <li>A women hire the man</li>
  <li>A women hires the man</li>
  <li>Two man hires the man</li>
  <li>Two man hire the man</li>
</ul>
