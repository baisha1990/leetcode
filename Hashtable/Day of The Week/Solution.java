/*Given a date, return the corresponding day of the week for that date.

The input is given as three integers representing the day, month and year respectively.

Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.

 

Example 1:

Input: day = 31, month = 8, year = 2019
Output: "Saturday"
Example 2:

Input: day = 18, month = 7, year = 1999
Output: "Sunday"
Example 3:

Input: day = 15, month = 8, year = 1993
Output: "Sunday"
 

Constraints:

The given dates are valid dates between the years 1971 and 2100.*/

class Solution {
    int flag = 0;
    public String dayOfTheWeek(int day, int month, int year) {
        Map<Integer, String> map = new HashMap<>();
		map.put(1, "Monday");
		map.put(2, "Tuesday");
		map.put(3, "Wednesday");
		map.put(4, "Thursday");
		map.put(5, "Friday");
		map.put(6, "Saturday");
		map.put(0, "Sunday");
		      
        int f = (13*findMonth(month) - 1)/5;
        int y = (flag == 0) ? year : year - 1;
        int s = y % 100;
        int t = y / 100;
        int F = day + f + s + s/4 + t/4 - 2*t;
        int temp = F%7;
		return map.get((temp+7)%7);		
    }
	
	public int findMonth(int month) {
		if((month%12) - 2 > 0)
            return (month%12) - 2;
		else if((month%12) == 0)
			return (month%12) + 10;
        else {
            flag = 1;
            return (month%12) + 10;
        }
	}
}