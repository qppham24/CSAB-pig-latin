# CSAB-pig-latin
Basic Rules

Pig Latin is a pretend language. The basic rule is simple: move the leading consonants to the end of the word and append "ay".

pig -> igpay

latin -> atinlay

this -> isthay

strange -> angestray

bcdfgh ->  **** INVALID ``****

If the first letter is a vowel then just append "way". 

apple -> appleway

eye -> eyeway

Write a program that translates words from English to Pig Latin.  Prompt for an English word and output the translation in Pig Latin.   

If the word has no vowel, print "**** INVALID ****".  Repeat this sequence until the user wants to quit. 

Special Cases

If the first vowel is a "u" and the letter before it is a "q" then the "u" also goes to the end of the word. 

question -> estionquay

squeeze -> eezesquay

 Treat "y" as a consonant if it's the first letter of a word; otherwise, treat "y" as a vowel if it appears earlier than any other vowel.

yes -> esyay

rhyme -> ymerhay

try -> ytray

Modify your program to handle these special cases.

 

Capitalization and Punctuation

If the first letter is capitalized in English then the first letter should be capitalized in Pig Latin also. Capital letters in the middle of the word are ignored and remain capitalized.

Thomas -> Omasthay

Jefferson -> Effersonjay

McDonald -> OnaldmcDay

McArthur  -> Arthurmcay

hasCapital -> asCapitalhay

HELLO -> ELLOhay

If before-and-after punctuation is used in English then it should remain in Pig Latin.  Apostrophes are ignored and remain where they are.

What? -> Atwhay?

Oh! -> Ohway!

"hello" -> "ellohay"

"Hello!!!!" -> "Ellohay!!!!"

don’t -> on’tday

