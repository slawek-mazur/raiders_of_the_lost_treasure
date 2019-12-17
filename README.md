## Treasure Hunt
```
+------------------------+
¦ 34 ¦ 21 ¦ 32 ¦ 41 ¦ 25 ¦
+----+----+----+----+----¦
¦ 14 ¦ 42 ¦ 43 ¦ 14 ¦ 31 ¦
+----+----+----+----+----¦
¦ 54 ¦ 45 ¦ 52 ¦ 42 ¦ 23 ¦
+----+----+----+----+----¦
¦ 33 ¦ 15 ¦ 51 ¦ 31 ¦ 35 ¦
+----+----+----+----+----¦
¦ 21 ¦ 52 ¦ 33 ¦ 13 ¦ 23 ¦
+------------------------+
```
Program to explore the above table for a treasure. 
The values in the table are clues. Each cell contains a number between `11` and `55`, 
where the ten’s digit represents the row number and the unit’s digit represents the column number 
of the cell containing the next clue.

Starting with the upper left corner (at `1,1`), use the 
clues to guide your search through the table - (the first three clues are `11`, `55`, `15`). 
The treasure is a cell whose value is the same as its coordinates.
 
Program must first read in the treasure map data into a 5 by 5 array.