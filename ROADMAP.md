# Roadmap

127 sessions, zero to interview-ready, in Java. One session is about 45 minutes and covers one idea.
There are no dates. You are never "behind". You are only ever on the next session.

Every session follows the same shape:

1. **Recall** (2 min): answer one question from last session without looking.
2. **Learn** (10–15 min): open the session's lesson page and play with the visual.
3. **Do** (20–30 min): make the failing tests in `src/test/java/...` pass.
4. **Lock in** (3 min): write 3 lines in `notes/`, tick the session off in the tracker.

A **checkpoint** ends each phase: a mixed problem set plus a deep dive into whatever piled up in `PARKING_LOT.md`.

## Phase 0 · Java Ground (s01–s08)
You know JS. This phase maps what you know onto Java and builds the mental model every data structure sits on.

- s01 Hello Java: TS → Java with Two Sum
- s02 Types: primitives, overflow, String, `==` vs `.equals`
- s03 Memory model: stack, heap, references (the arrow model)
- s04 Classes & objects: fields, constructors, `static`
- s05 Collections tour: ArrayList, HashMap, HashSet
- s06 Generics, interfaces, Comparable & Comparator
- s07 Exceptions, null, and writing your own tests
- s08 Recursion I: watch the call stack

## Phase 1 · Math & Complexity (s09–s14)
The only maths you need, taught when you need it.

- s09 Big-O: counting steps
- s10 Logarithms: the halving superpower
- s11 Sums & series: why nested loops are n²
- s12 Space complexity & amortized cost (ArrayList growth)
- s13 Number basics: modulo, digits, GCD, primes
- s14 Binary & bitwise operators

## Phase 2 · Arrays, Strings, Sorting, Searching (s15–s31)
- s15 Arrays in memory: in-place reverse & rotate
- s16 How HashMap really works: hashing & buckets
- s17 Frequency counting: anagrams, majority element
- s18 Two pointers I: from both ends
- s19 Two pointers II: slow & fast writer
- s20 Sliding window I: fixed size
- s21 Sliding window II: grow & shrink
- s22 Prefix sums: range sums, subarray sum = k
- s23 Strings: StringBuilder, char math, palindromes
- s24 Matrices: 2D traversal, spiral, rotate
- s25 Sorting I: bubble, selection, insertion
- s26 Sorting II: merge sort (divide & conquer)
- s27 Sorting III: quicksort & partitioning
- s28 Binary search I: the classic
- s29 Binary search II: first/last position boundaries
- s30 Binary search III: search on the answer
- s31 Checkpoint

## Phase 3 · Linked Lists, Stacks, Queues (s32–s42)
- s32 Build a singly linked list (port your TS one)
- s33 Reverse a linked list, iterative & recursive
- s34 Fast & slow pointers: middle, cycle detection
- s35 Merging lists & the dummy-node trick
- s36 Doubly linked list → LRU cache
- s37 Stacks: build one, valid parentheses
- s38 Stack design: min stack, evaluate RPN
- s39 Monotonic stack: next greater element
- s40 Queues & deques: ArrayDeque, circular buffer
- s41 Monotonic deque: sliding window maximum
- s42 Checkpoint

## Phase 4 · Recursion & Backtracking (s43–s50)
- s43 Recursion II: trust the subproblem (induction)
- s44 Counting math: permutations, combinations, 2ⁿ
- s45 Subsets
- s46 Permutations
- s47 Combination sum
- s48 Grid backtracking: word search, N-Queens
- s49 Memoization: the bridge to DP
- s50 Checkpoint

## Phase 5 · Trees & Heaps (s51–s66)
- s51 Tree vocabulary: build a binary tree
- s52 DFS traversals: pre, in, post order
- s53 Iterative traversals with a stack
- s54 BFS: level order with a queue
- s55 Tree recursion: height, diameter, balanced
- s56 Path problems: path sum, max path sum
- s57 Binary search trees: insert, search, validate
- s58 BST II: delete, kth smallest, lowest common ancestor
- s59 Build & serialize trees
- s60 Heaps: a tree hiding in an array
- s61 PriorityQueue: top-k problems
- s62 Two heaps: running median
- s63 Merge k sorted lists
- s64 Tries: prefix trees
- s65 Balanced trees & TreeMap
- s66 Checkpoint

## Phase 6 · Graphs (s67–s82)
- s67 Graph vocabulary & adjacency lists
- s68 DFS on graphs
- s69 BFS & shortest path (unweighted)
- s70 Grids as graphs: islands, flood fill
- s71 Multi-source BFS: rotting oranges
- s72 Cycle detection
- s73 Topological sort: course schedule
- s74 Union-Find (disjoint sets)
- s75 Dijkstra's shortest path
- s76 Bellman-Ford & negative edges
- s77 Minimum spanning trees: Kruskal & Prim
- s78 Bipartite graphs & coloring
- s79 Floyd-Warshall: all-pairs shortest path
- s80 Bridges & articulation points (Tarjan)
- s81 Strongly connected components
- s82 Checkpoint

## Phase 7 · Dynamic Programming (s83–s99)
- s83 DP mindset: state, transition, base case
- s84 1D DP: climbing stairs, house robber
- s85 1D DP: coin change, decode ways
- s86 Longest increasing subsequence
- s87 Grid DP: unique paths, min path sum
- s88 String DP: LCS & edit distance
- s89 0/1 knapsack
- s90 Unbounded knapsack
- s91 Palindrome DP
- s92 Interval DP: burst balloons
- s93 DP on trees
- s94 State-machine DP: stock problems
- s95 Bitmask DP
- s96 Word break & pattern matching
- s97 Shrinking DP tables (space optimization)
- s98 Digit DP
- s99 Checkpoint

## Phase 8 · Greedy & Intervals (s100–s105)
- s100 Greedy & how to prove it (exchange argument)
- s101 Intervals: merge, insert, non-overlapping
- s102 Sweep line: meeting rooms
- s103 Jump game & gas station
- s104 Scheduling: task scheduler, Huffman coding
- s105 Checkpoint

## Phase 9 · Advanced Toolkit (s106–s117)
- s106 Bit tricks: single number, counting bits
- s107 Fast power & modular arithmetic
- s108 Randomized: shuffle, reservoir sampling
- s109 String hashing: Rabin-Karp
- s110 Pattern matching: KMP
- s111 Segment tree I: range queries
- s112 Segment tree II: lazy propagation
- s113 Fenwick tree (Binary Indexed Tree)
- s114 Ordered sets: TreeMap/TreeSet patterns
- s115 Design problems: LFU cache, rate limiter
- s116 Computational geometry basics
- s117 Checkpoint

## Phase 10 · Interview Mode (s118–s127)
- s118 The interview framework: clarify, plan, code, test
- s119–s126 Timed mixed sets 1–8
- s127 Final boss: full mock interview

## Later · Track 2: System Design
Unlocks after Phase 3. Networking and HTTP, databases and indexes, caching, queues, scaling, and designing real systems end to end. Planned separately once the DSA habit is solid.
