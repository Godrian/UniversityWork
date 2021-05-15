/**************TASK 1**************/

s(X,Y) :-s(X-Y).
s(A-D) :- foo(A-B),bar(B-C),wiggle(C-D).
foo([choo|W]-W).
foo(A-C) :- foo(A-B),foo(B-C).
bar(A-C) :- mar(A-B),zar(B-C).
mar(A-C) :- me(A-B),my(B-C).
me([i|W]-W).
my([am|W]-W).
zar(A-C) :- blar(A-B), car(B-C).
blar([a|W]-W).
car([train|W]-W).
wiggle([toot|W]-W).
wiggle(A-C) :- wiggle(A-B),wiggle(B-C).

/*****************TASK 2*************/
/*
s(s(NP,VP)) --> np(NP),vp(VP).
np(np(Det,N)) --> det(Det),n(N).
vp(vp(V,NP)) --> v(V),np(NP).
det(det(the)) --> [the].
det(det(a)) --> [a].
n(n(woman)) --> [woman].
n(n(man)) --> [man].
v(v(hires)) --> [hires].
*/

s(s(NP,VP)) --> np(NP),vp(VP).
np(np(Det,N)) --> det(Det),n(N).
vp(vp(V,NP)) --> v(V),np(NP).
det(det(Word)) --> [Word],{lex(Word,det)}.
n(n(Word)) --> [Word],{lex(Word,n)}.
v(v(Word)) --> [Word],{lex(Word,v)}.

lex(the, det).
lex(a, det).
lex(woman, n).
lex(man, n).
lex(hires,v).

/**************TASK 3****************/

s1(s(NP,VP)) --> np(NP,Num),vp(VP,Num).
np(np(Det,N),Num) --> det(Det,Num),n(N,Num).
vp(vp(V,NP),Num) --> v(V,Num),np(NP,_).
det(det(Word),Num) --> [Word],{lex(Word, det, Num)}.
n(n(Word),Num) --> [Word],{lex(Word, n, Num)}.
v(v(Word),Num) --> [Word],{lex(Word, v, Num)}.

lex(the, det, _).
lex(a, det, singular).
lex(two, det, plural).
lex(woman, n, singular).
lex(women, n, plural).
lex(man, n, singular).
lex(men, n, plural).
lex(hires, v, singular).
lex(hire, v, plural).
