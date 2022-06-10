## PendingIntent

As you know, an [Intent](https://hyperskill.org/learn/step/11965) is a messaging object that helps your app interact with other app components. In this topic, you will learn how to use a `PendingIntent` to specify an action to take in the future, such as providing a reminder or an alarm.

##### About PendingIntent

A `PendingIntent` is an object that wraps an `Intent` so we can pass it to another application: it allows the receiving application to execute the `Intent` with the same permissions as our app. One of the nice things about a `PendingIntent` is that it can be fired even after our application's process has been killed. PendingIntents are commonly used with the `AlarmManager` or `NotificationManager` to implement notification functionality, and we will be covering these examples later in this topic. They can also be used with `RemoteViews` (custom notifications or widgets).

Keep in mind that a `PendingIntent` almost always needs to be **explicit**. This means that it should have the component name explicitly set to one of your components to make sure it gets sent to the correct place.

##### Creating a PendingIntent

Before creating a `PendingIntent`, you first need to define the `Intent` you wish to use with it. You can then create the `PendingIntent` with the required method: `getActivity()`, `getBroadcast()`, or `getService()`.

Arguments must also be passed to these four parameters:

- `context` : gives the Context of the caller.
- `requestCode`: can be used to differentiate the `PendingIntent` from others.
- `intent`: the `Intent` that will be used to call the Activity, Broadcast, or Service.
- `flags`: affects the behavior of the PendingIntent.

Here is an example:

```kotlin
val intent = Intent(applicationContext, Receiver::class.java)
val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
```

There are several flags available:

- `FLAG_CANCEL_CURRENT`: if the `PendingIntent` already exists, the current instance will be canceled before a new one is generated. You can use this to retrieve a new `PendingIntent` only when changing the extra data in the `Intent`. By canceling the previous `PendingIntent`, only entities with the new data will be able to launch it. Simply speaking, this flag makes the old `PendingIntent` invalid, so only the new one will work. If you're wondering how Android checks whether PendingIntents are equal: they match if the `requestCode`, `Intent` action, category, data, MIME-type, package, and component are all equal. Any extra data is ignored.
- `FLAG_IMMUTABLE`: the created `PendingIntent` must be immutable.
- `FLAG_NO_CREATE`: if the described `PendingIntent` doesn't exist, it will return null instead of creating it.
- `FLAG_ONE_SHOT`: this `PendingIntent` can be used only once.
- `FLAG_UPDATE_CURRENT`: if the `PendingIntent` exists, its extra data will be replaced. Useful when you're creating PendingIntents where only the extras change.

##### PendingIntent and notifications

You might have noticed that clicking an app notification usually takes you to the app that sent it. This is an example of how a `PendingIntent` can be used, so let's try to implement this behavior!

Imagine you are creating a reminder app that should provide users with task notifications at specified times. (This scenario will be explored in greater detail in the "Posting notifications" topic.)

To achieve this, you first need to define an `Intent` that will open your activity:

```kotlin
val intent = Intent(context, MainActivity::class.java)
```

You then need to create a `PendingIntent` that will be fired when the notification is clicked:

```kotlin
val pIntent = PendingIntent.getActivity(context, 0, intent, 0)
```

Almost there! Now, in your Notification builder, add the `.setContentIntent(pIntent)` line:

```kotlin
val notificationBuilder = NotificationCompat.Builder(context, "channel1")
    .setContentTitle("Reminder")
    .setContentText("Time to study!")
    //your other notification settings here
    .setContentIntent(pIntent)
```

Done! When this notification is clicked, your Activity will pop up on the screen.

##### PendingIntent and alarms

In some cases, you might need to execute something at a certain time of day. Apps like alarms, to-do lists, reminders, and calendars usually have a "Remind at" option. I expect you've already guessed that a `PendingIntent` can help us here, too! But how can you fire an `Intent` at a particular time?

The **Alarm Service** is used to send one-off (or recurring) messages at a given time. These alarms don't depend on a specific app, and that's why they can be used to trigger events owned by your app even if it's closed.

In this example, we'll create a notification to be provided at a certain moment in time. The details will be hard-coded in this case, but you could easily make them editable. We will use a calendar instance to set the date and time:

```kotlin
val calendar = Calendar.getInstance()
calendar.set(Calendar.YEAR, 2038)
calendar.set(Calendar.MONTH, Calendar.JANUARY)
calendar.set(Calendar.DAY_OF_MONTH, 19)

calendar.set(Calendar.HOUR_OF_DAY, 3)
calendar.set(Calendar.MINUTE, 14)
calendar.set(Calendar.SECOND, 7)
val chosenTime = calendar.timeInMillis
```



Keep in mind that months in `Calendar.MONTH` begin at 0 (0 - January, 1 - February, and so on). You can use the name of the month instead of its number, though.



We now need to create an `Intent` and a `PendingIntent` using the technique described earlier. Next, get the `AlarmManager` and use a `.set()` method to set a one-time alarm:

```kotlin
val intent = Intent(applicationContext, Receiver::class.java)
val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)

val am: AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
am.set(AlarmManager.RTC_WAKEUP, chosenTime, pendingIntent)
```

So, that's it. At the defined time, your alarm will fire a `PendingIntent` and... nothing will happen. Why? Because the app still doesn't know what to do with it! To fix the problem, we need to receive the `PendingIntent` with a `BroadcastReceiver`.

A `BroadcastReceiver` responds to broadcast messages from system or other applications. To achieve this, a new class that extends the `BroadcastReceiver` must be created. We also need to implement an `onReceive()` method that contains the code to fire a notification:

```kotlin
class Receiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val intent = Intent(context, MainActivity::class.java)
        val pIntent = PendingIntent.getActivity(context, 0, intent, 0)
        val notificationBuilder = NotificationCompat.Builder(context, "channel1")
            .setSmallIcon(R.drawable.photo)
            .setContentTitle("Reminder")
            .setContentText("Time to study!")
            .setStyle(NotificationCompat.BigTextStyle())
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(pIntent)
        val mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotificationManager.notify(1, notificationBuilder.build())
    }
}
```

To complete the final step, head to `AndroidManifest.xml` and add the line `<receiver android:name=".Receiver"/>` . If you specified a different name for your receiver class, just change `".Receiver"` to the name you used.

Now your notifications will arrive at the selected time.

##### Conclusion

In a nutshell, a `PendingIntent` lets you authorize another application to fire an `Intent` with the same permissions as your app. It takes four arguments: `context`, `requestCode`, `intent`, and `flags`; and can be fired even if your app is closed. PendingIntents are normally utilized to create notifications and can also be used with `RemoteViews`. Now it's time for some practice!