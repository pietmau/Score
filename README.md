# PLEASE NOTE!
The application comes in two flavours: **prod** and **mock** (the mock flavour uses a mock Model dependency).

1. To run the app please select the **prod** flavour.

2. To run the UI tests please select the **mock** flavour.

###  Tests
**Junit** and **UI tests** are in the respective directories.

- The use of the MVP pattern allows the Junit tests to be complete and effective: the View is dumb and contains
no logic, all the logic is in the Presenter that can be tested thoroughly with Junit only.

- The Ui tests are executed using Espresso.


###  MVP
The application uses the MVP pattern.

MVP allows to test business logic using Junit only.

MVP enables maintainability, testability, extensibility, scalability.

###  Errors
The app handles networking errors by showing a SnakcBar.

Other errors cases can be added using the MVP pattern.

###  Adding features
Other features can be added using **Dependency Injection** (the application uses Dagger 2) and MVP.

###  The Custom View
The score is represented using an original Custom View (`ScoreView`), the code of the Custom View is in the **scoreview module**

###  The Custom View
The score is represented using an original Custom View (`ScoreView`), the code of the Custom View is in the **scoreview module**


###  Saving and restoring the state
The the network request is cached using the `Observer.cache()` operator (http://reactivex.io/RxJava/javadoc/rx/Observable.html#cache())
the `Observer` will emit again its values when subscribed again.

The `Observer` itself is saved using the method described here [Caching the network request](#caching-the-network-request).

After a configuration change the `Presenter` subscribes again, and sets again the view in the correct state.

This is one possible approach, saving the state of the Activity in `onSaveInstanceState(Bundle bundle)` is good practice also.
The Custom View
saves its state in `onSaveInstanceState` (using Icepick for simplicity).


#  Librarires:

###### RxAndroid
Used to perform networking in a reactive manner.

###### Dagger 2
Used to perform dependency injection of the Model/View/Presenter/Api.

###### Mockito
Because tests are much more powerful and concise.

###### Espresso
Used for UI tests.

###### Retrofit + Gson
Because it's expressive, simple and powerful.

###### Butterknike
To avoid boilerplate code with not much meaning.

###### Icepick
Because the Custom View has 14 custom attributes that need to be saved and restored.


### Caching the network request

The application keeps the `Observable` that contains the network request so that it survives configuration changes.

It is preserved using `FragmentActivity.onRetainCustomNonConfigurationInstance()`;
it is a similar approach to the one used by FragmentActivity to preserve Loaders and Fragments
(please see `FragmentActivity.onRetainNonConfigurationInstance()` source).

Other methods are available to preserve the Presenters and other objects that need to outlive configuration changes
(but it is not possible to save it the bundle like a view status, because cannot be serialized):

 - use a started and bound Service that will perform the request even the activity is being destroyed and recreated;
 - use retained/headless Fragments;
 - store it in the Application class or in a static field (not a reliable solution);
 - store it in Loaders;
 - other methods...

