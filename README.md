CS 222 Project 1
Cole Curtis
Lleyton Parsons

The 5 warnings in WikipediaReader.java are all warnings about depreciated methods including URLS. Numerous spelling check errors are present as well, but are part of URL links used in the code.

Needed build: Version of Gradle that supports kotlin, plugins for JavaFx (("org.openjfx.javaplugin") version "(version numbers)", JavaFXOptions, JavaApplication, with a repository of mavenCentral().

Instructions: There are two separate ways to search for article revisions. One method is using the ConsoleMain class, which uses the console for user input and displaying search results and errors. The other method is through the GUI, which can be used by using the GUIMain class, though it should be noted that to properly use this class, you must run the application through Gradle, which can be done on the side of your screen under the folder "application", under the folder "Tasks".

Our project prompts the user for the name of the Wikipedia article they wish to see the revisions on. Afterwards, our program prints out the 15 latest revisions of said article. If the user does not put in an article name for input, an appropriate error message is displayed. Same applies for network errors and searching for Wikipedia articles that do not exist. Test classes include a formatOutput, ErrorChecking, WikipediaReader, and RevisionParser.
