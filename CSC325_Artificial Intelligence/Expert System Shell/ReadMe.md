See Bratko pages 353-356.
The code below is for the expert system shell. This is the shell that you need to use to write your own expert system; that is, your task will be to write the rules which use the shell. Get the shell running in Prolog and test using Bratko’s% examples. Interaction with user and why and how explanation

Operators for easy to read rules.
:-op( 800, fx, if).
:-op( 700, xfx, then).
:-op( 300, xfy, or).
:-op( 200, xfy, and).
:-op( 800, xfx, <=).
:-dynamic( fact/1).

p. 351 in Bratko book.

PROBLEM:

Write rules in Prolog for aninteractive expert which does a consultation in relation to the coronavirus. Then write queries for the rules which provide explanations. Expressed in natural language, the rules are:
<ol>
  <li>You are healthy if you have self-isolated for two weeks and you have had no symptoms for two weeks.</li>
  <li>You may be infected if you went to a large party and a person at the party tested positive.</li>
  <li>You may not be immune if you are not vaccinated or you have not previously been ill with coronavirus.</li>
  <li>You should get tested if you may be infected and youmay not be immuneand you have symptoms.</li>
<//ol>

Do the following:
<ul>
  <li>Write in Prolog the rules for the natural language expressions above so that queries for the interactive expert systemand get explanations. For example, from a sentence such as “You may be happy”, we might have the Prolog predicate may_be_happy, as the predicate applies generically.</li>
  <li>Note that you cannot use negation-as-failure, though there are several negated expressions.</li>
  <li>Write queries and report the interactions for the following, giving alternativ eresponses (yes, no, why) to the queries so that at least in one run the explanation is generatedand in the ‘why’ is provided, and in another run, the answer is 'false'.<ul>
    <li>Are you healthy?</li>
    <li>Shouldyou get tested?</li></li>
    </ul>
    </ul>
