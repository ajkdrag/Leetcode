/*
  Given a number (1 to 3999), we have to output it's representation in Roman numerals.
  We simply keep a 'map' where the array value correspods to it's index. 
  eg : 3 is written as III in Roman, so we put 'III' in map[3]
  Since range is only till 3999, we have only 4 decimal places, so we store Roman representations of each decimal place only.
  For example for units place, we have (1 - 9) ==> (I, II, III ... IX)
  Note that 0 means nothing so we have append empty string for that in all places where 0 occurs.
  for 10's place, we have (10 - 90) ==> (X, XI, XII ... XC)
  Note that numbers like 12, 13 can be written as (10 + 2) , (10 + 3) the 10's place values
  can only range from (10 - 90) so 12 will be written as (10 + 2) i.e ("X" + "II") = "XII"
  for 100's place, we have (100 - 900) == (C, CC, CCC ... CM)
  for 1000's place we have (1000 - 3000) since limit is till 3999, ==> (M, MM, MMM)
  
  Now we simply convert individual digits of the num to it's corresponding Roman literal via this map.
 */

class Solution {
    public String intToRoman(int num) {
        String[] map = {"","I","II","III","IV","V","VI","VII","VIII","IX",
                             "","X","XX","XXX","XL","L","LX","LXX","LXXX","XC",
                             "","C","CC","CCC","CD","D","DC","DCC","DCCC","CM",
                             "","M","MM","MMM"};
      
        return map[num/1000 + 30] + map[(num/100)%10 + 20] + map[(num/10)%10 + 10] + map[num%10];
    }
}

