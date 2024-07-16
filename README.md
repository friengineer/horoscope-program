# Horoscope Program
My contribution to a pair project creating a program that found your horoscope for the day using web APIs including an external web API.

I created a RESTful service which takes a day and month as a string and returns the corresponding zodiac sign for the date. I also created a program to test connecting to the external web API and time how long it took to get a response from it.

Requires Java 8.

This project was written using IntelliJ IDEA Ultimate so it is recommended to run it using a Java IDE.

The zodiac sign service is invoked by sending a request to `http://localhost:2323/zodiacsign/{day}/{month}` where you supply the day and month as numbers (e.g. 10th January is 10/1).

To execute the zodiac sign service, run `ZodiacSignServer.main()`.

To execute the external client program, run `ExternalClient.main()`.
