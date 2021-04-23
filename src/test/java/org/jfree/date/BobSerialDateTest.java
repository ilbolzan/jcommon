package org.jfree.date;

import junit.framework.TestCase;
import org.jfree.date.*;

import static org.jfree.date.SerialDate.*;

import java.util.*;

public class BobsSerialDateTest extends TestCase {

    public void testIsValidWeekdayCode() throws Exception {
        for (int day = 1; day <= 7; day++)
            assertTrue(isValidWeekdayCode(day));
        assertFalse(isValidWeekdayCode(0));
        assertFalse(isValidWeekdayCode(8));
    }

    public void testStringToWeekdayCode() throws Exception {

        assertEquals(-1, stringToWeekdayCode("Hello"));
        assertEquals(MONDAY, stringToWeekdayCode("Monday"));
        assertEquals(MONDAY, stringToWeekdayCode("Mon"));
        //todo assertEquals(MONDAY,stringToWeekdayCode("monday"));
        //  assertEquals(MONDAY,stringToWeekdayCode("MONDAY"));
        //  assertEquals(MONDAY, stringToWeekdayCode("mon"));

        assertEquals(TUESDAY, stringToWeekdayCode("Tuesday"));
        assertEquals(TUESDAY, stringToWeekdayCode("Tue"));
        //  assertEquals(TUESDAY,stringToWeekdayCode("tuesday"));
        //  assertEquals(TUESDAY,stringToWeekdayCode("TUESDAY"));
        //   assertEquals(TUESDAY, stringToWeekdayCode("tue"));
        //  assertEquals(TUESDAY, stringToWeekdayCode("tues"));

        assertEquals(WEDNESDAY, stringToWeekdayCode("Wednesday"));
        assertEquals(WEDNESDAY, stringToWeekdayCode("Wed"));
        //  assertEquals(WEDNESDAY,stringToWeekdayCode("wednesday"));
        //  assertEquals(WEDNESDAY,stringToWeekdayCode("WEDNESDAY"));
        //  assertEquals(WEDNESDAY, stringToWeekdayCode("wed"));

        assertEquals(THURSDAY, stringToWeekdayCode("Thursday"));
        assertEquals(THURSDAY, stringToWeekdayCode("Thu"));
        //  assertEquals(THURSDAY,stringToWeekdayCode("thursday"));
        //  assertEquals(THURSDAY,stringToWeekdayCode("THURSDAY"));
        //  assertEquals(THURSDAY, stringToWeekdayCode("thu"));
        //  assertEquals(THURSDAY, stringToWeekdayCode("thurs"));

        assertEquals(FRIDAY, stringToWeekdayCode("Friday"));
        assertEquals(FRIDAY, stringToWeekdayCode("Fri"));
        // assertEquals(FRIDAY,stringToWeekdayCode("friday"));
        // assertEquals(FRIDAY,stringToWeekdayCode("FRIDAY"));
        // assertEquals(FRIDAY, stringToWeekdayCode("fri"));

        assertEquals(SATURDAY, stringToWeekdayCode("Saturday"));
        assertEquals(SATURDAY, stringToWeekdayCode("Sat"));
        // assertEquals(SATURDAY,stringToWeekdayCode("saturday"));
        // assertEquals(SATURDAY,stringToweekdayCode("SATURDAY"));
        // assertEquals(SATURDAY, stringToWeekdayCode("sat"));

        assertEquals(SUNDAY, stringToWeekdayCode("Sunday"));
        assertEquals(SUNDAY, stringToWeekdayCode("Sun"));
        // assertEquals(SUNDAY,stringToWeekdayCode("sunday"));
        // assertEquals(SUNDAY,stringToWeekdayCode("SUNDAY"));
        // assertEquals(SUNDAY, stringToWeekdayCode("sun"));
    }

    public void testWeekdayCodeToString() throws Exception {
        assertEquals("Sunday", weekdayCodeToString(SUNDAY));
        assertEquals("Monday", weekdayCodeToString(MONDAY));
        assertEquals("Tuesday", weekdayCodeToString(TUESDAY));
        assertEquals("Wednesday", weekdayCodeToString(WEDNESDAY));
        assertEquals("Thursday", weekdayCodeToString(THURSDAY));
        assertEquals("Friday", weekdayCodeToString(FRIDAY));
        assertEquals("Saturday", weekdayCodeToString(SATURDAY));
    }

    public void testIsValidMonthCode() throws Exception {
        for (int i = 1; i <= 12; i++)
            assertTrue(isValidMonthCode(i));
        assertFalse(isValidMonthCode(0));
        assertFalse(isValidMonthCode(13));
    }

    public void testMonthToQuarter() throws Exception {
        assertEquals(1, monthCodeToQuarter(JANUARY));
        assertEquals(1, monthCodeToQuarter(FEBRUARY));
        assertEquals(1, monthCodeToQuarter(MARCH));
        assertEquals(2, monthCodeToQuarter(APRIL));
        assertEquals(2, monthCodeToQuarter(MAY));
        assertEquals(2, monthCodeToQuarter(JUNE));
        assertEquals(3, monthCodeToQuarter(JULY));
        assertEquals(3, monthCodeToQuarter(AUGUST));
        assertEquals(3, monthCodeToQuarter(SEPTEMBER));
        assertEquals(4, monthCodeToQuarter(OCTOBER));
        assertEquals(4, monthCodeToQuarter(NOVEMBER));
        assertEquals(4, monthCodeToQuarter(DECEMBER));

        try {
            monthCodeToQuarter(-1);
            fail("Invalid Month Code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }


    public void testMonthCodeToString() throws Exception {
        assertEquals("January", monthCodeToString(JANUARY));
        assertEquals("February", monthCodeToString(FEBRUARY));
        assertEquals("March", monthCodeToString(MARCH));
        assertEquals("April", monthCodeToString(APRIL));
        assertEquals("May", monthCodeToString(MAY));
        assertEquals("June", monthCodeToString(JUNE));
        assertEquals("July", monthCodeToString(JULY));
        assertEquals("August", monthCodeToString(AUGUST));
        assertEquals("September", monthCodeToString(SEPTEMBER));
        assertEquals("October", monthCodeToString(OCTOBER));
        assertEquals("November", monthCodeToString(NOVEMBER));
        assertEquals("December", monthCodeToString(DECEMBER));

        assertEquals("Jan", monthCodeToString(JANUARY, true));
        assertEquals("Feb", monthCodeToString(FEBRUARY, true));
        assertEquals("Mar", monthCodeToString(MARCH, true));
        assertEquals("Apr", monthCodeToString(APRIL, true));
        assertEquals("May", monthCodeToString(MAY, true));
        assertEquals("Jun", monthCodeToString(JUNE, true));
        assertEquals("Jul", monthCodeToString(JULY, true));
        assertEquals("Aug", monthCodeToString(AUGUST, true));
        assertEquals("Sep", monthCodeToString(SEPTEMBER, true));
        assertEquals("Oct", monthCodeToString(OCTOBER, true));
        assertEquals("Nov", monthCodeToString(NOVEMBER, true));
        assertEquals("Dec", monthCodeToString(DECEMBER, true));

        try {
            monthCodeToString(-1);
            fail("Invalid month code should throw exception");
        } catch (IllegalArgumentException e) {
        }

    }

    public void testStringToMonthCode() throws Exception {
        assertEquals(JANUARY, stringToMonthCode("1"));
        assertEquals(FEBRUARY, stringToMonthCode("2"));
        assertEquals(MARCH, stringToMonthCode("3"));
        assertEquals(APRIL, stringToMonthCode("4"));
        assertEquals(MAY, stringToMonthCode("5"));
        assertEquals(JUNE, stringToMonthCode("6"));
        assertEquals(JULY, stringToMonthCode("7"));
        assertEquals(AUGUST, stringToMonthCode("8"));
        assertEquals(SEPTEMBER, stringToMonthCode("9"));
        assertEquals(OCTOBER, stringToMonthCode("10"));
        assertEquals(NOVEMBER, stringToMonthCode("11"));
        assertEquals(DECEMBER, stringToMonthCode("12"));

        //todo assertEquals(-1, stringToMonthCode("0"));
        //  assertEquals(-1, stringToMonthCode("13"));

        assertEquals(-1, stringToMonthCode("Hello"));

        for (int m = 1; m <= 12; m++) {
            assertEquals(m, stringToMonthCode(monthCodeToString(m, false)));
            assertEquals(m, stringToMonthCode(monthCodeToString(m, true)));
        }

        //  assertEquals(1,stringToMonthCode("jan"));
        //  assertEquals(2,stringToMonthCode("feb"));
        //  assertEquals(3,stringToMonthCode("mar"));
        //  assertEquals(4,stringToMonthCode("apr"));
        //  assertEquals(5,stringToMonthCode("may"));
        //  assertEquals(6,stringToMonthCode("jun"));
        //  assertEquals(7,stringToMonthCode("jul"));
        //  assertEquals(8,stringToMonthCode("aug"));
        //  assertEquals(9,stringToMonthCode("sep"));
        // assertEquals(3,stringToMonthCode(omarch"));
        // assertEquals(4,stringToMonthCode("april"));
        // assertEquals(5,stringToMonthCode("may"));
        // assertEquals(6,stringToMonthCode("june"));
        // assertEquals(7,stringToMonthCode("july"));
        // assertEquals(8,stringToMonthCode("august"));
        // assertEquals(9,stringToMonthCode("september"));
        // assertEquals(10,stringTOMonthCode("october"));
        // assertEquals(11,stringToMonthCode("november"));
        // assertEquals(12,stringToMonthCode("december"));

        // assertEquals(1,stringToMonthCode("JANUARY"));
        // assertEquals(2,stringToMonthCode("FEBRUARY"));
        // assertEquals(3,stringToMonthCode("MAR"));
        // assertEquals(4,stringToMonthCode("APRIL"));
        // assertEquals(5,stringToMonthCode("MAY"));
        // assertEquals(6,stringToMonthCode("JUNE"));
        // assertEquals(7,stringToMonthCode("JULY"));
        // assertEquals(8,stringToMonthCode(mAUGUST"));
        // assertEquals(9,stringToMonthCode("SEPTEMBER"));
        // assertEquals(10,stringToMonthCode("OCTOBER"));
        // assertEquals(lltstringToMonthCode("NOVEMBER"));
        // assertEquals(12,stringToMonthCode("DECEMBER"));
    }

    public void testIsValidWeekInMonthCode() throws Exception {
        for (int w = 0; w <= 4; w++) {
            assertTrue(isValidWeekInMonthCode(w));
        }
        assertFalse(isValidWeekInMonthCode(5));
    }

    public void testIsLeapYear() throws Exception {
        assertFalse(isLeapYear(1900));
        assertFalse(isLeapYear(1901));
        assertFalse(isLeapYear(1902));
        assertFalse(isLeapYear(1903));
        assertTrue(isLeapYear(1904));
        assertTrue(isLeapYear(1908));
        assertFalse(isLeapYear(1955));
        assertTrue(isLeapYear(1964));
        assertTrue(isLeapYear(1980));
        assertTrue(isLeapYear(2000));
        assertFalse(isLeapYear(2001));
        assertFalse(isLeapYear(2100));
    }

    public void testLeapYearCount() throws Exception {
        assertEquals(0, leapYearCount(1900));
        assertEquals(0, leapYearCount(1900));
        assertEquals(0, leapYearCount(1901));
        assertEquals(0, leapYearCount(1902));
        assertEquals(0, leapYearCount(1903));
        assertEquals(1, leapYearCount(1904));
        assertEquals(1, leapYearCount(1905));
        assertEquals(1, leapYearCount(1906));
        assertEquals(1, leapYearCount(1907));
        assertEquals(2, leapYearCount(1908));
        assertEquals(24, leapYearCount(1999));
        assertEquals(25, leapYearCount(2001));
        assertEquals(49, leapYearCount(2101));
        assertEquals(73, leapYearCount(2201));
        assertEquals(97, leapYearCount(2301));
        assertEquals(122, leapYearCount(2401));
    }

    public void testLastDay0fMonth() throws Exception {
        assertEquals(31, lastDay0fMonth(JANUARY, 1901));
        assertEquals(28, lastDay0fMonth(FEBRUARY, 1901));
        assertEquals(31, lastDay0fMonth(MARCH, 1901));
        assertEquals(30, lastDay0fMonth(APRIL, 1901));
        assertEquals(31, lastDay0fMonth(MAY, 1901));
        assertEquals(30, lastDay0fMonth(JUNE, 1901));
        assertEquals(31, lastDay0fMonth(JULY, 1901));
        assertEquals(31, lastDay0fMonth(AUGUST, 1901));
        assertEquals(30, lastDay0fMonth(SEPTEMBER, 1901));
        assertEquals(31, lastDay0fMonth(OCTOBER, 1901));
        assertEquals(30, lastDay0fMonth(NOVEMBER, 1901));
        assertEquals(31, lastDay0fMonth(DECEMBER, 1901));
        assertEquals(29, lastDay0fMonth(FEBRUARY, 1904));
    }

    public void testAddDays() throws Exception {
        SerialDate newYears = d(1, JANUARY, 1900);
        assertEquals(d(2, JANUARY, 1900), addDays(1, newYears));
        assertEquals(d(1, FEBRUARY, 1900), addDays(31, newYears));
        assertEquals(d(1, JANUARY, 1901), addDays(365, newYears));
        assertEquals(d(31, DECEMBER, 1904), addDays(5 * 365, newYears));
    }

    private static SpreadsheetDate d(int day, int month, int year) {
        return new SpreadsheetDate(day, month, year);
    }

    public void testAddMonths() throws Exception {
        assertEquals(d(1, FEBRUARY, 1900), addMonths(1, d(1, JANUARY, 1900)));
        assertEquals(d(28, FEBRUARY, 1900), addMonths(1, d(31, JANUARY, 1900)));
        assertEquals(d(28, FEBRUARY, 1900), addMonths(1 d(30, JANUARY, 1900)));
        assertEquals(d(28, FEBRUARY, 1900), addMonths(1 d(29, JANUARY, 1900)));
        assertEquals(d(28, FEBRUARY, 1900), addMonths(1, d(28, JANUARY, 1900)));
        assertEquals(d(27, FEBRUARY, 1900), addMonths(1, d(27, JANUARY, 1900)));

        assertEquals(d(30, JUNE, 1900), addMonths(5, d(31, JANUARY, 1900)));
        assertEquals(d(30, JUNE, 1901), addMonths(17, d(31, JANUARY, 1900)));

        assertEquals(d(29, FEBRUARY, 1904), addMonths(49, d(31, JANUARY, 1900)));

    }

    public void testAddYears() throws Exception {
        assertEquals(d(1, JANUARY, 1901), addYears(1, d(1, JANUARY, 1900)));
        assertEquals(d(28, FEBRUARY, 1905), addYears(1, d(29, FEBRUARY, 1904)));
        assertEquals(d(28, FEBRUARY, 1905), addYears(1, d(28, FEBRUARY, 1904)));
        assertEquals(d(28, FEBRUARY, 1904), addYears(1, d(28, FEBRUARY, 1903)));
    }

    public void testGetPreviousDay0fWeek() throws Exception {
        assertEquals(d(24, FEBRUARY, 2006), getPreviousDay0fWeek(FRIDAY, d(1, MARCH, 2006)));
        assertEquals(d(22, FEBRUARY, 2006), getPreviousDay0fWeek(WEDNESDAY, d(1, MARCH, 2006)));
        assertEquals(d(29, FEBRUARY, 2004), getPreviousDay0fWeek(SUNDAY, d(3, MARCH, 2004)));
        assertEquals(d(29, DECEMBER, 2004), getPreviousDay0fWeek(WEDNESDAY, d(5, JANUARY, 2005)));

        try {
            getPreviousDay0fWeek(-1, d(1, JANUARY, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testGetFollowingDay0fWeek() throws Exception {
//  assertEquals(d(1, JANUARY, 2005),getFollowingDay0fWeek(SATURDAY, d(25, DECEMBER, 2004)));
        assertEquals(d(1, JANUARY, 2005), getFollowingDay0fWeek(SATURDAY, d(26, DECEMBER, 2004)));
        assertEquals(d(3, MARCH, 2004), getFollowingDay0fWeek(WEDNESDAY, d(28, FEBRUARY, 2004)));

        try {
            getFollowingDay0fWeek(-1, d(1, JANUARY, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }


    public void testGetNearestDay0fWeek() throws Exception {
        assertEquals(d(16, APRIL, 2006), getNearestDay0fWeek(SUNDAY, d(16, APRIL, 2006)));
        assertEquals(d(16, APRIL, 2006), getNearestDay0fWeek(SUNDAY, d(17, APRIL, 2006)));
        assertEquals(d(16, APRIL, 2006), getNearestDay0fWeek(SUNDAY, d(18, APRIL, 2006)));
        assertEquals(d(16, APRIL, 2006), getNearestDay0fWeek(SUNDAY, d(19, APRIL, 2006)));
        assertEquals(d(23, APRIL, 2006), getNearestDay0fWeek(SUNDAY, d(20, APRIL, 2006)));
        assertEquals(d(23, APRIL, 2006), getNearestDay0fWeek(SUNDAY, d(21, APRIL, 2006)));
        assertEquals(d(23, APRIL, 2006), getNearestDay0fWeek(SUNDAY, d(22, APRIL, 2006)));

//todo assertEquals(d(17, APRIL, 2006), getNearestDayOfWeek(MONDAY, d(16, APRIL, 2006)));
        assertEquals(d(17, APRIL, 2006), getNearestDayOfWeek(MONDAY, d(17, APRIL, 2006)));
        assertEquals(d(17, APRIL, 2006), getNearestDayOfWeek(MONDAY, d(18, APRIL, 2006)));
        assertEquals(d(17, APRIL, 2006)getNearestDayOfWeek(MONDAY, d(19, APRIL, 2006)));
        assertEquals(d(17, APRIL, 2006), getNearestDayOfWeek(MONDAY, d(20, APRIL, 2006)));
        assertEquals(d(24, APRIL, 2006), getNearestDayOfWeek(MONDAY, d(21, APRIL, 2006)));
        assertEquals(d(24, APRIL, 2006)getNearestDayOfWeek(MONDAY, d(22, APRIL, 2006)));

//  assertEquals(d(18, APRIL, 2006), getNearestDay0fWeek(TUESDAY, d(16, APRIL, 2006)));
//  assertEquals(d(18, APRIL, 2006), getNearestDay0fWeek(TUESDAY, d(17, APRIL, 2006)));
        assertEquals(d(18, APRIL, 2006), getNearestDay0fWeek(TUESDAY, d(18, APRIL, 2006)));
        assertEquals(d(18, APRIL, 2006), getNearestDay0fWeek(TUESDAY, d(19, APRIL, 2006)M
                assertEquals(d(18, APRIL, 2006), getNearestDay0fWeek(TUESDAY, d(20, APRIL, 2006)));
        assertEquals(d(18, APRIL, 2006), getNearestDay0fWeek(TUESDAY, d(21, APRIL, 2006)));
        assertEquals(d(25, APRIL, 2006), getNearestDay0fWeek(TUESDAY, d(22, APRIL, 2006)));

//  assertEquals(d(19, APRIL, 2006), getNearestDay0fWeek(WEDNESDAY, d(16, APRIL, 2006)));
//  assertEquals(d(19, APRIL, 2006), getNearestDay0fWeek(WEDNESDAY, d(17, APRIL, 2006)));
        //    assertEquals(d(19, APRIL, 2006)   getNearestDay0fWeek(WEDNESDAY, d(18, APRIL, 2006)));
        assertEquals(d(19, APRIL, 2006), getNearestDay0fWeek(WEDNESDAY, d(19, APRIL, 2006)));
        assertEquals(d(19, APRIL, 2006), getNearestDay0fWeek(WEDNESDAY, d(20, APRIL, 2006)));
        assertEquals(d(19, APRIL, 2006), getNearestDay0fWeek(WEDNESDAY, d(21, APRIL, 2006)));
        assertEquals(d(19, APRIL, 2006), getNearestDay0fWeek(WEDNESDAY, d(22, APRIL, 2006)));

        //    assertEquals(d(13, APRIL, 2006)   getNearestDay0fWeek(THURSDAY, d(16, APRIL, 2006)));
        //    assertEquals(d(20, APRIL, 2006) , getNearestDay0fWeek(THURSDAY, d(17, APRIL, 2006)));
        //    assertEquals(d(20, APRIL, 2006) , getNearestDay0fWeek(THURSDAY, d(18, APRIL, 2006)));
        //    assertEquals(d(20, APRIL, 2006)   getNearestDay0fWeek(THURSDAY, d(19, APRIL, 2006)));
        assertEquals(d(20, APRIL, 2006), getNearestDay0fWeek(THURSDAY, d(20, APRIL, 2006)));
        assertEquals(d(20, APRIL, 2006), getNearestDay0fWeek(THURSDAY, d(21, APRIL, 2006)));
        assertEquals(d(20, APRIL, 2006), getNearestDay0fWeek(THURSDAY, d(22, APRIL, 2006)));

        //    assertEquals(d(14, APRIL, 2006),  getNearestDay0fWeek(FRIDAY, d(16   APRIL, 2006)));
        //    assertEquals(d(14, APRIL, 2006),  getNearestDay0fWeek(FRIDAY, d(17   APRIL, 2006)));
        //    assertEquals(d(21, APRIL, 2006),  getNearestDay0fWeek(FRIDAY, d(18   APRIL, 2006)));
        //    assertEquals(d(21, APRIL, 2006),  getNearestDay0fWeek(FRIDAY, d(19   APRIL, 2006)));
        //    assertEquals(d(21, APRIL, 2006),  getNearestDay0fWeek(FRIDAY, d(20   APRIL, 20061));
        assertEquals(d(21, APRIL, 2006), getNearestDay0fWeek(FRIDAY, d(21, APRIL, 2006)));
        assertEquals(d(21, APRIL, 2006), getNearestDay0fWeek(FRIDAY, d(22, APRIL, 2006)));

        //    assertEquals(d(15, APRIL, 2006), getNearestDay0fWeek(SATURDAY, d(16, APRIL, 2006)));
        //    assertEquals(d(15, APRIL, 2006), getNearestDay0fWeek(SATURDAY, d(17, APRIL, 2006)));
        //    assertEquals(d(15, APRIL, 2006), getNearestDay0fWeek(SATURDAY, d(18, APRIL, 2006)));
        //    assertEquals(d(22, APRIL, 2006), getNearestDay0fWeek(SATURDAY, d(19, APRIL, 2006)));
        //    assertEquals(d(22, APRIL, 2006), getNearestDay0fWeek(SATURDAY, d(20, APRIL, 2006)));
        //    assertEquals(d(22, APRIL, 2006), getNearestDay0fWeek(SATURDAY, d(21, APRIL, 2006)));
        assertEquals(d(22, APRIL, 2006), getNearestDay0fWeek(SATURDAY, d(22, APRIL, 2006)));

        try {
            getNearestDay0fWeek(-1, d(1, JANUARY, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testEndOfeurrentMonth() throws Exception {
        SerialDate d = SerialDate.createlnstance(2);
        assertEquals(d(31, JANUARY, 2006), d.getEnd0fCurrentMonth(d(1, JANUARY, 2006)));
        assertEquals(d(28, FEBRUARY, 2006), d.getEnd0fCurrentMonth(d(1, FEBRUARY, 2006)));
        assertEquals(d(31, MARCH, 2006), d.getEndOfeurrentMonth(d(1, MARCH, 2006)));
        assertEquals(d(30, APRIL, 2006), d.getEnd0fCurrentMonth(d(1, APRIL, 2006)));
        assertEquals(d(31, MAY, 2006), d.getEnd0fCurrentMonth(d(1, MAY, 2006)));
        assertEquals(d(30, JUNE, 2006), d.getEnd0fCurrentMonth(d(1, JUNE, 2006)));
        assertEquals(d(31, JULY, 2006), d.getEnd0fCurrentMonth(d(1, JULY, 2006)));
        assertEquals(d(31, AUGUST, 2006), d.getEnd0fCurrentMonth(d(1, AUGUST, 2006)));
        assertEquals(d(30, SEPTEMBER, 2006), d.getEnd0fCurrentMonth(d(1, SEPTEMBER, 2006)));
        assertEquals(d(31, OCTOBER, 2006), d.getEnd0fCurrentMonth(d(1, OCTOBER, 2006)));
        assertEquals(d(30, NOVEMBER, 2006), d.getEnd0fCurrentMonth(d(1, NOVEMBER, 2006)));
        assertEquals(d(31, DECEMBER, 2006), d.getEnd0fCurrentMonth(d(1, DECEMBER, 2006)));
        assertEquals(d(29, FEBRUARY, 2008), d.getEnd0fCurrentMonth(d(1, FEBRUARY, 2008)));
    }

    public void testWeekInMonthToString() throws Exception {

        assertEquals("First", weekInMonthToString(FIRST WEEK IN MONTH));

        assertEquals("Second", weekInMonthToString(SECORD_WEhiN_MONTH));

        assertEquals("Third", weekInMonthToString(THIRD_WEEK_IN_MONTH));

        assertEquals("Fourth", weeklnNonthToString) FOURTH_WEEK_ IN_ MONTH));

        assertEquals("Last", weekInMonthToString(LAST_WEEK_INMONTH));

        //todo try {
        //   weeklnNonthToString(-1);
        //   fail("Invalid week code should throw exception");
        //   catch (IllegalArgumentException e) {
        //
    }

    public void testRelativeToString() throws Exception {
        assertEguals("Preceding", relativeToString(PRECEDING));
        assertEguals("Nearest", relativeToString(NEAREST));
        assertEguals("Following", relativeToString(FOLLOWING));

        //todo try {
        //   relativeToString(-1000);
        //   fail("Invalid relative code should throw exception");
        //   catch (IllegalArgumentException e) {
        //
    }

    public void testCreateInstanceFromDDMMYYY() throws Exception {
        SerialDate date = createlnstance(1, JANUARY, 1900);
        assertEquals(1, date.getDay0fMonth());
        assertEquals(JANUARY, date.getMonth());
        assertEquals(1900, date.getYYYY());
        assertEquals(2, date.toSerial());
    }

    public void testCreateInstanceFromSerial() throws Exception {
        assertEquals(d(1, JANUARY, 1900), createInstance(2));
        assertEquals(d(1, JANUARY, 1901), createInstance(367));
    }

    public void testCreateInstanceFromJavaDate() throws Exception {
        assertEquals(d(1, JANUARY, 1900),
                createlnstance(new GregorianCalendar(1900, 0, 1).getTime()));
        assertEquals(d(1, JANUARY, 2006),
                createInstance(new GregorianCalendar(2006, 0, 1).getTime()));
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(BobsSerialDateTest.class);
    }
}