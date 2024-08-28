# Refactoring Notes

This branch shows my attempt to follow Duncan McGregor's refactoring progression as described in his "Refactoring Java to Kotlin" course on OReilly.com

I didn't mimic everything he did to the minute detail, only the general path he took.

I'm trying to articulate the thought process behind the choices he made in a effort to find ways to teach others how they might learn how to think along the same lines.

# Step 1 - Getting to a high-level understanding of the code

The first thing I do when approaching a codebase for the first time is to look for some documentation. I scan the top-level directory for a README file. This project does have a README file but it focuses more on the tests and testing.

Fortunately, there's a [GuildedRoseRequirements.md](../GildedRoseRequirements.md) file at the top level of the repository that does give a detailed description of how the program should work.

# Step 2 - Establish a "base" from which to explore the program.

Once I have a general understanding of what the user is looking for in the program, I establish a base from which to explore the detailed functionality.

I'll usually start with the tests, because I expect tests to show me examples of how the production code is used, its API, and expected outputs.

Understanding how the tests work also gives me an idea of what the previous authors/maintainers of the code did to make it easy for others to follow in their footsteps. If I fund useful tests, great. If not, then at least I know I have my work cut out for me.

Next, I look at the tests available to find the main entry point(s) of the program. Looking in the [test directory](src/test/java/com/gildedrose/), I see a couple of potential test classes. The [first one, GuildedRoseTest.java](src/test/java/com/gildedrose/GildedRoseTest.java), is a bogus test. The [second one, TexttestFixture](src/test/java/com/gildedrose/TexttestFixture.java), looks a little more promising.

In his video, Duncan converts TesttestFixture into a proper JUnit test class. I opted to leave it alone and create a new tests class, [ApprovalTest.java](src/test/java/com/gildedrose/ApprovalTest.java), instead, with more or less the same code that Duncan had. I used 30 days to generate the approved output.
