# MindFactory WebScraper

A WebScraper made in java for MindFactory.de to follow parts prices history and changes from the current moment it's installed and so forth.
README.md is not final and subject to major changes in the future. Note that the current version of the program is jsut a prototype.

### Installing

Download the jar file and place it preferrably in a new folder.



### Usage

This program needs a base file to store the info. Create a new text or a regular file and name it whatever you like.
Copy it's location and paste it when asked to. That will be your base file and all the files that are created will be using your base file's location automatically.


When the program is first opened, it runs a check for the prices and then keeps checking every *N* hours
(As defined in 5.)

1. Your parts list.

Shows all the parts you have saved. Press 6 to go back.

2. Add a part

When selected it prompts the user to enter a link of the part from mindfactory.de that the price will be taken from.
The part is then added to the parts list and is being watched. The part is saved as file: Part*N* (N being a number from 0 - N)

3. Remove a part

Removes a part from the list.

4. Check prices for all

Instantly checks the prices for all the saved parts and notifies If there are any changes.

5. Set time interval

Set the time interval for checking prices automatically each *N* hours.

To check the price history, simply open the Part*N* file, *N* being the number lister in 1.'s parts list.
The format of the file is as such:
**Name of part**
**Link of the part**
**Date of last time the price was checked**    **Price as of that date**




### Ideas for the future:
- Make price history readings from the application directly
- Use WaybackMachine to get price history



## Built With

* [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows)

## Contributing

Open issues.

## Authors

* **Sibuscus** - *Everything*


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Thank you MindFactory.de for:
- Changing the price regularly a few times throughout the day.
- Not having a price history to check the history of the prices.

