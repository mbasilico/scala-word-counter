# scala-word-counter
A word counter example. Testing imperative programming vs functional programming performance.

The object LineWordCounterWorker has two methods:
1. countWordsFP: Counts the words in parameter passed filename with functional methods.
2. countWords: Counts the words in parameter passed filename in the traditional way.

In resources folder there are two files to test.

Some statistics I found:

Statistics (news2.txt , 77 KB , 612 lines)

Non FP (with countWords strategy)
decision: 117
every: 90
willpower: 90
going: 81
goals: 81
write: 72
Elapsed time: 667 ms

FP (with countWordsFP strategy)
decision: 117
every: 90
willpower: 90
going: 81
goals: 81
write: 72
Elapsed time: 359 ms

This is 85,7% better performance the Functional way!

Akka Actor System:

Next to come -> A case scenario using Akka actor system (parallel computing)
