:- op(800,fx,if).
:- op(700,xfx,then).
:- op(300,xfy,or).
:- op(200,xfy,and).
:- op(800,xfx,<=).
:- dynamic fact/1.
:- dynamic already_asked/1.

is_true(P,Proof):-
 explore(P,Proof,[]).

explore(P,P,_):-
    fact(P).                                   %P is a fact

explore(P1 and P2,Proof1 and Proof2,Trace):- !,
    explore(P1,Proof1,Trace),
    explore(P2,Proof2,Trace).

explore(P1 or P2,Proof,Trace):- !,
    (explore(P1,Proof,Trace);
    explore(P2,Proof,Trace)).

explore(P,P <= CondProof,Trace):-
    if Cond then P,                            %A rule relevant to P
    explore(Cond,CondProof,[if Cond then P|Trace]).

explore(P,Proof,Trace) :-
    askable(P),                                % P may be asked of user
    \+ fact(P),                                % P not already known fact
    \+ already_asked(P),                       % P not yet asked of user
    ask_user(P,Proof,Trace).

ask_user(P,Proof,Trace) :-
 nl, write('Is it true:'), write(P), write(?), nl,
 write('Please answer yes, no, or why'),nl,
 read(Answer),
 process_answer(Answer,P,Proof,Trace).         % Process user's answer

process_answer(yes,P,P <= was_told,_) :-       % User told P is true
 asserta(fact(P)),
 asserta(already_asked(P)).

process_answer(no,P,_,_):-
 asserta(already_asked(P)),                    % Make sure not to ask again about P
 fail.                                         % User told P is not true

process_answer(why,P,Proof,Trace) :-           % User requested why-explanation
 display_rule_chain(Trace,0), nl,
 ask_user(P,Proof,Trace).                      % Ask about P again

display_rule_chain([],_).

display_rule_chain([if C then P|Rules],Indent) :-
    nl, write('To explore whether '), write(P), write(' is true, using rule: '),
    nl, write(if C then P),
    NextIndent is Indent + 2,
    display_rule_chain( Rules, NextIndent).


/* Rule 1
 * You are healty if
 *    - you have self-isolated for 2 weeks AND
      - you had no symptoms for 2 weeks
 */

if self_isolated_2_weeks and no_symptoms_2_weeks then you_are_healthy.

/* Rule2
 * You may be infected if
      -you went to a large party AND
      -a person at the party tested positive
*/

if was_at_large_party and possitive_person_at_party then prob_infected.

/* Rule3
 * You may not be immune if
      - you are not vaccinated OR
      - you have not previously been ill with coronavirus
*/

if not_vacinated or not_previously_ill_with_covid then not_immune.

/* Rule4:
 * You should get tested if
      - Rule 2 is true AND
      - Rule 3 is true AND
      - you have symptoms.
*/

if prob_infected and not_immune and have_symptoms then get_tested.

askable(no_symptoms_2_weeks).
askable(self_isolated_2_weeks).
askable(possitive_person_at_party).
askable(was_at_large_party).
askable(not_vacinated).
askable(not_previously_ill_with_covid).
askable(have_symptoms).
