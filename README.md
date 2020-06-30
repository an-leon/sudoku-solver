# sudoku-solver
This program solves any sudoku puzzle. Most are solved within 15ms, and it takes less than 3 seconds to solve the World's Hardest Sudoku 
as defined at https://www.telegraph.co.uk/news/science/science-news/9359579/Worlds-hardest-sudoku-can-you-crack-it.html and 
https://www.telegraph.co.uk/news/science/science-news/9360022/Worlds-hardest-sudoku-the-answer.html.

This project is an excellent demonstration of the author's skills in Python and object-oriented programming. Next steps
involve reducing code complexity and resource requirements, and building a UI.

The program primarily solves puzzles by processes of elimination. The author groups the solving methods in 4 ways: the 
easy-level algorithms, which eliminate possible numbers from rows, columns, and 'sectors' (blocks of 9) based off perfectly 
defined spaces; the intermediates, which eliminate numbers in 2-dimensional ways; the hards, which eliminate numbers in rows
and columns based off imperfectly defined spaces; and finally the expert method, which uses all the previous methods to 
eliminate possibilities and then uses systematic guesswork to determine the answer from the remaining possibilities.

Instructions: The program gives the option to input puzzles automatically (easy) or manually (tedious). The automatic 
method inputs from text files, and a few such files are given as reference. Testing different files can be done by changing
the file name in line 7 of FROptimal.java.
