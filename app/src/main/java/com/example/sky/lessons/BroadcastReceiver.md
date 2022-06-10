## BroadcastReceiver

Suppose you're creating an application for travelers and want to display a Toast every time *Airplane mode* is changed on the user's phone. You can use `BroadcastReceiver` for this purpose — it enables you to track phone events like timezone and *Airplane mode* changes.

Read on to learn more about `BroadcastReceiver` and find out how to use it in your apps.

##### What is BroadcastReceiver?

`BroadcastReceiver` is a component that responds to broadcast messages throughout the system. These can be messages from both the system itself and from any application (including yours). Examples of system messages include a change of date or time (DATE/TIME_CHANGED), turning on *Airplane mode* (AIRPLANE_MODE_CHANGED), a change in battery status (BATTERY_CHANGED/LOW/OKAY), and so on.



Each broadcast message is wrapped in an Intent. The Intent's **action** string identifies the event that has occurred (`android.intent.action.AIRPLANE_MODE`, for example).



##### How is BroadcastReceiver used?

You start by creating your `BroadcastReceiver`:

```kotlin
class YourBroadcastReceiver : BroadcastReceiver() {
    
}
```

If you don't want to do this manually, Android Studio enables you to create a `BroadcastReceiver` using a ready-made template:

<img src="https://ucarecdn.com/c787b93b-0b21-487a-bd57-3a2db0138c89/" alt="img" style="zoom:80%;" />

The receiver must have an `onReceive()` method. This method is called when the `BroadcastReceiver` is receiving an Intent broadcast:

```kotlin
override fun onReceive(context: Context, intent: Intent) {
    //Your code here
}
```

Receivers can either be **static** or **dynamic**. The static option is when the `BroadcastReceiver` subclass is added to the manifest file, and the dynamic option is when the `BroadcastReceiver` instance is **registered** during the application lifetime.

The main difference between these options is that a static receiver will work whether the application is running or not — if your app isn't already running the system will launch it when the broadcast is sent. By contrast, dynamic receivers are only triggered when the application is running. So, all dynamic receivers are unregistered at the point of application death.

First, let's look at how to use a static receiver. With this option, you only need to declare the receiver in the *AndroidManifest.xml* file inside *application* block:

```xml
<receiver
    android:name=".YourBroadcastReceiver"
    android:enabled="true"
    android:exported="true">
    <intent-filter>
        <action android:name="android.intent.action.AIRPLANE_MODE" />
    </intent-filter>
</receiver>
```

It's as simple as that. Now, when you execute the specified action, the `onReceive()` method will also be triggered.

You can see an example of a `BroadcastReceiver` that sends a Toast message when *Airplane mode* is changed below:

<img src="https://ucarecdn.com/57d4630d-74fb-420b-8fa1-2e77f357bd7a/" alt="img" style="zoom:25%;" />


Dynamic receivers are created differently. You don't need to use the manifest file because the receiver will be instantiated and registered directly in the code. Instead, you need to create the receiver and a filter to check for the action you have selected. This is done in the following way:

```kotlin
val receiver: BroadcastReceiver = YourBroadcastReceiver()
val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
applicationContext.registerReceiver(receiver, filter)
```

As you can see above, the final step is to register the receiver. Now, when you execute the specified action, the `onReceive()` method will fire, too.

If you want to turn off your receiver, just add this line at the point where you wish to unregister it:

```kotlin
applicationContext.unregisterReceiver(receiver)
```

Following this, the receiver will no longer be available.

##### Multiple actions

You may need your application to respond to more than one type of message. Both AIRPLANE_MODE_CHANGED and DATE_CHANGED, for example. So, what's the best way to implement this behavior? Should you add a separate filter for each action or use one filter for them all? The second option is a better way to go. You can do everything with a single filter, so there's no need to create several.

You can see how to add multiple actions using the static approach below:

```xml
<receiver
    android:name=".YourBroadcastReceiver"
    android:enabled="true"
    android:exported="true">
    <intent-filter>
        <action android:name="android.intent.action.AIRPLANE_MODE" />
        <action android:name="android.intent.action.DATE_CHANGED" />
    </intent-filter>
</receiver>
```

And the following example demonstrates how to add more than one action dynamically:

```kotlin
val filter = IntentFilter().apply {
    addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
    addAction(Intent.ACTION_DATE_CHANGED)
}
```

If you need a different result for each action, you can use a `when` expression in your `onReceive()` method:

```kotlin
when (intent.action) {
    Intent.ACTION_AIRPLANE_MODE_CHANGED ->
        Toast.makeText(context, "Airplane mode was changed", LENGTH_LONG).show()
    Intent.ACTION_DATE_CHANGED ->
        Toast.makeText(context, "The date was changed", LENGTH_LONG).show()
}
```

Now the user will see a different Toast message when each action is performed.

Bear in mind that you can add several actions to your filter and create unique messages for them all. The examples in this section are only limited to two for the sake of simplicity.

##### Conclusion

`BroadcastReceiver` is a very useful tool that can respond to system and application messages. Before using it, you need to decide whether you want to create your receiver statically or dynamically. Don't forget that you can add multiple actions to your receiver using a single filter.