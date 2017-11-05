<div class="post_region_content note" id="view_quesiton_note">
        
<h1 data-pats="title_text" class="post_region_title">Assignment 5</h1>

<div class="post_region_text" id="questionText"><p>Due Wednesday October 25 at 11:59pm. <strong>NOTE, we will run Moss on all your submissions to detect copying. If there is copying but the person copied from and the person copying will get 0 on the assignment</strong>. Future copying will result in the use of the Academic Honesty violation procedures.</p>
<p>&nbsp;</p>
<p>Code is in the package <tt>assignment05</tt>. Make an <strong>interface</strong> <tt>TravelExpenses</tt>. It has 4 static constants (the words public and static are there implicitly)</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="kwd">double</span><span class="pln"> mileage </span><span class="pun">=</span><span class="pln"> </span><span class="lit">0.53</span><span class="pun">;</span><span class="pln"> </span><span class="com">// cents per mile driven in a private car</span><span class="pln">
</span><span class="kwd">double</span><span class="pln"> BREAKFAST_MAX </span><span class="pun">=</span><span class="pln"> </span><span class="lit">8.0</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">double</span><span class="pln"> LUNCH_MAX </span><span class="pun">=</span><span class="pln"> </span><span class="lit">10.0</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">double</span><span class="pln"> DINNER_MAX </span><span class="pun">=</span><span class="pln"> </span><span class="lit">40.0</span><span class="pun">;</span></pre>
<p>These do not need the word final and will be visible to all implementing classes.</p>
<p>&nbsp;</p>
<p>Add the method <tt>double amountToReimburse();</tt></p>
<p>which will public in the implementing classes.</p>
<p>&nbsp;</p>
<p>Add a concrete default method default String getDescription(), which has one line that throws <tt>UnsupportedOperationException</tt> with the message <em>Must be implemented by class</em>.</p>
<p>Add a concrete static method <tt>static void printReport(ArrayList&lt;TravelExpenses&gt; list)</tt> that prints a list of expenses: For each element of the list,</p>
<p><strong>first print the start date and end date if they are different, otherwise just the start date. <strong>In either case followed by a "\n".</strong></strong></p>
<p><strong>NOTE: the start date and end date are added by some default methods, which are supplied below, where the assignment says add the following to TravelExpenses.&nbsp;</strong></p>
<p>Next, get the amount spent as a String using</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="typ">String</span><span class="pln"> s </span><span class="pun">=</span><span class="pln"> </span><span class="typ">String</span><span class="pun">.</span><span class="pln">format</span><span class="pun">(</span><span class="str">"$%.2f"</span><span class="pun">,</span><span class="pln"> te</span><span class="pun">.</span><span class="pln">amountToReimburse</span><span class="pun">());</span><span class="pln"> </span><span class="com">// where te is a TravelExpense in list</span></pre>
<p>&nbsp;</p>
<p>Then print the concatenation of <tt>te.getDescription()</tt> and <tt>s</tt>.<strong> At the end of the method, after printing the information about all the elements in list, also print "Total Expenses" and the sum of all the individual expenses on a separate line.</strong></p>
<p>&nbsp;</p>
<p>Next we start making expense items.</p>
<p>&nbsp;</p>
<p>The first one is TravelByRentalCar (this is a java class in a separate file) that implements TravelExpenses. The fields are</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="kwd">private</span><span class="pln"> </span><span class="kwd">double</span><span class="pln"> totalRentalCost</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">private</span><span class="pln"> </span><span class="kwd">double</span><span class="pln"> fuelCost</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">private</span><span class="pln"> </span><span class="kwd">double</span><span class="pln"> fuelUsed</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">private</span><span class="pln"> </span><span class="kwd">int</span><span class="pln"> numberOfDaysRented</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">private</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> rentalCompany</span><span class="pun">;</span><span class="pln">	
</span><span class="kwd">private</span><span class="pln"> </span><span class="typ">LocalDate</span><span class="pln"> startDate</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">private</span><span class="pln"> </span><span class="typ">LocalDate</span><span class="pln"> endDate</span><span class="pun">;</span></pre>
<p>The constructor only sets totalRentalCost, rentalCompany, startDate, endDate. You compute numberofDaysRented using</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="com">// import import java.time.temporal.ChronoUnit;</span><span class="pln">

numberOfDaysRented </span><span class="pun">=</span><span class="pln"> </span><span class="pun">(</span><span class="kwd">int</span><span class="pun">)</span><span class="typ">ChronoUnit</span><span class="pun">.</span><span class="pln">DAYS</span><span class="pun">.</span><span class="pln">between</span><span class="pun">(</span><span class="pln">startDate</span><span class="pun">,</span><span class="pln"> endDate</span><span class="pun">);</span></pre>
<p>The nice thing here is that it computes the days across months and even years.</p>
<p>&nbsp;</p>
<p>We need a method <tt>public void addFuel(double numGallons, double cost)</tt>, which adds to the <tt>fuelUsed</tt> and <tt>fuelCost</tt> fields. The overridden method <tt>public String getDescription()</tt> should put together a String that says it is a rental car from <tt>rentalCompany</tt> for <tt>numberOfDaysRented</tt> days from <tt>startDate</tt> to <tt>endDate</tt>, <tt>Math.round(fuelUsed)</tt> gallons of fuel used. You can put "\n" in the String to spread it over 2 lines. The method <tt>public double amountToReimburse()</tt>should be overridden to return the <tt>totalRentalCost</tt> plus the <tt>fuelCost</tt>.</p>
<p>&nbsp;</p>
<p>Just to get a first taste of enum types, introduce the enum</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="kwd">public</span><span class="pln"> </span><span class="kwd">enum</span><span class="pln"> </span><span class="typ">MealType</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
	BREAKFAST</span><span class="pun">(</span><span class="typ">TravelExpenses</span><span class="pun">.</span><span class="pln">BREAKFAST_MAX</span><span class="pun">),</span><span class="pln"> 
	LUNCH</span><span class="pun">(</span><span class="typ">TravelExpenses</span><span class="pun">.</span><span class="pln">LUNCH_MAX</span><span class="pun">),</span><span class="pln"> 
	DINNER</span><span class="pun">(</span><span class="typ">TravelExpenses</span><span class="pun">.</span><span class="pln">DINNER_MAX</span><span class="pun">);</span><span class="pln">
	
	</span><span class="kwd">private</span><span class="pln"> </span><span class="kwd">double</span><span class="pln"> max</span><span class="pun">;</span><span class="pln">
	</span><span class="kwd">private</span><span class="pln"> </span><span class="typ">MealType</span><span class="pun">(</span><span class="kwd">double</span><span class="pln"> max</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
		</span><span class="kwd">this</span><span class="pun">.</span><span class="pln">max </span><span class="pun">=</span><span class="pln"> max</span><span class="pun">;</span><span class="pln">
	</span><span class="pun">}</span><span class="pln">
	
	</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">double</span><span class="pln"> getMax</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
		</span><span class="kwd">return</span><span class="pln"> max</span><span class="pun">;</span><span class="pln">
	</span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span><span class="pln">	</span></pre>
<p>Make a class <tt>Meal</tt> that implements <tt>TravelExpenses</tt>. The private fields are <tt>MealType mealType</tt> and <tt>double amountPaid</tt> and <tt>LocalDate mealDate</tt>.The constructor sets the values of all three fields. Note that to call this constructor in testing you use something like <tt>new Meal(MealType.LUNCH, 12.50)</tt>. If you decide to pass in two parameters to the constructor, set the LocalDate to the LocalDate.now() object. Otherwise, you can pass in a LocalDate as a third parameter of the constructor and set the data field equal to that. The override of <tt>amountToReimburse</tt> should return the <tt>Math.max</tt> of <tt>amountPaid</tt> and <tt>mealType.getMax()</tt>. The override of <tt>getDescription</tt> should concantenate <tt>mealType</tt>, " on " and date. Note that the toString of <tt>mealType</tt> will be one of BREAKFAST. LUNCH or DINNER.</p>
<p>&nbsp;</p>
<p>We need a class <tt>Lodging</tt> that implements <tt>TravelExpenses</tt>. The fields need to be <tt>startDate, endDate, lodgingName, numberOfNights</tt>, and <tt>costOfStay</tt>. The override of <tt>amountToReimburse</tt> returns the <tt>costOfStay</tt> and the description includes the dates, lodgingName, and the number of nights. Number of nights should be calculated again using ChronoUnit, as was done in TravelByRentalCar.java. The constructor of Lodging will&nbsp;set the startDate, endDate, lodgingName, numberOfNights using ChronoUnit, and then costOfStay.</p>
<p>&nbsp;</p>
<p>We need a class <tt>TravelByAir</tt> that implements <tt>TravelExpenses</tt>. The fields need to be <tt>outboundStartDate, inboundEndDate, airlines</tt> (you could have a String like "Delta and Emirates"), <tt>totalCost</tt>. The override of amountToReimburse returns the <tt>totalCost</tt> and the description includes the airlines.</p>
<p>&nbsp;</p>
<p>The class <tt>TravelByOwnCar</tt> will have the private fields double <tt>milesDriven</tt>, LocalDates <tt>startDate</tt> and <tt>endDate</tt>. The constructor just sets the start and end dates. We need an addMiles method that adds miles to the field milesDriven. The getDesription will return a String "Own car used, miles driven: " followed by the milesDriven. The amountToReimpurse is the product of milesDrive and <em>mileage</em>. Note mileage is inherited from TravelExpenses.<br><br></p>
<p><strong>Add the following to TravelExpenses: </strong></p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="kwd">default</span><span class="pln"> </span><span class="typ">LocalDate</span><span class="pln"> getStartDate</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
	</span><span class="kwd">return</span><span class="pln"> </span><span class="typ">LocalDate</span><span class="pun">.</span><span class="pln">now</span><span class="pun">();</span><span class="pln">
</span><span class="pun">}</span><span class="pln">
</span><span class="kwd">default</span><span class="pln"> </span><span class="typ">LocalDate</span><span class="pln"> getEndDate</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
	</span><span class="kwd">return</span><span class="pln"> </span><span class="typ">LocalDate</span><span class="pun">.</span><span class="pln">now</span><span class="pun">();</span><span class="pln">
</span><span class="pun">}</span><span class="pln">
</span><span class="kwd">default</span><span class="pln"> </span><span class="kwd">int</span><span class="pln"> sequenceNo</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
	</span><span class="kwd">return</span><span class="pln"> </span><span class="typ">Integer</span><span class="pun">.</span><span class="pln">MAX_VALUE</span><span class="pun">;</span><span class="pln">
</span><span class="pun">}</span></pre>
<p><strong>and override the getStartDate and getEndDate methods in all your classes which implement TravelExpenses to return the actual <tt>startDate</tt> and&nbsp;<tt>endDate</tt> or <tt>outboundStartDate</tt> and&nbsp;<tt>inboundEndDate</tt> as appropriate.<br></strong></p>
<p><strong>For Meal.java , override getStartDate and getEndDate to both return mealDate. </strong></p>
<p>&nbsp;</p>
<p><strong>Override the sequenceNo method to return 1 in TravelByAir, 2 in TravelByRail, 3 in TravelByBus, 4 in TravelByRentalCar, 5 in TravelByOwnCar, 6 in Lodging. Do not override it in Meal.<br></strong></p>
<p>&nbsp;</p>
<p>We need a class <tt>TravelByRail</tt> that implements <tt>TravelExpenses</tt>. The fields need to be <tt>outboundStartDate, inboundEndDate, railLines</tt> (if you were on a trip in Europe, you could mutiple rail companies), <tt>totalCost</tt>. The override of <tt>amountToReimburse</tt> returns the <tt>totalCost</tt> and the description includes the <tt>railLines</tt>. <em>To write this class first right-lick on the class AirTravel in the package explore; select copy and immediately after select paste; in the window that pops up change the name to TravelByRail; open the class TravelByRail; drag the mouse over the field airlines to select it; right-click on the word and select Refactor and then click Rename; change it to railLines and press enter. You should see that all the places the field appeared are now changed. Do a similar operation on the parameter for airline in the constructor.&nbsp;</em></p>
<p>&nbsp;</p>
<p>Repeat what you did for <tt>TravelByRail</tt> for <tt>TravelByBus</tt>.</p>
<p>&nbsp;</p>
<p>Go back to your code for printReport and put a new line at the start:</p>
<p>&nbsp;</p>
<p><tt>Collections.sort(list, Comparator.comparing(TravelExpenses::getStartDate));</tt></p>
<p>&nbsp;</p>
<p>Since the getStartDate method returns a LocalDate, which is Comparable, the Comparator.comparing method will build a comparator that uses the compareTo of LocalDate for the int value (negative, 0, or positive) needed to say which TravelExpense in a par of expenses goes before the other one. The :: notation is new in Java 8.</p>
<p>&nbsp;</p>
<p>Create a class ExpensesOrder which implements Comparator&lt;TravelExpenses&gt;. You have to implement <tt>public int compare(TravelExpenses arg0, TravelExpenses arg1)</tt>. In most cases you return <tt>arg0.sequenceNo() - arg1.sequenceNo()</tt>. However if arg0 and arg1 are both <tt>instanceof Meal</tt>, we use the ordering in the enum (the order in which the values were defined), namely [<strong>you will need to add the getter method <tt>getMealType</tt> to <tt>Meal</tt></strong>]</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="pun">((</span><span class="typ">Meal</span><span class="pun">)</span><span class="pln">arg0</span><span class="pun">).</span><span class="pln">getMealType</span><span class="pun">().</span><span class="pln">compareTo</span><span class="pun">(((</span><span class="typ">Meal</span><span class="pun">)</span><span class="pln">arg1</span><span class="pun">).</span><span class="pln">getMealType</span><span class="pun">())</span></pre>
<p>&nbsp;</p>
<p>Now we can replace the sort</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="typ">Collections</span><span class="pun">.</span><span class="pln">sort</span><span class="pun">(</span><span class="pln">list</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Comparator</span><span class="pun">.</span><span class="pln">comparing</span><span class="pun">(</span><span class="typ">TravelExpenses</span><span class="pun">::</span><span class="pln">getStartDate</span><span class="pun">));</span></pre>
<p>&nbsp;</p>
<p>by</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="typ">Collections</span><span class="pun">.</span><span class="pln">sort</span><span class="pun">(</span><span class="pln">list</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Comparator</span><span class="pun">.</span><span class="pln">comparing</span><span class="pun">(</span><span class="typ">TravelExpenses</span><span class="pun">::</span><span class="pln">getStartDate</span><span class="pun">).</span><span class="pln">thenComparing</span><span class="pun">(</span><span class="kwd">new</span><span class="pln"> </span><span class="typ">ExpensesOrder</span><span class="pun">()));</span></pre>
<p>&nbsp;</p>
<p>at the start of the printReport method of TravelExpenses.</p>
<p>&nbsp;</p>
<p>Modify the printReport according to the new instructions in bold earlier in the page.</p>
<p><strong>We have to write a test program that demonstrates that the comparator sorts correctly</strong>. JUnits to test the amountToReimburse is OK but JUnit tests of the descriptions is too much work.</p>
<p>&nbsp;</p>
<p>Make a class Person, that implements Comparable&lt;Person&gt;. The fields are lastName, firstNames, dateOfBirth (a LocalDate). Provide a constructor to set all the fields. The compareTo returns</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="pun">(</span><span class="pln">lastName </span><span class="pun">+</span><span class="pln"> firstNames</span><span class="pun">).</span><span class="pln">compareToIgnoreCase</span><span class="pun">(</span><span class="pln">other</span><span class="pun">.</span><span class="pln">lastName </span><span class="pun">+</span><span class="pln"> other</span><span class="pun">.</span><span class="pln">firstNames</span><span class="pun">);</span></pre>
<p>This way we can sort a list of Person by name, alphabetically.</p>
<p>Provide getter methods for dateOfBirth.</p>
<p>&nbsp;</p>
<p>Here are some slick ways to define comparators. The :: notation is using method references, <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html" target="_blank" rel="noreferrer">which you can learn more about here</a>:</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="kwd">public</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="typ">Comparator</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> byDOB </span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
	</span><span class="kwd">return</span><span class="pln"> </span><span class="typ">Comparator</span><span class="pun">.</span><span class="pln">comparing</span><span class="pun">(</span><span class="typ">Person</span><span class="pun">::</span><span class="pln">getDateOfBirth</span><span class="pun">);</span><span class="pln">
</span><span class="pun">}</span><span class="pln">
</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="typ">Comparator</span><span class="pun">&lt;</span><span class="typ">Person</span><span class="pun">&gt;</span><span class="pln"> byDOBandName </span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
	</span><span class="kwd">return</span><span class="pln"> byDOB</span><span class="pun">().</span><span class="pln">thenComparing</span><span class="pun">(</span><span class="typ">Comparator</span><span class="pun">.</span><span class="pln">naturalOrder</span><span class="pun">());</span><span class="pln">
</span><span class="pun">}</span></pre>
<p>Now write a class <tt>ByDobThenNameComp</tt> implements <tt>Comparator&lt;Person&gt;</tt> that will do the same as <tt>byDOBandName</tt> above but write the <tt>compare(person1, person2)</tt> with explicit<tt> if</tt> statements: first the return value is <tt>person1.getDateOfBirth().compareTo(person2.getDateOfBirth())</tt> but if that value is 0, then the value is <tt>person1.compareTo(person2)</tt>.</p>
<p>&nbsp;</p>
<p>Make a class <tt>Course</tt> with private fields <tt>String courseName</tt> and<tt> int[] pagesToRead</tt>. There is a method to&nbsp;<tt>public void setNumReadings(int readings)</tt> that instantiates the array to have length <tt>readings</tt>. There is a method <tt>public void setPages(int reading, int totalPages)</tt> that sets the number of pages in <tt>pagesToRead[reading]</tt>. In the testing <tt>readings</tt> will be numbered from 0. We need getter methods <tt>public int getNumReadings()</tt> and<tt> int getTotalPages(int reading)</tt> and a getter for<tt> courseName</tt>.</p>
<p>&nbsp;</p>
<p>Make a class Student. The private fields are<tt> Person self, Course course</tt> and <tt>int[] progress</tt>. The constructor only sets the value of <tt>self</tt>. Add a method <tt>public void setCourse(Course crs)</tt>, which sets the value of <tt>course</tt> and also instantiates progress to the length of the <tt>pagesToRead</tt> array in <tt>crs</tt>. Make a method <tt>public void read(int reading)</tt>, which adds 1 to <tt>progess[reading], provided that the entry is still less than</tt>&nbsp;the total number of pages in that reading. To avoid repeating the check on whether that reading is complete, add an array <tt>boolean[] completed</tt> to Student as a private field. Inside the setCourse method, also be sure to instantiate <code>completed</code> to the length of the <code>pagesToRead</code> array in <code>crs and make sure its has all false values for its entries, since no reading has been done yet</code>. Once you have read the maximum number of pages in a <tt>reading</tt>, then you change&nbsp; <tt>completed[reading]</tt> from false to true. Do this check before the read() method returns, but after you have added 1 to the progress entry. This means next time the read method is called, you can check if the reading is completed. If it is, then we do not add 1 to the corresponding entry in progress, and we return since the reading is completed and there is no more to read for the specified reading.&nbsp;</p>
<p>&nbsp;</p>
<p>Write a method <tt>public int percentRead</tt>, which computes the percent of pages read over all the readings. You must compute using doubles with a (double) cast because <tt>totalPagesRead / totalPagesOfReadingRequired</tt> is 0 or 1. Convert the double result to an int using (int)Math.round(....). You should also multiply the double by 100 before doing the Math.round and casting it to an int. Here, totalPagesRead is equal to the sum of all entries in the progress array, and totalPagesOfReadingRequired is equal to the sum of all entries inside the pagesToRead array, stored inside the Course field of this Student class. You can access the ith entry of the pagesToRead array inside the course field by using course.getTotalPages(i).&nbsp;</p>
<p>&nbsp;</p>
<p>Similarly write a method <tt>public int percentCompleted</tt>, which computes the percent of readings that have been completed.</p>
<p>&nbsp;</p>
<p>Write a comparator class <tt>ByCourseProgress</tt> implements <tt>Comparator&lt;Student&gt;</tt> that makes Students with courses "greater than" students that do not have a course (you will need a getter for <tt>course</tt>&nbsp;in Student.java that could return null). If both students do not have a course, then compare them by their names alphabetically. If both Students have a course, the one with a greater percentRead is "greater than" the other. If both have the same percentRead, then the larger percentCompleted indicated the "greater" Student [Please note that we are allowing students to read bit of as many readings as they want--they do <em>not</em> have to complete one reading before starting the next]. If two students have the same percentages, the compare method should put the students in alphabetical order using the Comparable property of <tt>self, that is, the compareTo() method that you implemented in Person.java</tt>. <strong>(You will need a getter method for the Person field inside Student.java in order to use the compareTo() method sucessfully here. Alternately, you could also make Student Comparable,&nbsp;and have a compareTo that returns self.compareTo(other.self). You can do either, your choice here. Whichever seems more natural for you.)</strong></p>
<p>&nbsp;</p>
<p>Write a test program Tester1 for the expenses of one person, print the expenses as you add them to the expenses ArrayList and then print the report but make the expenses <em>in an order that shows that the sorting changes the order correctly.&nbsp;<strong>Reminder from last lab: classes which implement an interface are considered a subtype of that interface. So, this means it is legal to write the following line of code for example:&nbsp;</strong></em></p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="typ">TravelExpenses</span><span class="pln"> planeExpense </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">TravelByAir</span><span class="pun">(</span><span class="typ">LocalDate</span><span class="pun">.</span><span class="pln">of</span><span class="pun">(</span><span class="lit">2017</span><span class="pun">,</span><span class="pln"> </span><span class="lit">10</span><span class="pun">,</span><span class="pln"> </span><span class="lit">25</span><span class="pun">),</span><span class="pln"> </span><span class="typ">LocalDate</span><span class="pun">.</span><span class="pln">of</span><span class="pun">(</span><span class="lit">2017</span><span class="pun">,</span><span class="pln"> </span><span class="lit">10</span><span class="pun">,</span><span class="pln"> </span><span class="lit">26</span><span class="pun">),</span><span class="pln"> </span><span class="str">"Delta Air Lines"</span><span class="pun">,</span><span class="pln"> </span><span class="lit">355.00</span><span class="pun">);</span></pre>
<p>Make some more of these different types of TravelExpenses and add them all into an ArrayList&lt;TravelExpenses&gt;. Then do the printing for this tester. <a href="https://www.tutorialspoint.com/javatime/javatime_localdate_of.htm" target="_blank" rel="noreferrer">See LocalDate.of for documentation and examples of using this method</a>.</p>
<p>&nbsp;</p>
<p>Write a test program Tester2 for the Student and Course. Use this <a href="https://d1b10bmlvqabco.cloudfront.net/attach/j2pqenz45a72r/iju6iqt2h4n48o/j924qaovkfoc/NamesResource.java" target="_blank" rel="noreferrer">NamesResource.java</a> to generate random Person objects (see the end of the main method of this class). The main method is really only meant to show you how you can use the methods in this provided java file. You will need to use the methods yourself in the Tester2. You do not need all the utility methods here but they may be useful to you in other programs.</p>
<p>&nbsp;</p>
<p>DONE--to the TAs, please correct or add details as needed.</p>
<p>&nbsp;</p>
<p>&nbsp;</p><br></div>
<div data-pats="folders" class="post_region_folders">
  <span>
    <span data-pats="folders_item"><a data-pats="link" href="#" class="tag folder" onclick="PEM.fire('filterFeed', {filter:'folder',folder:'assignment5'});return false;">assignment5</a></span>
  </span>
</div>
<div class="attachments" style="display:none;">
  <div class="attachments_divider"></div>
  <div class="attachments_count">Attachments:</div>
  <table class="attachments_list">
    
  </table>
</div>
<div class="post_region_message_wrapper">
  <div id="endorse_text"></div>
  
  
  
