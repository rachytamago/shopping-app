## Purchase Flow Test

Note: this is my first time using the Jetpack Compose libraries... hopefully it doesn't have too much Espresso energy.

### 1. When navigating to different screens in Scenario 1:

#### a. How do you know the test went to the next screen? What if the network connection is slow?

I have created a `WaitHelper` and used it to check for the slowest loading elements (images, buttons, etc...) before proceeding with the steps on the next page. Also, by using `AndroidComposeTestRule` instead of `ComposeContentTestRule` the activity name can be asserted against the expected screen when asserting the layout - this will automatically log the activity/screen name if it is not the expected result, but could be updated to log the name by default too.

In addition I have experimented with a listener and rule which automatically log the activity name when it is changed by overriding `onCreate` from `ComponentActivity` (I would need to support `AppCompatActivity` if it wasn't a Compose only app. I'm not confident this will work in its current state but wanted to demonstrate the idea.

#### b. Implement an internal method that handles this ✔

i. make sure that this method is available to be used on all the different screens ✔

ii. log the screen the user is in currently right after the transition to the new screen is assured (new screen loaded) ✔

### 2. Following the documentation from Jetpack Compose (or the framework of your choice)

#### a. What is required before the test starts?

A test rule or `composeTestRule.setContent { }` is required to launch the activity or component. For the purpose of this test I am just launching the main activity under the assumption that it is the Login screen, however multiple rules could be used for different purposes such as launching different activities or setting permissions or location mocking.

It is also likely to that I'd need to clear all cached data before launching the app, which could be done using `composeTestRule.setContent { }`, however I am not that familiar with Compose compared to Espresso so have stuck to the rule route for this project.

Preconditions can also be set in the test rule or `@Before` depending on if they are likely to be used in other test classes.

i. add what you considered is required (if it is) ✔

ii. if you consider adding the before steps, don’t forget about point 1. from Exercise 2

For the purchase flow login will always be required so this can, in theory, be executed in the `@Before` steps however, this only makes sense if all the tests in this class require the same user login, which I believe is unlikely. Therefore I have opted to keep login in the specific tests.

### 3. What do you think of the bonus point (5a.) in Scenario 1?
#### a. Please briefly explain your thoughts

It is important the ensure the correct items have been added to the cart, as well as the quantities of those items are correct. This is a high priority feature due to the potential to over or under charge the customer, or send the wrong items.

I implemented a function to get the name of the item when adding it to the cart, and the quantities of that item. In addition to checking the cart badge value at all stages, the contents can now be checked in more detail at both the cart and checkout confirm stages. 
