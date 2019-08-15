# Assignment2

This project has been created as second assignment of PADC Batch9 FTC.
In purpose of using adpater based view with delegation, small car rental app contained two screen is assigned to check how much we absorb this article.

Firstly, main activity is created with viewpager containing three dynamic fragment. Each fragment has recyclering view for car list according to the filter values; lowest price, distance and recommended.
Then CarItemDelegate interface is implemented and call DetailActivity from it's onClickEvent() method.

DetailActivity is just showing information concerning with renting a car inside a nestedscrollview.

### MainScreen
![MainScreen](https://user-images.githubusercontent.com/20620501/63112531-79354c80-bfb6-11e9-8858-a15d030c1e17.jpg)

### Detail Screen
![DetailScreen](https://user-images.githubusercontent.com/20620501/63112546-7e929700-bfb6-11e9-96a4-587aed25f275.jpg)
