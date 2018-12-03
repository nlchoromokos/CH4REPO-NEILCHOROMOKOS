//********************************************************************
//  Student.java       Author: Lewis/Loftus/Cocking
//
//  Represents a college student.
//********************************************************************

public class Student
{
   private String firstName, lastName;
   private Address homeAddress, schoolAddress;
   private int[] tests = new int[3];

   //-----------------------------------------------------------------
   //  Sets up this Student object with the specified initial values.
   //-----------------------------------------------------------------
   public Student (String first, String last, Address home, Address school, int test1, int test2, int test3)
   {
      firstName = first;
      lastName = last;
      homeAddress = home;
      schoolAddress = school;
      tests[0] = test1;
      tests[1] = test2;
      tests[2] = test3;
   }
   
   
   
   /**
    * takes just name and address and sets all tests to 0's
    */
   public Student (String first, String last, Address home, Address school)
   {
      firstName = first;
      lastName = last;
      homeAddress = home;
      schoolAddress = school;
      tests[0] = 0;
      tests[1] = 0;
      tests[2] = 0;
   }
   
   
   
   
   /**
    * returns average of test scores for student 
    * @return double value average of 3 tests
    */
   public double testAverage()
   {
       int total = 0;
       for (int i = 0; i<3; i++){total+=tests[i];}
       return total/3;
   }
   
   
   
   
   /**
    * sets one test score
    * @param number of test to be changed (1-3), int score to be changed to
    */
   public void setTestScore(int num, int score)
   {
       tests[num-1] = score;
   }
   
   
   
   
   /**
    * gets one test score
    * @param number of test to get (1-3)
    */
   public int getTestScore(int num)
   {
       return tests[num-1];
   }
   
   
   
   //-----------------------------------------------------------------
   //  Returns this Student object as a string.
   //-----------------------------------------------------------------
   public String toString()
   {
      String result;

      result = firstName + " " + lastName + "\n";
      result += "Home Address:\n" + homeAddress + "\n";
      result += "School Address:\n" + schoolAddress + "\n";
      result += "Test 1 Score:\n" + tests[0] + "\n";
      result += "Test 2 Score:\n" + tests[1] + "\n";
      result += "Test 3 Score:\n" + tests[2] + "\n";
      result += testAverage();
      
      return result;
   }
}
