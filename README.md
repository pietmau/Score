#####  ATTENTION!

#####  Approcha

#####  config changes

#####  Test

#####  MVP

#####  Customview

careful 2 buid falvours!!!!

#####  Libriaires used

- 2 layouts

- mvp

- rx

- dagger

- custom view

- mockito

- espresso

- retrofit

- butterknike

- icepick


#####  Cache the network request

The application caches the network request so that it does not get wasted in case that a configuration change happens in the meanwhile.

It is cached using `FragmentActivity.onRetainCustomNonConfigurationInstance`
(it is the approach used by FragmentActivity to preserve loaders and fragments).

Other methods are available to avoid losing the ongoing network request in case of configuration changes
(but it is not possible to save it the bundle like some view status, because cannot be serialized):

 - Use a started and bound Service that will perform the request even the activity is being destroyed and recreated;
 - Use a retained/headless Fragment;
 - Store it in the Application class or in a static field (not a reliable solution);
 - other...

