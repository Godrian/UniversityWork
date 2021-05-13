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

<i>Puzzle</i> class is for storing a puzzle. This have the following public methods:
<ul>
  <li>A constructor that takes a puzzle number as an int and a secret key as a SecretKey object and then constructs a Puzzle object.</li>
  <li>A method <i>getPuzzleNumberthat</i> returns the puzzles number as an int.</li>
  <li>A method <i>getKey</i> that returns the puzzles key as a SecretKey.</li>
  <li>A method <i>getPuzzleAsBytes</i> that returns a byte array representing the puzzle in the above specified format.</li>
</ul>


