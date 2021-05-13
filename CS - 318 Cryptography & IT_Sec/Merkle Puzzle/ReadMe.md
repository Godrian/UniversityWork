# What is here ?

<ul>
  <li>CryptoLib.java</li>
  <li>Merkele.java</li>
  <li>Puzzle.java</li>
  <li>RunTests.java</li>
  <li>PuzzleCreator.java</li>
</ul>

"RunTests.java" and "CryptoLib.java" were provided by lecturer Phillip James.

This work involves programming and Merkle’s puzzles.

The work is based around the following scheme:

<i>Dear Bob,</i>

  <i>I am going to send you 4096 puzzles. Each puzzle is a cryptogram whose plaintextstarts out with128zero bits (16-bytes), followed by a16-bit (2-byte) puzzle number in the range 1 to 4096, and then a 64-bit (8-byte) key. Each cryptogram has been encrypted using DES with a different key specification whose final 48 bits are zeros.</i>
  
  <i>Please pick one cryptogram at random and break it by brute force, trying all 216 key sending in 48 zeros. You know you have broken it when you find a key that yields a plaintext starting  with 128 zero bits. After breaking the cryptogram, extract the64-bit key and use it as our shared key. As your first message send me back thepuzzle number in plaintext, so I know which key you are going to use.</i>
  
  <i>Yours sincerely, Alice</i>
  
## Puzzle

"<i>Puzzle.java</i>" is for storing a puzzle. This have the following public methods:
<ul>
  <li>A constructor that takes a puzzle number as an int and a secret key as a SecretKey object and then constructs a Puzzle object.</li>
  <li>A method <i>getPuzzleNumberthat</i> returns the puzzles number as an int.</li>
  <li>A method <i>getKey</i> that returns the puzzles key as a SecretKey.</li>
  <li>A method <i>getPuzzleAsBytes</i> that returns a byte array representing the puzzle in the above specified format.</li>
</ul>

## PuzzleCreator.java

"<i>PuzzleCreator.java</i>" contains the following public methods:
<ul>
  <li>A constructor that takes no parameters.</li>
  <li>A <i>createPuzzles</i> method that generates and returns an ArrayList〈Puzzle〉of 4096 Puzzleobjects.</li>
  <li>A <i>createRandomKey</i> method that returns a byte array that can be used to form a DESkey. This byte array should be in the above specified format (final 48 bits should be zeros).</li>
  <li>An <i>encryptPuzzle</i> method that takes a byte array representing a key and a puzzle object and encrypts the puzzles byte representation into a byte array representing the encrypted puzzle. The method should return this byte array. Note that if completed correctly the resulting byte array will be 32 bytes in length.</li>
  <li>An <i>encryptPuzzlesToFile</i> method that takes as a parameter a String representing a file-name (e.g.  “puzzles.bin”) and encrypts all 4096 puzzles and also writes them to a binary file (the byte data as it is, no spaces or new lines) with given name.</li>
  <li>A <i>findKey</i> method that take as a parameter an int representing a puzzle number andreturns the key for that puzzle as a SecretKey object.</li>
</ul>
