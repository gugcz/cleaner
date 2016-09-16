# cleaner
Script for cleaning inactive organizers of GUG.cz
## How to use it
 - go to GUG.cz admin
 - click to Users -> Export
 - Select these columns:
  - E-mail
  - First Name
  - Last Name
  - Group/Name
  - Event Occurence/Start
  - Garant of Event Occurence/Start
- Click Export to JSON
- Clone this repo
- Replace input.json with your JSON
- Run './gradlew run' in the project folder
 
## Why the name?
It's based on my favorite TV show Black Books, specifically episode [Grapes of Wrath](https://www.youtube.com/watch?v=C4wBLUBa8YI).

![Dirty!](https://s-media-cache-ak0.pinimg.com/564x/b0/56/29/b05629bd2a62114d9fc8c79311ac63da.jpg)

